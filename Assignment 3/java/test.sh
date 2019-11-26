#!/bin/bash
rm -rf cpsc331/assignment3/*.class
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar cpsc331/assignment3/*.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore cpsc331.assignment3.TestSort
