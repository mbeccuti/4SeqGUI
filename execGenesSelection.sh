#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nCluster=$4
separator=$5
seed=${6}
sp=${7}
clusterPermErr=${8}
maxDeltaConfidence=${9}
minLogMean=${10}
output=${11}
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "file:        $file"
echo "nCluster:	$nCluster"
echo "separator:	$separator"
echo "seed:	$seed"
echo "sp:	$sp"
echo "clusterPermErr:	$clusterPermErr"
echo "max Delta confidence:	$maxDeltaConfidence"
echo "min log mean:	$minLogMean"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nCluster $separator $logTen $seed $sp $clusterPermErr $maxDeltaConfidence $minLogMean' ./Rscripts/GenesSelection.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
