#!/bin/sh


group=$1
file=$2
scratchfolder=$3
status=$4
lowerrange=$5
upperrange=$6
output=${7}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Input file:        $file"
echo "Scratch folder:    $scratchfolder"
echo "Status:		   $status"
echo "Lower bound:       $lowerrange"
echo "Upper bound:       $upperrange"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $file $scratchfolder  $status  $lowerrange $upperrange' ./Rscripts/Heatmap.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
