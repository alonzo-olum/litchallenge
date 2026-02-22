#!/bin/bash

javac -d ../../classes/ -cp /opt/pkgs/junit-4.13.2.jar:/opt/pkgs/hamcrest-core-1.3.jar TestTopSort.java Topsort.java 

java -cp ../../classes/:/opt/pkgs/junit-4.13.2.jar:/opt/pkgs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestTopSort
