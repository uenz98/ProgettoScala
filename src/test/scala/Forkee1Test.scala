
import entities.{Actor, Payload}
import entities.payloadComponents.Forkee
import entities.schemas.ForkeeForSchema
import org.apache.spark.sql.Encoder
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class Forkee1Test extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val sqlContext = new HiveContext(sc)
    val schema = ScalaReflection.schemaFor[ForkeeForSchema].dataType.asInstanceOf[StructType]

    val jsonDF = sqlContext.read
      .schema(schema)
      .json("forkee1Test.json")

    jsonDF.show

    val jsonRenamed = jsonDF.withColumnRenamed("private", "privateField").withColumnRenamed("public", "publicField")
    import sqlContext.implicits._
    val rdd = jsonRenamed.as[Forkee].rdd

    rdd.foreach(println)

    assert(true)
  }
}
