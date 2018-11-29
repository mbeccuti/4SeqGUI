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



data.folder=dirname(file)
positions=length(strsplit(basename(file),"\\.")[[1]])
matrixNameC=strsplit(basename(file),"\\.")[[1]]
counts.table=paste(matrixNameC[seq(1,positions-1)],collapse="")
  matrixName=counts.table
file.type=strsplit(basename(basename(file)),"\\.")[[1]][positions]
matrixName=paste(matrixName,".",file.type,sep="")
if(logged=="TRUE"){
logged=TRUE
}else{logged=FALSE}
topx(data.folder=data.folder,file.name=matrixName, threshold=as.numeric(threshold),logged=logged)

