/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This is a collection of <s>ResultLog</s>s.  
 * @author Greg
 */
public class LogArray {
    /**
     * An array of <b>ResultLog</b>s
     */
    private ResultLog[] logArray;
    /**
     * Integer tracking where the LogArray is writing to.
     */
    private int writeTracker;
    /**
     * integer tracking where the LogArray is reading from.
     */
    private int readTracker;
    
    /**
     * Default Constructor
     */
    public LogArray() {
        writeTracker = 0;
        readTracker = 0;
        logArray = new ResultLog[1];
    }
    
    public LogArray (int numberOfRuns, int lengthOfWalk) {
        writeTracker = 0;
        readTracker = 0;
        logArray = new ResultLog[numberOfRuns];
        
        for (int i=0; i < numberOfRuns; i++) {
            logArray[i] = new ResultLog(lengthOfWalk);
            //Test println statement - demonstrates that each log is being created.
            //System.out.println("ResultLog " + (i+1));
        }
    }
    
    public boolean getResult(int logNumber, int interaction) {
        return this.logArray[logNumber].getResult(interaction);
        }
    
    public void addResult(boolean deceptive) {
        
    }
}
