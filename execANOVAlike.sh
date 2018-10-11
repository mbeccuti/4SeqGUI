#!/bin/sh


group=$1
file=$2
logFCthreshold=$3
FDRthreshold=$4
logCPMthreshold=$5
output=${6}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Input file:        $file"
echo "logFCthreshold:    $logFCthreshold"
echo "FDRthreshold:	 $FDRthreshold"
echo "logCPMthreshold:   $logCPMthreshold"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $file  $logFCthreshold $FDRthreshold $logCPMthreshold' ./Rscripts/ANOVAlike.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
