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
     *numberOfHonestEntryPoints is the number of entry points (currently abstracted) that are honest.

     */
    private int numberOfHonestEntryPoints;
    /**
     *numberOfDeceptiveEntryPoints is the number of entry points (currently abstracted) that are deceptive.

     */
    private int numberOfDeceptiveEntryPoints;

    /**
     * numberOfRuns is the number of runs the attacker will make.
     */
    private int numberOfRuns;
    
    /**
    *TestConditions() makes an object with predefined, default conditions.
    */
    
    public TestConditions() {
        lengthOfRun = 5;
        numberOfRuns = 50000;
        numberOfHonestNodes = 750;
        numberOfDeceptiveNodes = 250;
        numberOfHonestEntryPoints = 50;
        numberOfDeceptiveEntryPoints = 50;
    }
    /**
     * Fully qualified constructor
     * @param lengthOfRun The length of the run the attacker will be making on the network.
     * @param numberOfRuns The number of runs to iterate through in the test.
     * @param numberOfHonestNodes The number of non-deceptive nodes in the Estate
     * @param numberOfDeceptiveNodes The number of deceptive nodes in the Estate
     * @param percentDeceptiveEntryPoints The proportion of entry points that are deceptive.
     */
    public TestConditions(int lengthOfRun, int numberOfRuns, int numberOfHonestNodes, int numberOfDeceptiveNodes, int numberOfHonestEntryPoints, int numberOfDeceptiveEntryPoints) {
        this.lengthOfRun = lengthOfRun;
        this.numberOfRuns = numberOfRuns;
        this.numberOfHonestNodes = numberOfHonestNodes;
        this.numberOfDeceptiveNodes = numberOfDeceptiveNodes;
        this.numberOfHonestEntryPoints = numberOfHonestEntryPoints;
        this.numberOfDeceptiveEntryPoints = numberOfDeceptiveEntryPoints;
    }
    
    /*
    Methods
    */
    
    /**
    @return the number of nodes the attacker will be interacting with.
    */
    public int getLengthOfRun() {
        return lengthOfRun;
    }
    
    /**
    @return the number of honest nodes in the estate
    */
    public int getNumberOfHonestNodes() {
        return numberOfHonestNodes;
    }
    
    /**
     * @return the number of deceptive nodes
     */
    public int getNumberOfDeceptiveNodes() {
        return numberOfDeceptiveNodes;
    }
 
    /**
     * @return The number of honest entry points to the estate.
     */
    public int getNumberOfHonestEntryPoints() {
        return numberOfHonestEntryPoints;
    }

    /**
     * @return The number of deceptive entry points to the estate.
     */
    public int getNumberOfDeceptiveEntryPoints() {
        return numberOfDeceptiveEntryPoints;
    }
    
    /**
     * 
     * @return The number of simulated runs to make in this Monte Carlo sim.
     */
    public int getNumberOfRuns() {
        return numberOfRuns;
    }
    
    
    /**
    @param lengthOfRun the number of nodes the attacker will be interacting with.
    */
    public void setLengthOfRun(int lengthOfRun) {
        this.lengthOfRun = lengthOfRun;
    }
    
    /**
     * 
     * @param numberOfHonestNodes the number of honest nodes in the estate
     */
    public void setNumberOfHonestNodes(int numberOfHonestNodes) {
        this.numberOfHonestNodes = numberOfHonestNodes;
    }
    
    /**
     * 
     * @param numberOfDeceptiveNodes the number of deceptive nodes
     */
    public void setNumberOfDeceptiveNodes(int numberOfDeceptiveNodes) {
        this.numberOfDeceptiveNodes = numberOfDeceptiveNodes;
    }
 
    /**
     * 
     * @param numberOfHonestEntryPoints The number of honest entry points to the estate.
     */

    public void setNumberOfHonestEntryPoints(int numberOfHonestEntryPoints) {
        this.numberOfHonestEntryPoints = numberOfHonestEntryPoints;
    }

    /**
     * 
     * @param numberOfDeceptiveEntryPoints  The number of deceptive entry points to the estate.
     */

    public void setNumberOfDeceptiveEntryPoints(int numberOfDeceptiveEntryPoints) {
        this.numberOfDeceptiveEntryPoints = numberOfDeceptiveEntryPoints;
    }
    
    /**
     * 
     * @param numberOfRuns The number of simulated runs to make in this Monte Carlo sim.
     */
    public void setNumberOfRuns(int numberOfRuns) {
        this.numberOfRuns = numberOfRuns;
    }
    
    public String toString(char delimiter) {
        final String QUOTE = "\"";
        final String EOLN = "\n";
        
        String output = Integer.toString(this.lengthOfRun) + delimiter;
        output += Integer.toString(this.numberOfRuns);
        output += EOLN;
        output += Integer.toString(this.numberOfHonestNodes) + delimiter;
        output += Integer.toString(this.numberOfDeceptiveNodes) + delimiter;
        output += Integer.toString(this.numberOfHonestEntryPoints) + delimiter;
        output += Integer.toString(this.numberOfDeceptiveEntryPoints);
        output += EOLN;
        return output;
    }
    
}
