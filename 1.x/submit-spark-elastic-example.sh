#!/usr/bin/env bash

# Directory where spark-submit is defined
# Install spark from https://spark.apache.org/downloads.html
#
# Works in mac
# TODO: fix it for linux
USER=$(whoami)
SPARK_HOME=/Users/${USER}/spark-1.6.3-bin-hadoop2.6

# JAR containing a simple hello world
JARFILE=`pwd`/target/scala-2.11/elasticsearch-spark-example-assembly-0.1.0.jar

# Run it locally
${SPARK_HOME}/bin/spark-submit --class org.zouzias.elasticsearch.spark.ElasticSparkHelloWorld \
                                --master local \
                                --packages org.elasticsearch:elasticsearch-spark_2.11:2.4.4 \
                                ${JARFILE}
