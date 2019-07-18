##First read in the arguments listed at the command line
args=(commandArgs(TRUE))

##args is now a list of character vectors
## First check to see if arguments are passed.
## Then cycle through each element of the list and evaluate the expressions.
if(length(args)==0) {
  print("No arguments supplied.")
  ##supply default values

} else {
  for(i in 1:length(args)) {
    print(args[[i]])
    eval(parse(text=args[[i]]))
  }
}

library(docker4seq)

bwa(
    group=group, 
    threads=threads, 
    fastq.folder=fastq.folder, 
    scratch.folder = scratch.folder, 
    genome.folder = genome.folder, 
    seq.type = seq.type, 
    sample.id = sample.id
)