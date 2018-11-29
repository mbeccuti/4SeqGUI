#!/bin/sh

group=$1
 file=$2
gtfname=$3
biotype=$4
mt=$5
riboprotein=$6
umiXgene=$7
output=${8}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:	$group"
echo "file:        $file"
echo "gtfname:	$gtfname"
echo "biotype:	$biotype"
echo "mt:	$mt"
echo "riboprotein:	$riboprotein"
echo "umiXgene	$umiXgene"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $file $gtfname $biotype $mt $riboprotein $umiXgene' ./Rscripts/scannoByGtf.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
