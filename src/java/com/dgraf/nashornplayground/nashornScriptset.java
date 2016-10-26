/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgraf.nashornplayground;

/**
 *
 * @author dgraf
 */
public class nashornScriptset {
    
    public nashornScriptset()
    {
        
        name = "";
        script = "";
        executiontime = 0;
        result = true;
        lasterror = "";
        output = "";
        eval = "";
    }
    public void reset()
    {
        eval = "";
        output = "";
        lasterror = "";
        result = true;
        executiontime = 0;
        executionid = "";
        executiontimestamp = "";
    }
    public nashornScriptset(String name, String script)
    {
        this();
        this.name = name;
        this.script = script;
        
    }
    private String name;
    private String script;
    private long executiontime;
    private boolean result;
    private String lasterror;
    private String output;
    private String executionid;
    private String executiontimestamp;

    public String getExecutiontimestamp() {
        return executiontimestamp;
    }

    public void setExecutiontimestamp(String executiontimestamp) {
        this.executiontimestamp = executiontimestamp;
    }

    public String getExecutionid() {
        return executionid;
    }

    public void setExecutionid(String executionid) {
        this.executionid = executionid;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }
    private String eval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public long getExecutiontime() {
        return executiontime;
    }

    public void setExecutiontime(long executiontime) {
        this.executiontime = executiontime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getLasterror() {
        return lasterror;
    }

    public void setLasterror(String lasterror) {
        this.lasterror = lasterror;
    }
    
}
