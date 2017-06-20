
#!/bin/sh


group=$1
fastqfolder=$2
scratchfolder=$3
adapter5=$4
adapter3=$5
seqtype=$6
thread=$7
minlength=$8
genomefolder=$9
strandness=${10}
annotation=${11}
bam=${12}
output=${13}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "FastQ folder:      $fastqfolder"
echo "Scratch folder:    $scratchfolder"
echo "Adapter5:          $adapter5"
echo "Adapter3:          $adapter3"
echo "Sequence type:     $seqtype"
echo "Threads:           $thread"
echo "Min. length read:  $minlength"
echo "Genome folder:     $genomefolder"
echo "Strandness:        $strandness"
echo "Annotation:        $annotation"
echo "Bam:               $bam"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $fastqfolder $scratchfolder  $adapter5  $adapter3  $seqtype $thread $minlength $genomefolder $strandness  $annotation $bam' ./Rscripts/rnaseqCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
