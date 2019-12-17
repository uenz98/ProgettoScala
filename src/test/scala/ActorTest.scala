
import entities.Actor
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class ActorTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)
    val jsonDF = sqlContext.read.json("C:\\Users\\Musta\\Desktop\\jsonDF\\actorTest.json")

    import sqlContext.implicits._
    val rdd = jsonDF.as[Actor].rdd

    rdd.foreach(println)

    assert(true)
  }
}
