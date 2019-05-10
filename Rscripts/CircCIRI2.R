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

wrapperCiri(group=group, scratch.folder=scratch.folder, data.folder=data.folder,
    genome.file=genome.file, seq.type=seq.type, sample.id=sample.id, threads=threads,
    annotation.file=annotation.file, max.span=max.span, strigency=strigency,
    quality.threshold=quality.threshold)
