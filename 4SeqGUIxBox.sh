#!/bin/sh
cd /home/user/4SeqGUI
path=${PWD}/dist

#java -jar "$path/4SeqGUI.jar" 
java -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel -jar "$path/4SeqGUI.jar" %F
