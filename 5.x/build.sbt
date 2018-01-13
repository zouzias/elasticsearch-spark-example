name := "elasticsearch-spark-example"

version := "0.1.0"

organization := "org.zouzias"

scalaVersion := "2.11.12"

crossScalaVersions := Seq("2.11.12")

// Versions
val sparkVersion = "2.1.2"
val ElasticV = "5.6.5"

libraryDependencies ++= Seq(
  "com.sksamuel.elastic4s" 	%% "elastic4s-core"    	  % "5.6.1" exclude("org.elasticsearch", "elasticsearch"),
  "org.elasticsearch" 		% "elasticsearch"           % ElasticV,
  "org.elasticsearch" 		%% "elasticsearch-spark-20" % "5.6.5" % "provided", // Provided is important here for assembly
  "com.typesafe"      		% "config"                  % "1.2.1",
  "org.apache.spark"  		%% "spark-core"             % sparkVersion % "provided" exclude("org.spark-project.spark", "unused"),
  "org.apache.spark"  		%% "spark-sql"              % sparkVersion % "provided" exclude("org.spark-project.spark", "unused"),
  "org.scalatest"     		%% "scalatest"              % "3.0.4" % "test"
)

// Elasticsearch *copies* joda-time code and patch it into their codebase. It causes several issues
// see https://www.elastic.co/blog/to-shade-or-not-to-shade
assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("org.joda.time.base.**" -> "org.elasticsearch.joda.time.@1").inLibrary("org.elasticsearch" % "elasticsearch" % ElasticV).inProject
)
