#!/bin/sh


group=$1
indexfolder=$2
urltranscriptome=$3
gtfurl=$4
output=$5

path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Genome folder:     $genomefolder"
echo "Genome url:        $genomeurl"
echo "GTF url:           $gtfurl"      
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $indexfolder $urltranscriptome $gtfurl' ./Rscripts/indropIndex.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
