#!/bin/sh
pushd 1.x/
sbt ++$TRAVIS_SCALA_VERSION clean update assembly
popd
