/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class LogArrayTest {
    
    public LogArrayTest() {

 }
    @Test
    public void LogArrayCreationTest() {
        int lengthOfWalk = 10;
        int numberOfRuns = 10;
        LogArray logArray = new LogArray(numberOfRuns,lengthOfWalk);
        
        System.out.println(logArray.getLogArraySize());
    }
    
    @Test
    public void logArrayContentTest() {
        LogArray logArray = new LogArray(2,5);
        logArray.addResult(false);
        logArray.addResult(true);
        logArray.addResult(false);
        logArray.addResult(false);
        logArray.addResult(false);
        logArray.endLog();
        logArray.addResult(false);
        logArray.addResult(false);
        logArray.addResult(true);
        logArray.addResult(false);
        logArray.addResult(false);
        System.out.println(logArray.getFirstDeception(0));
        System.out.println(logArray.getFirstDeception(1));
        
        LogInterpreter logInt = new LogInterpreter(logArray);
        //System.out.println(logInt.makeDecArray());
    }
    
    
}
