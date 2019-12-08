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

wrapperSTARChip(group=group, 
    scratch.folder=scratch, 
    genome.folder=genome, 
    samples.folder=samples, 
    nthreads=nthreads, 
    chimSegmentMin=chim_segment, 
    chimJunctionOverhangMin=chim_overhang, 
    reads.cutoff=reads_cutoff, 
    min.subject.limit=min_subjects, 
    do.splice=do_plice, 
    cpm.cutoff=cpm_cutoff, 
    subjectCPM.cutoff=subject_cpm, 
    annotation=annotation)