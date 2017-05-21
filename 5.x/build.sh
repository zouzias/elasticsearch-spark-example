#!/bin/sh
cd 5.x/
sbt ++$TRAVIS_SCALA_VERSION clean update assembly
cd ../
