#!/bin/bash
echo $PWD
cd $PWD
cd ../
echo $PWD
mvn clean test -Dbrowser=chrome