#!/bin/sh


group=$1
file=$2
sep=$3
cellsnumber=$4
output=${5}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "file:        $file"
echo "sep:	$sep"
echo "cells number:    $cellsnumber"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $file $sep $cellsnumber ' ./Rscripts/subSetCells.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
