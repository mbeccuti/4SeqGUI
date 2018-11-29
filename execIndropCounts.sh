#!/bin/sh
group=$1
 scratchfolder=$2
 fastqfolder=$3
indexfolder=$4
samplename=$5
splitaffixes=$6
bowtieindexprefix=$7
M=$8
U=$9
D=${10}
lowcomplexitymask=${11}
umithreshold=${12}
output=${13}
path=${PWD}                   






echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "fastq folder:        $fastqfolder"
echo "index folder:	$indexfolder"
echo "sample name:	$samplename"
echo "split affixes:	$splitaffixes"
echo "bowtie index prefix :	$bowtieindexprefix"
echo "M:	$M"
echo "U:	$U"
echo "D:	$D"
echo "low complexity mask:	$lowcomplexitymask"
echo "umi threshold:	$umithreshold"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $scratchfolder $fastqfolder $indexfolder $samplename $splitaffixes $bowtieindexprefix $M $U $D $lowcomplexitymask $umithreshold' ./Rscripts/indropCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
