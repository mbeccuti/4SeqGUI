#!/bin/sh


 group=$1
 file=$2
 threshold=$3
separator=$4
logged=$5
type=$6
output=${7}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:    $group"
echo "file:        $file"
echo "threshold:	$threshold"
echo "separator:    $separator"
echo "logged:	$logged"
echo "type:     $type"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $file $threshold $separator $logged $type' ./Rscripts/topX.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
