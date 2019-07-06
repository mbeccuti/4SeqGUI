package pkg4seqgui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The class ScriptCaller executes a R function passing it a list of arguments 
 * @author Nicola Licheri
 */
public class ScriptCaller {
    private final String scriptToExecute; 
    private final List<ScriptParameter> scriptArguments;
    public final String outputFolder; 
    public final String callingTime; 
    public final String logfile_R, logfile_outputExec; 
   
    /**
     * Initialize a script caller to execute a command running a Docker container
     * @param script R script to execute: it has to be in ./Rscript folder 
     * @param outputFolder Path of the folder where to save log files 
     */
    public ScriptCaller(String script, String outputFolder) {
        this.scriptToExecute = script; 
        this.outputFolder = outputFolder;
        this.scriptArguments = new LinkedList<>();
            
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss"); 
        this.callingTime = dateFormat.format(new Date()); 
        
        this.logfile_R = String.format("Routput_%s.Rout", this.callingTime);
        this.logfile_outputExec = String.format("outputExecution_%s", this.callingTime); 
    }
    
    /**
     * Add a parameter 
     * @param argName Name of a parameter of the R script which call the Docker container
     * @param argValue Value of the parameter 
     * @return the updated ScriptCaller object
     */
    public ScriptCaller addArg(String argName, String argValue) {
        scriptArguments.add(new ScriptParameter(argName, argValue));
        return this;
    }
    
    //in order to escape NULL and NA values
    public ScriptCaller addArg(String argName, String argValue, boolean force_string) {
        scriptArguments.add(new ScriptParameter(argName, argValue, force_string));
        return this;
    }
    
    public ScriptCaller addArg(String argName, int argValue) {
        scriptArguments.add(new ScriptParameter(argName, argValue));
        return this;
    }
    
    public ScriptCaller addArg(String argName, float argValue) {
        scriptArguments.add(new ScriptParameter(argName, argValue));
        return this;
    }
    
    public ScriptCaller addArg(String argName, boolean argValue) {
        scriptArguments.add(new ScriptParameter(argName, argValue));
        return this;
    }
    
    /* encode an R vectors */ 
    public ScriptCaller addArgAsVector(String argName, String ... args) {
        scriptArguments.add(new ScriptParameter(argName, args)); 
        return this; 
    }
    
    public ScriptCaller addArgAsVector(String argName, boolean true_string, String ... args) {
        if (true_string) 
            for (int i = 0; i < args.length; i++)
                args[i] = String.format("'%s'", args[i]).replace("'", "\\\"");
        
        return addArgAsVector(argName, args);
    }

    /**
     * @return a string containing the passed parameters. The last parameter is the 
     * output folder. 
     */
    private String getArgs() {
        String args = scriptArguments.stream().map((arg) -> arg.toString() + " ").reduce("", String::concat); 
        return args + " " + outputFolder;   
    }
    
    /**
     * Create the bash script required to call the chosen R script 
     * @return a string containing the bash command to execute the script
     * @throws IOException 
     */
    public String getCommandLineString() throws IOException {
        File script = getScript();
        
        return String.format("bash %s %s", script.toString(), getArgs()); 
    }
    
    /**
     * Generate a bash script to execute the current command 
     * @return
     * @throws IOException 
     */
    private File getScript() throws IOException{
        String scriptName = String.format("%s_%s", this.scriptToExecute.replace(".R", ""), this.callingTime); 
        File tempScript = File.createTempFile(scriptName, "sh"); 
        String routputFile = String.format("$output/%s", this.logfile_R);  //"$output/Routput_" + this.callingTime + ".Rout";// $output/Routput.Rout
        
        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempScript)))) {
            printWriter.println("#!/bin/bash\n");
         
            int i = 1;
            //declaring a variable for arguments
            for (ScriptParameter param: scriptArguments) {
                printWriter.println("arg" + i + "=\"${" + i + "}\"");
                i++;
            }
            printWriter.println("output=\"${" + i + "}\"");
            
            printWriter.println("echo \"=======================================================\""); 
            printWriter.println("echo \"			  INPUT PARAMETERS\""); 
            printWriter.println("echo \"=======================================================\n\""); 
            
            //summarizing passed parameters
            i = 1;
            String arguments = "";
            for (ScriptParameter param: scriptArguments) {
                printWriter.println("echo \"" + param.name + ":\t" + "$arg" + i + "\"");
                arguments += String.format("$arg%d ", i);
                i++;
            }
            printWriter.println("echo \"Output folder:\t$output\n\"");
            
            printWriter.println("echo \"=======================================================\n\"");
            printWriter.println("echo \" Current folder: ${PWD}\n\"");
            printWriter.println("echo \"Executing R script\n\"");
            printWriter.println("args=\"R CMD BATCH --no-save --no-restore  '--args " + 
                                arguments + 
                                " ' ./Rscripts/" + scriptToExecute + " " +
                                routputFile + "\"");//   " $output/Routput.Rout\"");
            printWriter.println("echo \"$args\"");
            printWriter.println("eval \"$args\"");
            
            printWriter.println("echo \"=======================================================\""); 
            printWriter.println("echo \"			  END EXECUTION\""); 
            printWriter.println("echo \"=======================================================\n\""); 
        }
        
        return tempScript;
    }

}

/**
 * The class ScriptParameter describes a single script parameter,
 * which is a pair name parameter : value parameter 
 * String, integer, float and boolean types are supported
 * @author Nicola Licheri
 */
class ScriptParameter {
    public final String name, value; 
    
    /**
     * Describe a parameter of type String
     * @param name Parameter name 
     * @param value Parameter value; it may be NA/NULL
     */
    public ScriptParameter(String name, String value) {
        this.name = name; 
        
        switch (value = value.trim()) {
            case "NA":
            case "NULL":
                this.value = value; 
                break; 
            default:
                this.value = String.format("'%s'", value).replace("'", "\\\"");
        }
    }
    
    //
    public ScriptParameter(String name, String value, boolean force_string) {
        this.name = name; 
        this.value = String.format("'%s'", value).replace("'", "\\\"");            
    }
    
    public ScriptParameter(String name, int value) {
        this.name = name; 
        this.value = String.valueOf(value);
    }
    
    public ScriptParameter(String name, float value) {
        this.name = name; 
        this.value = String.valueOf(value); 
    }
    
    public ScriptParameter(String name, boolean value) {
        this.name = name; 
        this.value = value ? "TRUE" : "FALSE"; 
    }
    
    public ScriptParameter(String name, String ... args) {
        this.name = name; 
        this.value = String.format("c\\(%s\\)", String.join(",", args)); 
    }
    
    @Override
    public String toString() {
        return String.format("%s=%s", this.name, this.value);
    }
}

