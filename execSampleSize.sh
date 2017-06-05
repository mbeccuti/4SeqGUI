#!/bin/sh

filename=$1
power=$2
fdr=$3
genes4dispersion=$4
log2fc=$5
outputfolder=$6
output=$7

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Input file:              $filename"
echo "Statistical power:       $power"
echo "Log2fc threshold:        $log2fc"
echo "FDR threshold:           $fdr"
echo "#gene for dispertion:    $genes4dispersion"
echo "Output:                  $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $filename $power $fdr ${genes4dispersion} $log2fc $outputfolder' ./Rscripts/SampleSize.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "		       END EXECUTION"
echo "======================================================="
