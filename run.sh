#!/usr/bin/env bash

mvn -q install > /dev/null

cat <<END
**************************************************
Executing the example jar
**************************************************
END

java -jar ./example/target/example-1.0-SNAPSHOT.jar

cat <<END
**************************************************
Executing the example jar using the profiler agent
**************************************************
END

java -javaagent:./profiler/target/profiler-1.0-SNAPSHOT.jar -jar ./example/target/example-1.0-SNAPSHOT.jar

