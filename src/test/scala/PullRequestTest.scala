
import entities.Payload
import entities.payloadComponents.PullRequest
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class PullRequestTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)

    val schema = ScalaReflection.schemaFor[PullRequest].dataType.asInstanceOf[StructType]

    val jsonDF = sqlContext.read.schema(schema).json("pullRequestTest.json")

    schema.foreach(println)

    jsonDF.show
    import sqlContext.implicits._
    val datasetPull = jsonDF.as[PullRequest]

    val rdd = datasetPull.rdd
    rdd.foreach(println)

    assert(true)
  }
}
