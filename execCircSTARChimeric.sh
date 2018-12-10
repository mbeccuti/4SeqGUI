#!/bin/bash

group=$1
scratchfolder=$2
genomefolder=$3
fastqfolder=$4
nthreads=$5
chim_segment_min=$6
chim_junction_min=$7
outputdir=$8

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Genome Folder:        $genomefolder"
echo "FASTQ Folder:     $fastqfolder"
echo "Num of threads:        $nthreads"
echo "ChimSegmentMin:       $chim_segment_min"
echo "ChimJunctionOverhangMin:      $chim_junction_min"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $genomefolder $fastqfolder $nthreads $chim_segment_min $chim_junction_min ' ./Rscripts/CircSTARChimeric.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
