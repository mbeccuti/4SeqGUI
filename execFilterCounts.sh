#!/bin/sh



datafolrde=$1
type=$2
outputfolder=$3
output=$4
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Input file:              $datafolder"
echo "Data type:               $type"
echo "Output folder:           $outputfolder"
echo "Output:                  $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $datafolder $type  $outputfolder   ' ./Rscripts/FilterCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "		       END EXECUTION"
echo "======================================================="
