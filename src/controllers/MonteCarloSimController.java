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
        
        //First, use the values in TestConditions to set up the Estate.
        numberOfHonestNodes = this.testConditions.getNumberofHonestNodes();
        numberOfDeceptiveNodes = this.testConditions.getNumberofDeceptiveNodes();
        estate = new Estate(numberOfDeceptiveNodes, numberOfHonestNodes);
        
        //Then set up a ResultLog and LogInterpreter
        lengthOfRun = this.testConditions.getLengthofRun();
        numberOfRuns = this.testConditions.getNumberOfRuns();
        logArray = new LogArray(numberOfRuns,lengthOfRun);
        logInterpreter = new LogInterpreter(logArray);
        //Now set up an Attacker to attack the Estate.
        Attacker attacker = new Attacker(logArray, estate);

        for (int i=0; i < numberOfRuns; i++) {
            attacker.attackRun(lengthOfRun);
            
        }
        System.out.println(logInterpreter.interpretInterceptResults());
    
    }
}
