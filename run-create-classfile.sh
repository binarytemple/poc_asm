#!/usr/bin/env bash

source ./etc/verify

mvn -q install > /dev/null

pushd . 
cd scratch
mvn exec:java -Dexec.mainClass="ie.hunt.HelloWorldMainDump"
popd 

cat <<END
Now going to run the generated class file from the /tmp directory.
END

java -classpath /tmp ie.hunt.HelloWorldMain    
