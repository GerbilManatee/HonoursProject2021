/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Attacker;
import model.Estate;
import model.LogArray;
import model.LogInterpreter;
import model.TestConditions;

/**
 *
 * @author hulle_000
 */
public class MonteCarloSimController {
    //variables
    private TestConditions testConditions;
    private int lengthOfRun;
    private int numberOfHonestNodes;
    private int numberOfDeceptiveNodes;
    private int percentDeceptiveEntryPoints;
    private int numberOfRuns;
    private LogArray logArray;
    private LogInterpreter logInterpreter;
    private Estate estate;
    
    
    //constructors
    public MonteCarloSimController() {
        //What do I need it to know when created?
        
        //First, TestConditions.
        //Probably not much else?
        testConditions = new TestConditions();
        
        
    }
    //methods
    public void run() {
        //Does all the stuff
        
        //First, get the values in TestConditions for setting up the Estate.
        numberOfHonestNodes = this.testConditions.getNumberofHonestNodes();
        numberOfDeceptiveNodes = this.testConditions.getNumberofDeceptiveNodes();
        
        //Then set up a ResultLog and LogInterpreter
        lengthOfRun = this.testConditions.getLengthofRun();
        numberOfRuns = this.testConditions.getNumberOfRuns();
        logArray = new LogArray(numberOfRuns,lengthOfRun);
        logInterpreter = new LogInterpreter(logArray);

        for (int i=0; i < numberOfRuns; i++) {
            //Set up an estate and attacker (new for each run)
            estate = new Estate(numberOfDeceptiveNodes, numberOfHonestNodes);
            Attacker attacker = new Attacker(logArray, estate);
            //Launch a run.
            attacker.attackRun(lengthOfRun);
            
        }
        System.out.println(logInterpreter.interpretInterceptResults());
    
    }
}
