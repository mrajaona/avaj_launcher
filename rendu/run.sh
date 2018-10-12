#!/bin/sh

/usr/bin/find . -name '*.java' > sources.txt \
&& /usr/bin/javac -sourcepath @sources.txt \
&& /usr/bin/java -cp . avaj.simulator.Simulator