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
rnaseqCounts(group = group, fastq.folder =  fastq.folder, scratch.folder =  scratch.folder, adapter5 =  adapter5, adapter3 =  adapter3, seq.type =  seq.type, threads =  threads,  min.length =  min.length, genome.folder =  genome.folder, strandness =  strandness, annotation.type =  annotation.type, save.bam=save.bam, org=org)



