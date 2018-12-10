args=(commandArgs(TRUE))

##args is now a list of character vectors
## First check to see if arguments are passed.
## Then cycle through each element of the list and evaluate the expressions.
if(length(args)==0) {
  print("No arguments supplied.")
  ##supply default values

} else {
  for(i in 1:length(args)) {
    eval(parse(text=args[[i]]))
  }
}


ciri2Merge(group=group, scratch.folder=scratch.folder, data.folder=data.folder,
    samples=samples, covariates=covariates, min_reads=min_reads,
    min_reps=min_reps, min_avg)
