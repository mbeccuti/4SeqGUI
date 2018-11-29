#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
sep=$4
seed=$5
cutoff=$6
species=$7
rawCount=$8
output=$9
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
echo "seed:	$seed"
echo "cutoff:	$cutoff"
echo "species:	$species"
echo "rawCount:	$rawCount"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $sep $seed $cutoff $species $rawCount' ./Rscripts/CcRemove.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
