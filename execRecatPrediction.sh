#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
sep=$4
geneNameControl=$5
window=$6
seed=$7
output=$8
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "file:        $file"
echo "sep:	$sep"
echo "gene name control:	$geneNameControl"
echo "window:	$window"
echo "seed:	$seed"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $sep $geneNameControl $window $seed' ./Rscripts/RecatPrediction.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
