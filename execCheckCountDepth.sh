#!/bin/sh

group=$1
 file=$2
filtercellproportion=$3
filterexpression=$4
dithercounts=$5
outputname=$6
ncores=$7
output=${8}
path=${PWD}                   



echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "group:	$group"
echo "file:        $file"
echo "filter cell proportion:	$filtercellproportion"
echo "filter expression:	$filterexpression"
echo "dither counts:	$dithercounts"
echo "outputname:	$outputname"
echo "ncores:	$ncores"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args  $group $file $filtercellproportion $filterexpression $dithercounts $outputname $ncores' ./Rscripts/checkCountDepth.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
