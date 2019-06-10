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


library(docker4seq)
#source("/home/nico/gitgud/docker4seq/R/heatmaply.R")

heatmaply(
  group=group,
  scratch.folder=scratch.folder,
  output.folder=output.folder,
  count.table=count.table,
  gene.list=gene.list,
  separator=separator,
  status=status,
  color.palette=color.palette)
