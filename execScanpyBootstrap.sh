#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nPerm=$4
permAtTime=$5
percent=$6
separator=$7
pcaDimensions=${8}
seed=${9}
perplexity=${10}
format=${11}
output=${12}
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
echo "separator:	$separator"
echo "logTen:	$logTen"
echo "Pca Dimensions:	$pcaDimensions"
echo "seed:	$seed"
echo "Perplexity	$perplexity"
echo "format:	$format"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nPerm $permAtTime $percent $separator $pcaDimensions $seed $perplexity $format' ./Rscripts/ScanpyBootstrap.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
