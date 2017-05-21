#!/bin/sh
cd 2.x/
sbt ++$TRAVIS_SCALA_VERSION clean update assembly
