#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
separator=$4
logTen=${5}
seed=${6}
pcaDimensions=${7}
geneNumber=$8
nCluster=$9




output=${10}
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "file:        $file"
echo "separator:	$separator"
echo "logten:	$logTen"
echo "seed:	$seed"
echo "pcaDimensions:	$pcaDimensions"
echo "geneNumber:	$geneNumber"
echo "nCluster:	$nCluster"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $separator $logTen $seed $pcaDimensions $geneNumber $nCluster' ./Rscripts/SeuratPrior.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
