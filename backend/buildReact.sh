#!/bin/bash

export M2_HOME=/opt/apache-maven-3.9.2
export M2=/opt/apache-maven-3.9.2/bin
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.19.0.7-4.0.1.el8.x86_64

export PATH=$PATH:$HOME/bin:$M2:$JAVA_HOME/bin

/usr/bin/pkill -f with-dependencies
pwd
echo $1
cd $1
npm install
npm run build
exit 0
