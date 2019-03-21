#!/bin/bash

group=$1
fastqfolder=$2
scratchfolder=$3
reference=$4
mode=$5
numthreads=$6

if [ $mode == "mode=\"miRNA\"" ]; then
    mbversion=$7
    mbspecies=$8
    outputdir=$9
elif [ $mode == "mode=\"ncRNA\"" ]; then
    outputdir=$7
else
    echo "INVALID MODE ARGUMENT"
    exit 1
fi

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Fastq folder:        $fastqfolder"
echo "Reference file:       $reference"
echo "Mode:     $mode"
echo "Number of threads:    $numthreads"
echo "Argument 1:       $mbversion"
echo "Argument 2:       $mbspecies"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args $group $scratchfolder $fastqfolder $reference $mode $numthreads $mbversion $mbspecies ' ./Rscripts/mirnaQuantification.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
