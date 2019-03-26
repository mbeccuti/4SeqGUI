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

if (mode == "General") {
    bwaIndex(group=group, mode=mode, genome.folder=genome.folder,
        genome.url=genome.url)
} else if (mode == "GATK") {
    bwaIndex(group=group, mode=mode, genome.folder=genome.folder,
        genome.url=genome.url, dbsnp.file=dbsnp.file, g1000.file=g1000.file)
} else if (mode == "miRNA") {
    bwaIndex(group=group, mode=mode, genome.folder=genome.folder,
        mb.version=mb.version, mb.species=mb.species)
} else if (mode == "ncRNA") {
    rc.species <- gsub(pattern="_", replacement=" ", x=rc.species)
    
    bwaIndex(group=group, mode=mode, genome.folder=genome.folder,
            rc.version=rc.version, rc.species=rc.species, length=length)
}
