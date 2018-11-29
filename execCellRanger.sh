#!/bin/sh
group=$1
 scratchfolder=$2
 fastqfolder=$3
transcriptomefolder=$4
expectcells=$5
nosecondary=$6
output=$7
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "fastq folder:        $fastqfolder"
echo "transcriptome folder:	$transcriptomefolder"
echo "expect cells:	$expectcells"
echo "no secondary:	$nosecondary"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $transcriptomefolder $fastqfolder $expectcells $nosecondary $scratchfolder' ./Rscripts/indropCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
