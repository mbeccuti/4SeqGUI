#!/bin/sh


group=$1
fastqfolder=$2
scratchfolder=$3
mirbaseid=$4
downloadstatus=$5
adaptertype=$6
trimmedfastq=$7
output=$8
path=${PWD}




echo
echo "======================================================="
echo "			  INPUT PARAMETERS EXECMIRNA"
echo "======================================================="
echo
echo "Group:             $group"
echo "FastQ folder:      $fastqfolder"
echo "Scratch folder:    $scratchfolder"
echo "miRBase organism:  $mirbaseid"
echo "miRBase download:  $downloadstatus"
echo "Adapter type:      $adaptertype"
echo "Trimmed reads:     $trimmedfastq"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $fastqfolder $scratchfolder  $mirbaseid  $downloadstatus $adaptertype $trimmedfastq ' ./Rscripts/mirnaCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
