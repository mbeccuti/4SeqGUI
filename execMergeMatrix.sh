#!/bin/sh


group=$1
file1=$2
file2=$3
sep1=$4
sep2=$5
name1=$6
name2=$7
output=${8}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "file1:        $file1"
echo "file2:	$file2"
echo "sep1:	$sep1"
echo "sep2:	$sep2"
echo "name1:    $name1"
echo "name2:	 $name2"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $file1 $file2 $sep1 $sep2 $name1 $name2' ./Rscripts/mergeMatrix.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
