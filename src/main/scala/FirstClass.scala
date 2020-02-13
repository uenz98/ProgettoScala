import java.io.{File, FileWriter}

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import entities.JsonToParse
import org.apache.hadoop.hive.ql.exec.spark.session
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import util.Utility

import scala.io.Source

object Main{

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    //parsing JSON
    val sqlContext = new HiveContext(sc)

    Utility.decompressGzipFile("file.json", Utility.fileDownloader("http://data.githubarchive.org/2018-03-01-0.json.gz"))

    val file = Source.fromFile("file.json")

//    for(line <- file.getLines()) { //ogni DF viene creato a ciclo
//
//      import java.io.PrintWriter
//      new PrintWriter("tmp.json") { write(line); close() }

      val jsonDF:Dataset[JsonToParse] = Utility.fromFilePathJSONToRDD("file.json", sqlContext)
      val rdd:RDD[JsonToParse] = jsonDF.rdd

      println(rdd)

      /* QUERIES */
      //1
      val query = jsonDF.groupBy("actor").count().collectAsList()
      //crea csv e ci stampa risultato query
      val fileActor = new File("C:\\Users\\Musta\\Desktop\\actors.csv")
      val printActor = new FileWriter(fileActor)
      printActor.write(query.toString)

//    }

    file.close()

    //query


  }


}