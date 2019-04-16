package pkg4seqgui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nicola Licheri
 */
public class ScriptCaller {
    private final String scriptToExecute; 
    private final List<ScriptParameter> scriptArguments;
    public final String outputFolder; 
    
    public ScriptCaller(String script, String outputFolder) {
        this.scriptToExecute = script; 
        this.outputFolder = outputFolder;
        this.scriptArguments = new LinkedList<>();
    }
    
    public ScriptCaller addArg(String argName, String argValue) {
        scriptArguments.add(new ScriptParameter(argName, argValue));
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
    
    private File getScript() throws IOException{
        File tempScript = File.createTempFile("scriptname", null); 
        
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
            printWriter.println("args=\"R CMD BATCH --no-save --no-restore  '--args " + arguments + " ' ./Rscripts/" + scriptToExecute + " $output/Routput.Rout\"");
            printWriter.println("echo \"$args\"");
            printWriter.println("eval \"$args\"");
            
            printWriter.println("echo \"=======================================================\""); 
            printWriter.println("echo \"			  END EXECUTION\""); 
            printWriter.println("echo \"=======================================================\n\""); 
        }
        
        return tempScript;
    }

}


class ScriptParameter {
    public final String name, value; 
    
    public ScriptParameter(String name, String value) {
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
    
    @Override
    public String toString() {
        return String.format("%s=%s", this.name, this.value);
    }
}

