
#!/bin/sh



samplefolders=$1
covariates=$2
batchs=$3
biotype=$4
outputfolder=$5
output=$6
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Sample Folder:           $samplefolders"
echo "Groups:                  $covariates"
echo "Batchs:                  $batchs"
echo "Biological type:         $biotype"
echo "Output Prefix:           $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   ${samplefolders} ${covariates} ${batch} $biotype $outputfolder ' ./Rscripts/FPKMCounts.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "			           END EXECUTION"
echo "======================================================="
