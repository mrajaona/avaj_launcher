#!/bin/sh

/usr/bin/find . -name '*.java' > sources.txt \
&& /usr/bin/javac -d . @sources.txt
# && /usr/bin/javac -verbose -sourcepath @sources.txt
