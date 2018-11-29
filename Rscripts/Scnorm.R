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

library(rCASC)


if(ditherCounts=="TRUE"){
ditherCounts=TRUE
}else{ditherCounts=FALSE}

if(PrintProgressPlots=="TRUE"){
PrintProgressPlots=TRUE
}else{PrintProgressPlots=FALSE}

 data.folder=dirname(file)

  positions=length(strsplit(basename(file),"\\.")[[1]])
  matrixNameC=strsplit(basename(file),"\\.")[[1]]
  matrixName=paste(matrixNameC[seq(1,positions-1)],collapse="")
format=strsplit(basename(basename(file)),"\\.")[[1]][positions]



if(format=="txt"){sep="\t"}else{sep=","}
conditions=rep(1,ncol(read.table(file,header=TRUE,row.names=1,sep=sep)))

scnorm(group=group, file=file,conditions=conditions,outputName=outputName,nCores=nCores,filtercellNum=filtercellNum,ditherCount=ditherCounts,PropToUse=PropToUse,PrintProgressPlots=PrintProgressPlots,FilterExpression=FilterExpression)
                 
