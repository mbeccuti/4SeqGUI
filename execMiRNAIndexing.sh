#!/bin/bash

group=$1
mode=$2
genomefolder=$3

if [ $mode == "General" ]; then
    arg1=$4         #genome url
    outputdir=$5
elif [ $mode == "GATK" ]; then
    arg1=$4         #genome url
    arg2=$5         #dbsnp file
    arg3=$6         #1000g file
    outputdir=$7
elif [ $mode == "miRNA" ]; then
    arg1=$4         #mirbase version
    arg2=$5         #mirbase species
    outputdir=$6
elif [ $mode == "ncRNA" ]; then
    arg1=$4         #RNA central version
    arg2=$5         #RNA central species
    arg3=$6         #max RNA length
    outputdir=$7
else
    echo "INVALID MODE ARGUMENT"
    exit 1
fi

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Mode:     $mode"
echo "Genome folder:    $genomefolder"
echo "Argument 1:       $arg1"
echo "Argument 2:       $arg2"
echo "Argument 3:       $arg3"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $mode $genomefolder $arg1 $arg2 $arg3 ' ./Rscripts/mirnaGenomeIndexing.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
