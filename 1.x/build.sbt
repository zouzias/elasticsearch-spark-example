name := "elasticsearch-spark-example"

version := "0.1.0"

organization := "org.zouzias"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

// Versions
val sparkVersion = "1.6.3"
val ElasticV = "1.7.4"

libraryDependencies ++= Seq(
  "com.sksamuel.elastic4s" 	%% "elastic4s-core"    	    % "1.7.4" exclude("org.elasticsearch", "elasticsearch"),
  "org.elasticsearch" 		% "elasticsearch"           % ElasticV,
  "org.elasticsearch" 		%% "elasticsearch-spark"    % "2.1.2" % "provided",
  "com.typesafe"      		% "config"                  % "1.2.1",
  "org.apache.spark"  		%% "spark-core"             % sparkVersion % "provided" exclude("org.spark-project.spark", "unused"),
  "org.apache.spark"  		%% "spark-sql"              % sparkVersion % "provided" exclude("org.spark-project.spark", "unused"),
  "org.scalatest"     		%% "scalatest"              % "2.2.5" % "test"
)
