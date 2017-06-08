#!/bin/sh

experimenttable=$1
type=$2
log2fc=$3
fd=$4
refcov=$5
outputfolder=$6
batch=$7
output=$8
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Input file:              $experimenttable"
echo "Data type:               $type"
echo "Log2fc threshold:        $log2fc"
echo "FDR threshold:           $fd"
echo "Covariates:              $refcov"
echo "Output folder:           $outputfolder"
echo "Batches"                 $batch
echo "Output:                  $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $experimenttable $type $log2fc $fd $refcov $outputfolder $batch ' ./Rscripts/DES.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "		       END EXECUTION"
echo "======================================================="
