
import entities.Payload
import entities.payloadComponents.Pages
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class PagesTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)

    val schema = ScalaReflection.schemaFor[Pages].dataType.asInstanceOf[StructType]

    val jsonDF = sqlContext.read.schema(schema).json("pagesTest.json")

    jsonDF.show
    import sqlContext.implicits._
    val rdd = jsonDF.as[Pages].rdd

    rdd.foreach(println)

    assert(true)
  }
}
