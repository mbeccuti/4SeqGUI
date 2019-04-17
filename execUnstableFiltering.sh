#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
separator=$4
nCluster=$5
sThreshold=$6
output=${7}
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "file:        $file"
echo "nCluster:	$nCluster"
echo "separator:	$separator"
echo "sThreshold:	$sThreshold"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $separator $nCluster $sThreshold' ./Rscripts/unstableFiltering.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
