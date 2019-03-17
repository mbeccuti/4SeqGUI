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



if(separator=="TAB"){
separator="\t"
}else{separator=","}



clusterStability(group=group,scratch.folder=scratch.folder,file=file,nPerm=nPerm,permAtTime=permAtTime,percent=percent,range1=range1,range2=range2,separator=separator,logTen=logTen,seed=seed,clustering=clustering,pcaDimensions=pcaDimensions,perplexity=perplexity)
