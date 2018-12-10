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

circrnaQuantification(group=group, scratch.folder=scratch.folder,
    rnaseq.data=rnaseq.data,
    backsplicing_junctions.data=backsplicing_junctions.data,
    hc.params=c(hcp1, hcp2, hcp3, hcp4, hcp5, hcp6))
