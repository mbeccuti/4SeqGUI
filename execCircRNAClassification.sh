#!/bin/bash

group=$1
scratchfolder=$2
circrnafile=$3
exonfile=$4
isoformfile=$5
assembly=$6
outputdir=$7

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "CircRNA file:        $circrnafile"
echo "Exon file:        $exonfile"
echo "Isoform file:     $isoformfile"
echo "Assembly version:	$assembly"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $circrnafile $exonfile $isoformfile $assembly ' ./Rscripts/CircJunctions.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
