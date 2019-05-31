#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nPerm=$4
permAtTime=$5
percent=$6
separator=$7
logTen=${8}
pcaDimensions=${9}
seed=${10}
sparse=${11}
format=${12}
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
echo "permAtTime:	$permAtTime"
echo "percent:	$percent"
echo "separator:	$separator"
echo "logTen:	$logTen"
echo "Pca Dimensions:	$pcaDimensions"
echo "seed:	$seed"
echo "sparse:	$sparse"
echo "format:	$format"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nPerm $permAtTime $percent $separator $logTen $pcaDimensions $seed $sparse $format' ./Rscripts/SeuratBootstrap.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
