#!/bin/bash

group=$1
scratchfolder=$2
rnaseqfile=$3
bsjfile=$4
hcparam1=$5
hcparam2=$6
hcparam3=$7
hcparam4=$8
hcparam5=$9
hcparam6=${10}
outputdir=$6

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "RNA-seq File:     $rnaseqfile"
echo "Back-splicing Junctions File:     $bsjfile"
echo "HashCirc params:      ($hcparam1, $hcparam2, $hcparam3, $hcparam4, $hcparam5, $hcparam6)"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $rnaseqfile $bsjfile $hcparam1 $hcparam2 $hcparam3 $hcparam4 $hcparam5 $hcparam6  ' ./Rscripts/CircQuantify.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
