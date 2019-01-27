#!/bin/sh

path=${PWD}/dist

#java -jar "$path/4SeqGUI.jar" 
#export _JAVA_OPTIONS="-Dawt.useSystemAAFontSettings=on  -Dswing.aatext=true -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel -Dswing.crossplatformlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel -Djdk.gtk.version=2 ${_JAVA_OPTIONS}"
#java -Dsun.java2d.d3d=false -Djdk.gtk.version=2 -jar "$path/4SeqGUI.jar"  for java 10
java -Dsun.java2d.d3d=false  -jar "$path/4SeqGUI.jar"
