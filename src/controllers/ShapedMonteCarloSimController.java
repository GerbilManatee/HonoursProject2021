/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import helpers.InputHelper;
import java.util.HashSet;
import java.util.Set;
import model.attackers.ShapedAttacker;
import model.ShapedEstate;
import model.LogArray;
import model.LogInterpreter;
import model.TestConditions;
import repositories.Repository;
/**
 *
 * @author Greg
 */
public class ShapedMonteCarloSimController {

    private LogArray logArray;
    private LogInterpreter logInterpreter;
    private ShapedEstate estate;
    private Repository repository;
    private ShapedAttacker attacker;   
    
    public ShapedMonteCarloSimController() {
        InputHelper inputHelper = new InputHelper();
        
        System.out.println("Shaped Network Monte Carlo Sim");
        //System.out.println("Press a key to run the default simulation");
        //char c = inputHelper.readInt("Choose an option");
        
            
    }
    
    public void run() {

        InputHelper inputHelper = new InputHelper();
        int numberOfRuns = inputHelper.readInt("How many runs will be made in this test? (max 1,000,000)",10000000,0);
        int lengthOfRun = inputHelper.readInt("How many lateral moves will the attacker make? (max 90)",90,0);
        int deceptionCount = inputHelper.readInt("How many deceptive nodes will the network contain? (max 96)", 96, 0);
        int attackerStrength = inputHelper.readInt("Enter a number for attacker strength (% chance of identifying a deceptive node before interacting with it).");
        logArray = new LogArray(numberOfRuns,lengthOfRun);
        logInterpreter = new LogInterpreter(logArray);

        
        for (int i=0; i < numberOfRuns; i++) {
            //Set up an estate and attacker (new for each run)
            estate = new ShapedEstate(logArray,deceptionCount);
            attacker = new ShapedAttacker(estate);
            attacker.setStrength(attackerStrength);
            //Launch a run.
            attacker.attackRun(lengthOfRun);
            logArray.endLog();
        }

        System.out.println(logInterpreter.printInterceptResults());
        logInterpreter.printArrayedResults();

    }

}
