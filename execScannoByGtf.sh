#!/bin/sh

group=$1
 file=$2
gtfname=$3
biotype=$4
mt=$5
riboprotein=$6
umiXgene=$7
R1=$8
R2=$9
R3=${10}
R4=${11}
output=${12}
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
echo "R1	$R1"
echo "R2	$R2"
echo "R3	$R3"
echo "R4	$R4"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $file $gtfname $biotype $mt $riboprotein $umiXgene $R1 $R2 $R3 $R4' ./Rscripts/scannoByGtf.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
