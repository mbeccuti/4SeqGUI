#!/bin/sh

group=$1
 file=$2
outputname=$3
ncores=$4
filtercellNum=$5
dithercounts=$6
PropToUse=$7
PrintProgressPlot=$8
FilterExpression=$9



output=${10}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:	$group"
echo "file:        $file"
echo "outputname:	$outputname"
echo "ncores:	$ncores"
echo "Filter Cell Num:	$filtercellNum"
echo "dither counts:	$dithercounts"
echo "PropToUse:	$PropToUse"
echo "PrintProgressPlot	$PrintProgressPlot"
echo "filter expression:	$FilterExpression"



echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $file $outputname $ncores $filtercellNum $dithercounts $PropToUse $PrintProgressPlot $FilterExpression' ./Rscripts/Scnorm.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
