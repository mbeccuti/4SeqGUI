#!/bin/bash

group=$1
scratchfolder=$2
samfile=$3
cirifile=$4
genomefile=$5
annotationfile=$6
outputdir=$7

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Alignment File:       $samfile"
echo "CIRI2 File:        $cirifile"
echo "Genome File       $genomefile"
echo "Annotation File:      $annotationfile"
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $samfile $cirifile $genomefile $annotationfile ' ./Rscripts/CircGetStructure.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
