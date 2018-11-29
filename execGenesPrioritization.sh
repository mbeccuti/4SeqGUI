#!/bin/sh
group=$1
 scratchfolder=$2
 file=$3
nPerm=$4
permAtTime=$5
percent=$6
nCluster=$7
separator=$8
logTen=${9}
seed=${10}
sp=${11}
clusterPermErr=${12}
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
echo "nCluster:	$nCluster"
echo "separator:	$separator"
echo "logTen:	$logTen"
echo "seed:	$seed"
echo "sp:	$sp"
echo "clusterPermErr:	$clusterPermErr"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $file $nPerm $permAtTime $percent $nCluster $separator $logTen $seed $sp $clusterPermErr' ./Rscripts/genesPrioritization.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
