##First read in the arguments listed at the command line
args=(commandArgs(TRUE))

##args is now a list of character vectors
## First check to see if arguments are passed.
## Then cycle through each element of the list and evaluate the expressions.
if(length(args)==0){
  print("No arguments supplied.")
  ##supply default values

}else{
  for(i in 1:length(args)){
    eval(parse(text=args[[i]]))
  }
}


if(sep=="TAB"){
separator="\t"
}else{separator=","}

if(plot=="TRUE"){plot=TRUE}else{plot=FALSE}
library(rCASC)
setwd(dirname(file))

anovaLike(group=group,file=file,sep=separator,cluster.file=cluster.file,ref.cluster=as.numeric(ref.cluster),logFC.threshold=as.numeric(logFC.threshold),FDR.threshold=as.numeric(FDR.threshold),logCPM.threshold=as.numeric(logCPM.threshold),plot=plot) 


