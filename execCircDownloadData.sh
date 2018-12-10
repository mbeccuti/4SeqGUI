#!/bin/bash

group=$1
scratchfolder=$2
datafolder=$3
assembly=$4
outputdir=$5

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Data folder:        $datafolder"
echo "Assembly version:	$assembly"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $datafolder $assembly ' ./Rscripts/CircDownloadData.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
