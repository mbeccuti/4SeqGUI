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

library(rCASC)

separator <- ifelse(separator == "TAB", "\t", ",")
bN <- ifelse(is.null(bN), "NULL", bN)

paste(bN)


autoencoder(
    group=group, 
    scratch.folder=scratch.folder, 
    file=file,
    separator=separator, 
    nCluster=nCluster, 
    bias=bias, 
    permutation=permutation, 
    nEpochs=nEpochs,
    patiencePercentage=5, 
    cl=cl,
    seed=seed,
    projectName=projectName,
    bN=bN, 
    regularization=regularization,
    variational=variational
)
