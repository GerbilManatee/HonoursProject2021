/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attackers;

import java.util.Random;
import model.Estate;
import model.LogArray;

/**
 *
 * @author hulle_000
 */
public class Attacker {
    //Variables
    int knowledge;
//    LogArray logArray;
    Estate estate;
    //Constructors

    /**
     *  Default constructor.  Not really suitable for use
     */
    public Attacker(){
//        logArray = new LogArray();
        estate = new Estate();
    }
    
    public Attacker(Estate estate) {
//        this.logArray = logArray;
        this.estate = estate;
    }
    //Methods 
    /**
     * attackRun is arguably the core function of Attacker - to generate a series of interactions with Nodes in the Estate.
     * @param lengthOfRun The number of nodes to interact with in the run.
     */
    public void attackRun(int lengthOfRun) {

        int targetNode;

        for (int i = 1; i <= lengthOfRun; i++) {
            int targetRange;
            /* On each step of the run, we work out what the attacker knows it
            can target.  On the first step of the run this is the entry point, 
            subsequently this is just a number of possible targets.
            */
            if(i==1) {
                targetNode = recon(estate);
            } else {
                targetRange = scout(estate);
                /*
                Now we select a target from the range.  Just a random number - all
                targets are equal, network is flat.
                */
            
                Random rng = new Random();
                targetNode = rng.nextInt(targetRange);
            }
            
            
            /*
            Now interact with a Node
            */
            attackNode(targetNode);
            //test print
            //System.out.println("Attack no. " + i + " on target" + targetNode);
        }
    }
    
    /**
     * Scout() is a function that explores the target Estate object, returning data on possible targets.
     * @param estate
     * @return The size of the targeted Estate list 
     */
    
    protected int scout(Estate estate) {
        return estate.getEstateSize();
    }
    /**
     * recon is a method that represents the initial scout of an estate.  It 
     * will return a node reference representing an entry point.
     * @param estate
     * @return int value of an entry point.
     */
    protected int recon(Estate estate) {
        return estate.getReconData();
    }
    
    protected void attackNode(int targetNode) {
            estate.nodeInteract(targetNode);
        
    }
}
