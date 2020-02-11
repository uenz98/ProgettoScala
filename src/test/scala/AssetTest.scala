
import entities.Payload
import entities.payloadComponents.{Asset, User}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class AssetTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)
    import sqlContext.implicits._
    val schema = ScalaReflection.schemaFor[Asset].dataType.asInstanceOf[StructType]

    val jsonDF = sqlContext.read
      .schema(schema)
      .json("assetTest.json")

    jsonDF.show

    val rdd: RDD[Asset] = jsonDF.as[Asset].rdd

    rdd.foreach(println)

    assert(true)
  }
}
