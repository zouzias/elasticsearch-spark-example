package org.zouzias.elasticsearch.spark

import org.apache.spark.{SparkConf, SparkContext}

object ElasticSparkHelloWorld {
  def main(args: Array[String]) {

    // initialise spark context
    val conf = new SparkConf().setAppName("SparkElasticHelloWorld")
    val sc = new SparkContext(conf)

    // do stuff
    println("************")
    println("************")
    println("Hello, world!")
    println("************")
    println("************")

    // terminate spark context
    sc.stop()

  }

}
