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
chipseqCounts(group=group,output.folder=output.folder, mock.folder=mock.folder, test.folder=test.folder, 
              scratch.folder=scratch.folder,adapter5=adapter5,adapter3=adapter3,threads=threads, 
              seq.type=seq.type, min.length=min.length,genome.folder=genome.folder, mock.id=mock.id, 
              test.id=test.id, genome=genome, read.size=read.size, tool=tool, macs.min.mfold=macs.min.mfold,
              macs.max.mfold=macs.max.mfold, macs.pval=macs.pval, sicer.wsize=sicer.wsize, 
              sicer.gsize=sicer.gsize, sicer.fdr=sicer.fdr, tss.distance=tss.distance, 
              max.upstream.distance=max.upstream.distance, remove.duplicates=remove.duplicates)

