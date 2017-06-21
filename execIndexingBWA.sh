#!/bin/sh


group=$1
genomefolder=$2
genomeurl=$3
gatk=$4
dbspnfile=$5
g1000file=$6
thread=$7
output=$8
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:                $group"
echo "Genome folder:        $genomefolder"
echo "Genome url:           $genomeurl"
echo "GATK:                 $gatk"
echo "dbspn VCF file:       $dbspnfile"
echo "1000 Genome VCF file: $g1000file"
echo "Threads:              $thread"

echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $genomefolder $genomeurl $gatk $dbspnfile $g1000file $thread ' ./Rscripts/indexingBWA.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
