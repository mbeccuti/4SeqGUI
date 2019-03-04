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


cellrangerCount(group=group, transcriptome.folder=transcriptome.folder, fastq.folder=fastq.folder, sample=NULL, expect.cells=expect.cells, force.cells=NULL, nosecondary=TRUE, chemistry=NULL, r1.length=NULL, r2.length=NULL, lanes=NULL, localcores=NULL, localmem=NULL, scratch.folder=scratch.folder, version="3")


