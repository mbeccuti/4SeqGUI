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
indropCounts(group=group,scratch.folder=scratch.folder, fastq.folder=fastq.folder,index.folder=index.folder,sample.name=sample.name,split.affixes=split.affixes,bowtie.index.prefix=bowtie.index.prefix,M=M,U=U,D=D,low.complexity.mask=low.complexity.mask,umi.threshold=umi.threshold)

