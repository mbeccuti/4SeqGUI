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

wrapperAutoencoder(
    group=group,
    projectName=projectName,
    scratch.folder=scratch.folder,
    file=file,
    cl=cl,
    bN=bN,
    regularization=regularization,
    variational=variational,
    separator=separator,
    nCluster=nCluster,
    bias=bias,
    permutation=permAtTime,
    nEpochs=nEpochs,
    patiencePercentage=patiencePercentage,
    seed=seed,
    clusterMethod=clusterMethod,
    pcaDimensions=pcaDimensions,
    permAtTime=permAtTime,
    largeScale=largeScale,
    Sp=Sp,
    threads=threads,  
    X=X, 
    K=K, 
    counts=counts, 
    skipvis=skipvis

    # lr=0.01,
    # beta_1=0.9,
    # beta_2=0.999,
    # epsilon=0.00000001,
    # decay=0.0, 
    # loss="mean_squared_error",
)