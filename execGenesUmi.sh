#!/bin/sh

group=$1
scratchfolder=$2
 file=$3
separator=$4
gtf=$5
biotype=$6
umiXgenes=$7




output=${8}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "file:        $file"
echo "umiXgenes:	$umiXgenes"
echo "separator:	$separator"
echo "group:	$group"
echo "scratch folder:	$scratchfolder"
echo "gtf:	$gtf"
echo "biotype:	$biotype"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $scratchfolder $file $separator $gtf $biotype $umiXgenes' ./Rscripts/genesUmi.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
