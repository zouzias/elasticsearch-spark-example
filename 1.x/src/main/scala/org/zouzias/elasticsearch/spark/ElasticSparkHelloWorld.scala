package org.zouzias.elasticsearch.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.elasticsearch.spark.sql._

object ElasticSparkHelloWorld {
  def main(args: Array[String]) {

    // initialise spark context
    val conf = new SparkConf().setAppName("SparkElasticHelloWorld")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    // Elastic connection parameters
    val elasticConf: Map[String, String] = Map("es.nodes" -> "localhost",
      "es.clustername" -> "elasticsearch")

    val indexName = "test_index"
    val mappingName = "test_index_type"


    // Load DataFrame
    val df = sqlContext.read.parquet("PATH_TO_DATAFRAME")

    // Write elasticsearch
    df.saveToEs(s"${indexName}/${mappingName}", elasticConf)

    // terminate spark context
    sc.stop()

  }

}
