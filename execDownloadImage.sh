#!/bin/sh



containersfile=$1
output=$2
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Container file:          $containersfile"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"



args="R CMD BATCH --no-save --no-restore  '--args   ${containersfile} ' ./Rscripts/DownloadImage.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
