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

bwaIndex(group=group, mode=mode,
        genome.folder=genome.folder, genome.url=genome.url,
        dbsnp.file=dbsnp.file, g1000.file=g1000.file,
        mb.version=mb.version, mb.species=mb.species,
        rc.version=rc.version, rc.species=rc.species, length=length)
