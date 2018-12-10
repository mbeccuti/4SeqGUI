#!/bin/bash

group=$1
scratchfolder=$2
datafolder=$3
genomefile=$4
sequencing_mode=$5
sample_id=$6
nthreads=$7
annotation_file=$8
max_span=$9
strigency=${10}
quality_threshold=${11}
outputdir=${12}

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Data Folder:        $datafolder"
echo "Genome file:      $genomefile"
echo "Sequencing type:      $sequencing_mode"
echo "Sample ID:        $sample_id"
echo "Num. threads:     $nthreads"
echo "Annotation File:      $annotation_file"
echo "Max spanning distance:        $max_span"
echo "Strigency value:      $strigency"
echo "Quality Threshold:        $quality_threshold"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $datafolder $genomefile $sequencing_mode $sample_id $nthreads $annotation_file $max_span $strigency $quality_threshold ' ./Rscripts/CircCIRI2.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
