#!/bin/sh


group=$1
scratchfolder=$2
genomeFolder=$3
fastaUrl=$4
gtfUrl=$5
biotype=$6
nThreads=$7
output=${8}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "scratch folder:   $scratchfolder"
echo "Genome Folder:    $genomeFolder"
echo "Fasta Url:    $fastaUrl"
echo "gtfUrl:   $gtfUrl"
echo "biotype:  $biotype"
echo "nThreads: $nThreads"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder  $genomeFolder $fastaUrl $gtfUrl $biotype $nThreads' ./Rscripts/tenXGenomicsindexing.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
