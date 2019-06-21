/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author hulle_000
 */
public class Attacker {
    //Variables
    int knowledge;
    LogArray logArray;
    Estate estate;
    //Constructors

    /**
     *  Default constructor.  Not really suitable for use
     */
    public Attacker(){
        logArray = new LogArray();
        estate = new Estate();
    }
    
    public Attacker(LogArray logArray, Estate estate) {
        this.logArray = logArray;
        this.estate = estate;
    }
    //Methods 
    /**
     * attackRun is arguably the core function of Attacker - to generate a series of interactions with Nodes in the Estate.
     * @param lengthOfRun The number of nodes to interact with in the run.
     */
    public void attackRun(int lengthOfRun) {
        for (int i = 1; i <= lengthOfRun; i++) {
            
            /* On each step of the run, we work out what the attacker knows it
            can target.  Currently this is just a number of possible targets.
            */
            int targetRange = scout(estate);
            
            /*
            Now we select a target from the range.  Just a random number - all
            targets are equal, network is flat.
            */
            
            Random rng = new Random();
            int targetNode = rng.nextInt(targetRange);
            
            /*
            Now interact with a Node
            */
            estate.nodeInteract(targetNode, logArray);
            //test print
            //System.out.println("Attack no. " + i + " on target" + targetNode);
        }
        
        //Once we've finished a run, we tell the LogArray that the run is over.
        logArray.endLog();
    }
    
    /**
     * Scout() is a function that explores the target Estate object, returning data on possible targets.
     * @param estate
     * @return The size of the targeted Estate list 
     */
    
    private int scout(Estate estate) {
        return estate.getEstateSize();
    }
}
