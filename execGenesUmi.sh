#!/bin/sh


 file=$1
umiXgenes=$2
separator=$3
output=${4}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "file:        $file"
echo "umiXgenes:	$umiXgenes"
echo "separator:	$separator"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $file $umiXgenes $separator' ./Rscripts/genesUmi.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
