#!/usr/bin/env bash

cat <<END
**************************************************
Executing the example jar
**************************************************
END

java -jar ./example/target/example-1.0-SNAPSHOT.jar


cat <<END
**************************************************
Executing the vanilla jar using the enhancer agent 
**************************************************
END

java -javaagent:./enhancer/target/enhancer-1.0-SNAPSHOT.jar -jar ./example/target/example-1.0-SNAPSHOT.jar
