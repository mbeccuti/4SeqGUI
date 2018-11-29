#!/bin/sh


group=$1
file=$2
sep=$3
clusterfile=$4
refcluster=$5
logFCthreshold=$6
FDRThreshold=$7
logCPMThreshold=$8
plot=$9
output=${10}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Input file:        $file"
echo "Sep:	$sep"
echo "clusterFile:	$clusterfile"
echo "refcluster:	$refcluster"
echo "logFCthreshold:    $logFCthreshold"
echo "FDRThreshold:	 $FDRThreshold"
echo "logCPMThreshold:   $logCPMThreshold"
echo "plot:	$plot"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $file $sep $clusterfile $refcluster $logFCthreshold $FDRThreshold $logCPMThreshold $plot' ./Rscripts/ANOVAlikeS.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
