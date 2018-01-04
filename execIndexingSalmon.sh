#!/bin/sh


group=$1
genomefolder=$2
urltranscriptome=$3
gtfurl=$4
thread=$5
k=$6
output=$7
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
echo "Threads:           $thread"
echo "K-mer size:        $k"      
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $genomefolder $urltranscriptome $gtfurl $thread $k' ./Rscripts/indexingSalmon.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
