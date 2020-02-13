
import entities.Payload
import entities.schemas.PayloadForSchema
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class PayloadTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)

    val schema = ScalaReflection.schemaFor[PayloadForSchema].dataType.asInstanceOf[StructType]

    schema.foreach(println)

    val jsonDF = sqlContext.read
      .schema(schema)
      .json("payloadTest1.json")

    jsonDF.show
    val jsonRenamed =
    jsonDF.withColumnRenamed("private", "privateField")
    .withColumnRenamed("public", "publicField")
    .withColumnRenamed("default", "defaultField")

    jsonRenamed.show

    import sqlContext.implicits._
    val rdd = jsonRenamed.as[Payload].rdd

    rdd.foreach(println)

    assert(true)
  }
}
