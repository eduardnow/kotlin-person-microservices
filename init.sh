#!/bin/bash
r=`pwd`


# person-ms
echo ""
echo "Buil: person-ms"
echo ""
cd $r/person-ms/
gradle clean bootJar # Skip all tests: Incomplete status


# person-api
echo ""
echo "Buil: person-api"
echo ""
cd $r/person-api/
gradle clean bootJar # Skip all tests: Incomplete status

cd $r # home

echo ""
echo "Buil: completed"
echo ""