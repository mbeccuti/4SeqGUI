#!/bin/sh

group=$1
 file=$2
outputname=$3
normMethod=$4
output=${5}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:	$group"
echo "file:        $file"
echo "outputname:	$outputname"
echo "norm Method:	$normMethod"




echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $file $outputname $normMethod' ./Rscripts/UmiNorm.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
