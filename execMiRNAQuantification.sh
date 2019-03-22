#!/bin/bash

group="$1"
fastqfolder="$2"
scratchfolder="$3"
reference="$4"
mode="$5"
numthreads="$6"
adapters="$7"
keeptrimmed="$8"

if [ $mode == "mode=\"miRNA\"" ]; then
    mbversion="$9" #$7
    mbspecies="${10}"  #$8
    outputdir="${11}"  #$9
elif [ $mode == "mode=\"ncRNA\"" ]; then
    outputdir="${9}"  #$7
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
echo "Adapter type:     $adapters"
echo "Keep trimmed fastq: $keeptrimmed"
echo "Argument 1:       $mbversion"
echo "Argument 2:       $mbspecies"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args $group $scratchfolder $fastqfolder $reference $mode $numthreads $adapters $keeptrimmed $mbversion $mbspecies ' ./Rscripts/mirnaQuantification.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
