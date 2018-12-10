#!/bin/bash

group=$1
scratchfolder=$2
circrnafile=$3
exonfile=$4
assembly=$5
outputdir=$6

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "CircRNA file:        $circrnafile"
echo "Exon file:        $exonfile"
echo "Assembly version:	$assembly"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $circrnafile $exonfile $assembly ' ./Rscripts/CircJunctions.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
