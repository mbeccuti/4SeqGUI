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


if(sep1=="TAB"){
separator1="\t"
}else{separator1=","}

if(sep2=="TAB"){
separator2="\t"
}else{separator2=","}

library(rCASC)
setwd(dirname(file1))


scratch.folder=getwd()
mergeMatrix(group=group, scratch.folder=scratch.folder, file1=file1,file2=file2, separator1=separator1,separator2=separator2,name1=name1,name2=name2)
