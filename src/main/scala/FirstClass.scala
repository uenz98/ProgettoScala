import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

object FirstClass{
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("CountingSheep")

    val sc = new SparkContext(conf)

    //parsing JSON
    val sqlContext = new HiveContext(sc)

    val jsonDF = sqlContext.read.json("C:\\Users\\Studente\\Desktop\\gesudinazaret\\2018-03-01-0.json.gz")
    //println(jsonDF.toString)

    jsonDF.show

  }
}