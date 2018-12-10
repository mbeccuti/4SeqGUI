#!/bin/bash

group=$1
scratchfolder=$2
genomefolder=$3
samplesfolder=$4
reads_cutoff=$5
min_subj_limit=$6
nthreads=$7
splice=$8
cpm_cutoff=$9
subjCPM_cutoff=${10}
annotation=${11}
outputdir=${12}

echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:	$group"
echo "Scratch Folder:     $scratchfolder"
echo "Genome Folder:        $genomefolder"
echo "Samples Folder:       $samplesfolder"
echo "Reads cutoff:     $reads_cutoff"
echo "Min. subject limit:      $min_subj_limit"
echo "Number of threads:        $nthreads"
echo "Do splice:        $splice"
echo "CPM cutoff:       $cpm_cutoff"
echo "Subject CPM cutoff:       $subjCPM_cutoff"
echo "Annotation:       $annotation"
echo
echo "======================================================="
echo
echo " Current folder: ${PWD}"
echo
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $group $scratchfolder $genomefolder $samplesfolder $reads_cutoff $min_subj_limit $nthreads $splice $cpm_cutoff $subjCPM_cutoff $annotation ' ./Rscripts/CircSTARPrediction.R  $outputdir/Routput.Rout"

echo $args

eval $args

echo
