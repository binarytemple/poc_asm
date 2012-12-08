#!/usr/bin/env bash

mvn -q install > /dev/null

Executing the scala example jar using the profiler agent
********************************************************
END

java -javaagent:./profiler/target/profiler-1.0-SNAPSHOT.jar -jar ./scala-example/target/scala-example-1.0-SNAPSHOT.jar

cat <<END

********************************************************
Executing the annotation example jar 
********************************************************
END

java  -jar ./annot-example/target/annot-example-1.0-SNAPSHOT.jar
