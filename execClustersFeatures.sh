#!/bin/sh


group=$1
fileLogFC=$2
fileCounts=$3
delta=$4
sep=$5
output=${6}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "File log FC:        $fileLogFC"
echo "File Counts:	$fileCounts"
echo "delta:	$delta"
echo "Sep:	$sep"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $fileLogFC $fileCounts $delta $sep' ./Rscripts/ClustersFeatures.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
