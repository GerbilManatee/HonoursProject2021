/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hulle_000
 */
public class TestConditions {
    
    /**
    * lengthOfWalk is the number of nodes an attacker will interact with.
    */
    private int lengthOfRun;
    /**
    *numberOfHonestNodes is the number of non-deceptive nodes in the estate
    */
    private int numberOfHonestNodes;
    /**
    * numberOfDeceptiveNodes is the number of deceptive notes in the estate
    */
    private int numberOfDeceptiveNodes;
    /**
     *percentDeceptiveEntryPoints is the percentage of entry points (currently abstracted) that are deceptive.

     */
    private int percentDeceptiveEntryPoints;
    /**
     * numberOfRuns is the number of runs the attacker will make.
     */
    private int numberOfRuns;
    
    /**
    *TestConditions() makes an object with predefined, default conditions.
    */
    
    public TestConditions() {
        lengthOfRun = 20;
        numberOfHonestNodes = 2500;
        numberOfDeceptiveNodes = 100;
        percentDeceptiveEntryPoints = 50;
        numberOfRuns = 5000;
    }
    
    /*
    Methods
    */
    
    /**
    @return the number of nodes the attacker will be interacting with.
    */
    public int getLengthofRun() {
        return lengthOfRun;
    }
    
    /**
    @return the number of honest nodes in the estate
    */
    public int getNumberofHonestNodes() {
        return numberOfHonestNodes;
    }
    
    /**
     * @return the number of deceptive nodes
     */
    public int getNumberofDeceptiveNodes() {
        return numberOfDeceptiveNodes;
    }
 
    /**
     * @return The proportion (as a percentage) of deceptive entry points to the estate.
     */
    public int getPercentDeceptiveEntryPoints() {
        return percentDeceptiveEntryPoints;
    }
    
    /**
     * 
     * @return The number of simulated runs to make in this Monte Carlo sim.
     */
    public int getNumberOfRuns() {
        return numberOfRuns;
    }
    
    
}
