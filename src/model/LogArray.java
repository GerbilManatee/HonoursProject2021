/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This is a collection of ResultLogs.  The first function of LogArray is to issue 
 * results of interactions between the Attacker and Nodes to individual 
 * ResultLogs.  The write is intended as a one-time process, with no overwriting.
 * The second function is to query ResultLogs on behalf of the LogInterpreter,
 * passing back results for analysis.
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
     * integer tracking where the LogArray is reading from (if ever needed).
     */
    private int readTracker;
    
    /**
     * Default Constructor - 5 ResultLogs' worth.
     */
    public LogArray() {
        writeTracker = 0;
        readTracker = 0;
        logArray = new ResultLog[5];
        for (int i=0; i < 5; i++) {
            logArray[i] = new ResultLog();
        }
        
    }
    
    /**
     * This is the constructor the app should be using.  It specifies the size of the result space.
     * @param numberOfRuns The number of iterations through the simulator.
     * @param lengthOfRun The length of the runs the Attacker will be making each time.
     */
    public LogArray (int numberOfRuns, int lengthOfRun) {
        writeTracker = 0;
        readTracker = 0;
        logArray = new ResultLog[numberOfRuns];
        
        for (int i=0; i < numberOfRuns; i++) {
            logArray[i] = new ResultLog(lengthOfRun);
            //Test println statement - demonstrates that each log is being created.
            //System.out.println("ResultLog " + (i+1));
        }
    }
    
    /**
     * 
     * @param logNumber The position in LogArray of the ResultLog being queried.
     * @param interaction The position in the interaction array of the ResultLog
     * being queried for an interaction.
     * @return The result (as a boolean) of an interaction - 'true' means the
     * interaction was with a deceptive node.
     */
    public boolean getResult(int logNumber, int interaction) {
        return this.logArray[logNumber].getResult(interaction);
        }
    
    /**
     * Adds the result of an interaction to the ResultLog currently being 
     * pointed to by writeTracker.
     * @param deceptive Indicates whether the interaction being recorded was
     * with a deceptive node.
     */
    public void addResult(boolean deceptive) {
        logArray[writeTracker].addResult(deceptive);
    }
    
    /**
     * Moves the writeTracker to point at the next ResultLog after one ResultLog has been filled.
     */
    public void endLog() {
        writeTracker++;
    }
    /**
     * 
     * @return The length of the LogArray
     */
    public int getLogArraySize() {
        return logArray.length;
    }
    /**
     * 
     * @param resultLog The position in the LogArray of the ResultLog being queried.
     * @return The length of the queried ResultLog.
     */
    public int getResultLogLength(int resultLog) {
        return logArray[resultLog].getLogLength();
    }
    
}
