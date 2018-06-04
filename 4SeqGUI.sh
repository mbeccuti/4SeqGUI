#!/bin/sh

path=${PWD}/dist

#java -jar "$path/4SeqGUI.jar" 
java   -jar "$path/4SeqGUI.jar"  -Dsun.java2d.d3d=false
