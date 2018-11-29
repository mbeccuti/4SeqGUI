#!/bin/sh


group=$1
scratchfolder=$2
file=$3
nCluster=$4
separator=$5
lfn=$6
geneNameControl=$7
status=$8
b1=$9
b2=${10}
output=${11}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Scratch Folder:	$scratchfolder"
echo "file:	$file"
echo "nCluster:	$nCluster"
echo "separator:	$separator"
echo "lfn:	$lfn"
echo "geneNameControl:	$geneNameControl"
echo "status:	$status"
echo "b1:	$b1"
echo "b2:	$b2"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nCluster $separator $lfn $geneNameControl $status $b1 $b2' ./Rscripts/Hfc.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
