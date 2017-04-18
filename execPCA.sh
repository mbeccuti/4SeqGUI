
#!/bin/sh



experimenttable=$1
type=$2
covariatesInNames=$3
principalcomponents=$4
legendposition=$5
outputfolder=$6
output=$7
path=${PWD}


echo
echo "======================================================="
echo "			  INPUT PARAMETERS"
echo "======================================================="
echo
echo "Input file:              $experimenttable"
echo "Data type:               $type"
echo "Covariate Names:         $covariatesInNames"
echo "Principal Components:    $principalcomponents"
echo "Legend position:         $legendposition"
echo "Output folder:           $outputfolder"
echo "Output:                  $output"
echo 
echo "======================================================="

echo 


echo " Current folder: ${PWD}"
echo " "
echo "Executing R script"

args="R CMD BATCH --no-save --no-restore  '--args   $experimenttable $type $covariatesInNames $principalcomponents $outputfolder  $legendposition ' ./Rscripts/PCA.R  $output/Routput.Rout"

echo "$args"

eval "$args"

echo
echo
echo "======================================================="
echo "		       END EXECUTION"
echo "======================================================="
