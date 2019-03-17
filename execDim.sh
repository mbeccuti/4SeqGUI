#!/bin/sh

group=$1
scratch=$2
 file=$3
separator=$4
output=${5}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:	$group"
echo "scratch folder:	$scratch"
echo "file:        $file"
echo "separator:	$separator"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $scratch $file $separator' ./Rscripts/dim.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
