#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nCluster=$4
separator=$5
framePP=$6
permutationNumber=$7
output=${8}
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
echo "framePP:	$framePP"
echo "permutationNumber:	$permutationNumber"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nCluster $separator $framePP $permutationNumber' ./Rscripts/BootstrapsVideo.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
