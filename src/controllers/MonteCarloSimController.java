/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.util.HashSet;
import java.util.Set;
import model.attackers.Attacker;
import model.Estate;
import model.LogArray;
import model.LogInterpreter;
import model.TestConditions;
import repositories.Repository;

/**
 *
 * @author hulle_000
 */
public class MonteCarloSimController {
    //variables
    //private TestConditions testConditions;
    //private int lengthOfRun;
    //private int numberOfHonestNodes;
    //private int numberOfDeceptiveNodes;
    //private int numberOfDeceptiveEntryPoints;
    //private int numberOfHonestEntryPoints;
    //private int numberOfRuns;
    private LogArray logArray;
    private LogInterpreter logInterpreter;
    private Estate estate;
    private Repository repository;
    private Attacker attacker;   
    //constructors
    public MonteCarloSimController() {
        //What do I need it to know when created?
        
        //First, TestConditions.
        //Probably not much else?
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing file (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");               
            this.repository = new Repository(fileName);
        }
        else {
            int lengthOfRun = inputHelper.readInt("How long will the attacker's runs be? (max 1000 lateral moves)",1000,0);
            int numberOfRuns = inputHelper.readInt("How many runs will be made in this test? (max 1,000,000)",10000000,0);
            int numberOfDeceptiveNodes = inputHelper.readInt("How many deceptive nodes will the estate contain? (max. 10,000)",10000,0);
            int numberOfHonestNodes = inputHelper.readInt("How many honest nodes will the estate contain?/n(max. 10,000)",10000,0);
            int numberOfDeceptiveEntryPoints = inputHelper.readInt("Now many of the deceptive nodes will be entry points? NB: There must be at least one entry point, either honest or deceptive.",numberOfDeceptiveNodes,0);
            int numberOfHonestEntryPoints = inputHelper.readInt("How many of the honest nodes will be entry points?",numberOfHonestNodes,Integer.max(1,(1-numberOfDeceptiveEntryPoints)));
            
            this.repository = new Repository();
            this.repository.setLengthOfRun(lengthOfRun);
            this.repository.setNumberOfRuns(numberOfRuns);
            this.repository.setNumberofDeceptiveNodes(numberOfDeceptiveNodes);
            this.repository.setNumberofHonestNodes(numberOfHonestNodes);
            this.repository.setNumberOfDeceptiveEntryPoints(numberOfDeceptiveEntryPoints);
            this.repository.setNumberOfHonestEntryPoints(numberOfHonestEntryPoints);
            
            
        }

        
    }
    //methods
    public void run() {
        //Does all the stuff

        //Set up a ResultLog and LogInterpreter
        int lengthOfRun = this.repository.getLengthOfRun();
        int numberOfRuns = this.repository.getNumberOfRuns();
        logArray = new LogArray(numberOfRuns,lengthOfRun);
        logInterpreter = new LogInterpreter(logArray);
        
        //Get the values in TestConditions for setting up the Estate.
        int numberOfHonestNodes = this.repository.getNumberofHonestNodes();
        int numberOfDeceptiveNodes = this.repository.getNumberofDeceptiveNodes();
        int numberOfDeceptiveEntryPoints = this.repository.getNumberOfDeceptiveEntryPoints();
        int numberOfHonestEntryPoints = this.repository.getNumberOfHonestEntryPoints();
        

        for (int i=0; i < numberOfRuns; i++) {
            //Set up an estate and attacker (new for each run)
            estate = new Estate(numberOfDeceptiveNodes, numberOfHonestNodes, numberOfDeceptiveEntryPoints, numberOfHonestEntryPoints, logArray);
            attacker = new Attacker(estate);
            //Launch a run.
            attacker.attackRun(lengthOfRun);
            logArray.endLog();
            //Do I need to tear down?
        }
        System.out.print(this.repository.toString());
        System.out.println(logInterpreter.printInterceptResults());
        
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Save the test settings (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");               
            this.repository.store(fileName);
        }
        else {
        }

    
    }
}
