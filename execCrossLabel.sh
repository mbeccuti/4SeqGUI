#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nCluster=$4
separator=$5
finalName=$6
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
echo "Final Name:	$finalName"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nCluster $separator $finalName ' ./Rscripts/crossLabel.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
