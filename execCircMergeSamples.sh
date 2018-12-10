#!/bin/bash

group=$1
scratchfolder=$2
datafolder=$3
samples=$4
covariates=$5
min_reads=$6
min_replicates=$7
min_avg_value=$8
outputdir=$9

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Data folder:        $datafolder"
echo "Samples:      $samples"
echo "covariates:       $covariates"
echo "Min. number of reads:     $min_reads"
echo "Min. number of replicates:        $min_replicates"
echo "Min. avg value:       $min_avg_value"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $datafolder $samples $covariates $min_reads $min_replicates $min_avg_value ' ./Rscripts/CircMergeSamples.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
