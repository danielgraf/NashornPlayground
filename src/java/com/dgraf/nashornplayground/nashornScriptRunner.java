/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgraf.nashornplayground;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author dgraf
 */
public class nashornScriptRunner 
{
    private final ScriptEngine scriptengine;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    
    public nashornScriptRunner()
    {
        scriptengine = new ScriptEngineManager().getEngineByName("nashorn");
        javax.script.Bindings bindings = scriptengine.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("currency", new currencyUtility());
    }
    
    public void run(nashornScriptset scriptset)
    {
        scriptset.setExecutiontimestamp(sdf.format(new Date()));
        long start = 0;
        long end = 0;
        long elapsed = 0;
        StringWriter outputWriter = new StringWriter();
        scriptengine.getContext().setWriter(outputWriter);
        scriptset.setLasterror("");
        
        try 
        {
            start = System.nanoTime();
            String script = "load(\"nashorn:mozilla_compat.js\");\n" + scriptset.getScript();
            scriptengine.eval(script);
            end = System.nanoTime();
            elapsed = end - start;
            scriptset.setResult(true);
            scriptset.setExecutiontime(TimeUnit.NANOSECONDS.toMillis(elapsed));
            scriptset.setOutput(outputWriter.toString());
            scriptset.setEval("");
        } 
        catch (Exception ex) 
        {
            end = System.nanoTime();
            elapsed = end - start;
            scriptset.setLasterror(ex.getMessage());
            scriptset.setResult(false);
            scriptset.setExecutiontime(TimeUnit.NANOSECONDS.toMillis(elapsed));
            scriptset.setOutput(outputWriter.toString());
            scriptset.setEval("Error");
            Logger.getLogger(nashornScriptRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
