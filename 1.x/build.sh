#!/bin/sh
sbt ++$TRAVIS_SCALA_VERSION clean update assembly
