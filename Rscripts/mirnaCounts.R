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


library(docker4seq)
mirnaCounts(group = group, fastq.folder =  fastq.folder, scratch.folder =  scratch.folder, mirbase.id= mirbase.id, download.status=  download.status, adapter.type= adapter.type, trimmed.fastq= trimmed.fastq)


