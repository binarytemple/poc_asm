#!/usr/bin/env bash

mvn -q install

cat <<END
********************************************************
Executing the annotation example jar 
********************************************************
END

java -jar ./annot-example/target/annot-example-1.0-SNAPSHOT.jar

cat <<END
********************************************************
Executing the annotation example jar with enhancer agent
********************************************************
END

java -javaagent:./enhancer/target/enhancer-1.0-SNAPSHOT.jar  -jar ./annot-example/target/annot-example-1.0-SNAPSHOT.jar
