import entities.JsonToParse
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

    for(line <- file.getLines()) {

      import java.io.PrintWriter
      new PrintWriter("tmp.json") { write(line); close() }

      val rdd:RDD[JsonToParse] = Utility.fromFilePathJSONToRDD("tmp.json", sqlContext)

      println(rdd)

    }

    file.close()
  }
}