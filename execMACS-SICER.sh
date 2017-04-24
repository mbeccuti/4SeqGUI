
#!/bin/sh


group=$1
outputfolder=$2
scratchfolder=$3
adapter5=$4
adapter3=$5
mockfolder=$6
testfolder=$7
seqtype=$8
thread=$9
minlength=${10}
genomefolder=${11}
mockid=${12}
testid=${13}
genome=${14}
readsize=${15}
tool=${16}
macsminmfold=${17}
macsmaxmfold=${18}
macspval=${19}
sicerwsize=${20}
sicergsize=${21}
sicerfdr=${22}
tssdistance=${23}
maxupstreamdistance=${24}
removeduplicates=${25}
output=${26}
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Group:             $group"
echo "Output folder:     $outputfolder"
echo "Scratch folder:    $scratchfolder"
echo "Adapter5:          $adapter5"
echo "Adapter3:          $adapter3"
echo "Mock folder        $mockfolder"
echo "Test folder        $testfolder"
echo "Sequence type:     $seqtype"
echo "Threads:           $thread"
echo "Min. length read:  $minlength"
echo "Genome folder:     $genomefolder"
echo "Mock id:           $mockid"
echo "Test id:           $testid"
echo "Genome:            $genome"
echo "Read size:         $readsize"
echo "Tool:              $tool"
echo "MACS min. mfold:   $macsminmfold"
echo "MACS min. mfold:   $macsmaxmfold"
echo "MACS p-value:      $macspval"
echo "SICER window size: $sicerwsize"
echo "SICER gsize:       $sicergsize"
echo "SICER FDR:         $sicerfdr"
echo "TSS distance:      $tssdistance"
echo "Max upstream dis.: $maxupstreamdistance"
echo "Remove Duplicates: $removeduplicates"
echo "Output:            $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${group} $outputfolder $scratchfolder  $adapter5  $adapter3 $mockfolder $testfolder  $seqtype $thread $minlength $genomefolder $mockid $testid $genome $readsize $tool $macsminmfold $macsmaxmfold $macspval  $sicerwsize $sicergsize $sicerfdr  $tssdistance $maxupstreamdistance $removeduplicates ' ./Rscripts/chipseqCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
