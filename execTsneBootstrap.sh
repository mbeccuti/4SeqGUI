#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nPerm=$4
permAtTime=$5
percent=$6
range1=$7
range2=$8
separator=$9
logTen=${10}
seed=${11}
sp=${12}
perplexity=${13}
output=${14}
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
echo "permAtTime:	$permAtTime"
echo "percent:	$percent"
echo "range1:	$range1"
echo "range2:	$range2"
echo "separator:	$separator"
echo "logTen:	$logTen"
echo "seed:	$seed"
echo "sp:	$sp"
echo "perplexity:	$perplexity"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nPerm $permAtTime $percent $range1 $range2 $separator $logTen $seed $sp $perplexity' ./Rscripts/TsneBootstrap.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
