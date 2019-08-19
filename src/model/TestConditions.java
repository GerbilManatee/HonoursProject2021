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
     * The number of VisibleNodes
     */
    private int numberVisibleNodes;
    
    /**
     * % chance of detecting a visible node
     */
    private int visibleNodeDetect;
    
    /**
    *TestConditions() makes an object with predefined, default conditions.
    */
    
    public TestConditions() {
        lengthOfRun = 0;
        numberOfRuns = 0;
        numberOfHonestNodes = 0;
        numberOfDeceptiveNodes = 0;
        numberOfHonestEntryPoints = 0;
        numberOfDeceptiveEntryPoints = 0;
        numberVisibleNodes = 0;
        visibleNodeDetect = 0;
    }
    /**
     * Mostly qualified constructor
     * @param lengthOfRun The length of the run the attacker will be making on the network.
     * @param numberOfRuns The number of runs to iterate through in the test.
     * @param numberOfHonestNodes The number of non-deceptive nodes in the Estate
     * @param numberOfDeceptiveNodes The number of deceptive nodes in the Estate
     * @param numberOfHonestEntryPoints Number of possible honest entry points
     * @param numberOfDeceptiveEntryPoints number of possible deceptive entry points.
     */
    public TestConditions(int lengthOfRun, int numberOfRuns, int numberOfHonestNodes, int numberOfDeceptiveNodes, int numberOfHonestEntryPoints, int numberOfDeceptiveEntryPoints) {
        this.lengthOfRun = lengthOfRun;
        this.numberOfRuns = numberOfRuns;
        this.numberOfHonestNodes = numberOfHonestNodes;
        this.numberOfDeceptiveNodes = numberOfDeceptiveNodes;
        this.numberOfHonestEntryPoints = numberOfHonestEntryPoints;
        this.numberOfDeceptiveEntryPoints = numberOfDeceptiveEntryPoints;
        numberVisibleNodes = 0;
        visibleNodeDetect = 0;
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
     * @return the number of visible nodes.
     */
    public int getVisibleNodes() {
        return numberVisibleNodes;
    }
    
    public int getVisibleNodeDetect() {
        return visibleNodeDetect;
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
     * Sets conditions for visible nodes in the system.
     * @param numberVisibleNodes the number of VisibleNodes there will be.
     * @param visibleNodeDetect the % chance these nodes will be detected.
     */
    public void setVisibleNodes(int numberVisibleNodes, int visibleNodeDetect) {
        this.numberVisibleNodes = numberVisibleNodes;
        this.visibleNodeDetect = visibleNodeDetect;
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
        output += Integer.toString(this.numberOfDeceptiveEntryPoints) + delimiter;
        output += Integer.toString(this.numberVisibleNodes) + delimiter;
        output += Integer.toString(this.visibleNodeDetect);
        output += EOLN;
        return output;
    }
    
    @Override
    public String toString() {
        String output = "Test Conditions:\n";
        output += "Number of deceptive nodes:        " + this.numberOfDeceptiveNodes + "\n";
        output += "Number of honest nodes:           " + this.numberOfHonestNodes + "\n";
        output += "Number of deceptive entry points: " + this.numberOfDeceptiveEntryPoints + "\n";
        output += "Number of honest entry points:    " + this.numberOfHonestEntryPoints + "\n";
        if(this.numberVisibleNodes > 0) {
            output += "Number of 'visible nodes':        " + this.numberVisibleNodes + "\n";
        }
        
        output += "Length of each attack run:        " + this.lengthOfRun + "\n";
        output += "Number of runs simulated:         " + this.numberOfRuns + "\n";
        
        return output;
    }
}
