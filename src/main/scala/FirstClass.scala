import java.io.{File, FileNotFoundException, FileWriter}
import java.util.Properties

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._
import entities.JsonToParse
import org.apache.commons.configuration.ConfigurationFactory
import org.apache.hadoop.hive.ql.exec.spark.session
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import util.{QueryUtility, Utility}

import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val properties: Properties = new Properties()

    val source = Source.fromFile("sparkConf.properties")
    properties.load(source.bufferedReader())

    val conf = new SparkConf()
      .setMaster(properties.getProperty("spark.master")).setAppName(properties.getProperty("spark.app.name"))
    val sc = new SparkContext(conf)
    //parsing JSON
    val sqlContext = new HiveContext(sc)

    Utility.decompressGzipFile("file.json", Utility.fileDownloader("http://data.githubarchive.org/2018-03-01-0.json.gz"))

    val file = Source.fromFile("file.json")

    val jsonDF: Dataset[JsonToParse] = Utility.fromFilePathJSONToDataframe("file.json", sqlContext)

    import sqlContext.implicits._
    val rdd = jsonDF.as[JsonToParse].rdd

    if(!new File("output").exists())
      new File("output").mkdir()

    /* QUERIES */
    //salvare singoli actor
    QueryUtility.createFile("output\\actor.csv", jsonDF.groupBy("actor").toString)
    //salvare singoli author
    QueryUtility.createFile("output\\author.csv", jsonDF.withColumn("author", explode($"payload.commits.author")).groupBy("payload.commits.author").toString)
    //salvare singoli repo
    QueryUtility.createFile("output\\repo.csv", jsonDF.groupBy("repo").toString)
    //trovare i vari tipi di evento
    QueryUtility.createFile("output\\eventType.csv", jsonDF.groupBy("type").toString)
    //contare author
    QueryUtility.createFile("output\\authorCount.csv", jsonDF.withColumn("author", explode($"payload.commits.author")).groupBy("payload.commits.author").count().collectAsList().toString)
    //contare repo
    QueryUtility.createFile("output\\repoCount.csv", jsonDF.groupBy("repo").count().collectAsList().toString)
    //numero event per actor
    QueryUtility.createFile("output\\eventActor.csv", jsonDF.select("actor","type").groupBy("actor").count().collectAsList().toString)
    //numero event divisi per type e actor
    QueryUtility.createFile("output\\eventActorType.csv", jsonDF.select("actor", "type").groupBy("actor", "type").count().collectAsList().toString)
    //numero event divisi per type actor e repo
    QueryUtility.createFile("output\\eventActorTypeRepo.csv", jsonDF.select("actor", "type", "repo").groupBy("actor", "type", "repo").count().collectAsList().toString)
    //numero event divisi per type actor repo e ora
    QueryUtility.createFile("output\\eventActorTypeRepoOra.csv", jsonDF.select("actor", "type", "repo", "created_at").groupBy("actor", "type", "repo", "created_at").count().collectAsList().toString)
    //contare numero commit
    QueryUtility.createFile("output\\commitsCount.csv", jsonDF.withColumn("commits", explode($"payload.commits")).groupBy("commits").count().collectAsList().toString)
    //contare numero commit per actor
    QueryUtility.createFile("output\\commitsActorCount.csv", jsonDF.withColumn("commits", explode($"payload.commits")).select("actor","commits").groupBy("actor").count().collectAsList().toString)
    //numero commit per actor e type
    QueryUtility.createFile("output\\commitsActorTypeCount.csv", jsonDF.withColumn("commits", explode($"payload.commits")).select("actor", "commits", "type").groupBy("actor", "type").count().collectAsList().toString)
    //numero commit per actor type e ora
    QueryUtility.createFile("output\\commitsActorTypeOraCount.csv", jsonDF.withColumn("commits", explode($"payload.commits")).select("actor", "commits", "created_at", "type").groupBy("actor", "type", "created_at").count().collectAsList().toString)

    file.close()

  }
}