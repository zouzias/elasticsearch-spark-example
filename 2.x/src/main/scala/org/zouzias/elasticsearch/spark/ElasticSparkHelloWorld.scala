package org.zouzias.elasticsearch.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.elasticsearch.spark.sql._
import org.elasticsearch.spark._


object ElasticSparkHelloWorld {
  def main(args: Array[String]) {

    // initialise spark context
    val conf = new SparkConf().setAppName(ElasticSparkHelloWorld.getClass.getName)
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.sqlContext.implicits._

    // Elastic connection parameters
    val elasticConf: Map[String, String] = Map("es.nodes" -> "localhost",
      "es.clustername" -> "elasticsearch")

    val indexName = "test_index"
    val mappingName = "test_index_type"

    // Dummy DataFrame
    val df = spark.sparkContext.parallelize((1 to 100).map(x => ExampleClass(x, s"${x}@gmail.com"))).toDF()

    // Write elasticsearch
    df.saveToEs(s"${indexName}/${mappingName}", elasticConf)


    // terminate spark context
    spark.stop()
  }
}
