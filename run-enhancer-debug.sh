#!/usr/bin/env bash

source ./etc/verify

mvn -q install > /dev/null

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=1044 -javaagent:./enhancer/target/enhancer-1.0-SNAPSHOT.jar  -jar ./annot-example/target/annot-example-1.0-SNAPSHOT.jar
