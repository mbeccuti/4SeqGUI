#!/bin/sh



experimentfolder=$1
covariates=$2
batchs=$3
outputfolder=$4
output=$5
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Sample Folder:           $experimentfolder"
echo "Groups:                  $covariates"
echo "Batchs:                  $batchs"
echo "Biological type:         $outputfolder"
echo "Output Prefix:           $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${experimentfolder} ${covariates} ${batchs}  $outputfolder ' ./Rscripts/miRNACovar.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
