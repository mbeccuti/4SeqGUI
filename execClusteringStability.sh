#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nPerm=$4
range1=$5
range2=$6
separator=$7
logTen=${8}
seed=${9}
clustering=${10}
perplexity=${11}
pcaDimensions=${12}
output=${13}
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "file:        $file"
echo "nPerm:	$nPerm"
echo "range1:	$range1"
echo "range2:	$range2"
echo "separator:	$separator"
echo "logTen:	$logTen"
echo "seed:	$seed"
echo "clustering:	$clustering"
echo "pcaDimensions:	$pcaDimensions"
echo "perplexity:	$perplexity"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nPerm $range1 $range2 $separator $logTen $seed $clustering $pcaDimensions $perplexity' ./Rscripts/clusteringStability.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
