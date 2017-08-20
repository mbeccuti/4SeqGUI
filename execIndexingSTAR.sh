#!/bin/sh


group=$1
genomefolder=$2
genomeurl=$3
gtfurl=$4
thread=$5
output=$6
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

echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $genomefolder $genomeurl $gtfurl $thread ' ./Rscripts/indexingSTAR.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
