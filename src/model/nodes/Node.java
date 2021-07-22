/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nodes;

import java.util.Random;
import model.LogArray;
import org.apache.commons.math3.random.MersenneTwister;

/**
 *
 * @author hulle_000
 */
public class Node implements NodeInterface {
    protected boolean deceptive;
    protected static MersenneTwister NodeRNG = new MersenneTwister();
    /**
     * int nodeID  stores the ID of the node.
     */
    public Node() {
        this.deceptive = false;
    }

    /**
     * boolean deceptive indicates whether the node is deceptive or not.
     */   
    public Node(boolean deceptive) {
        this.deceptive = deceptive;
    }
    
    
    /**
     * @return nothing.  Updates ResultLog about the content of the node.
     * Uses this.deceptive in order to not have a getter method that could be
     * used to reveal deceptive status.
     */
    /* No longer needed
    public void interact(LogArray logArray){
        //Calls a resultlog method, updating the ResultLog about the result of the interaction.
        logArray.addResult(this.deceptive);
    }
    */
    /**
     * Nodes are scannable for deception, but always report a negative.
     * @return false
     */
    public boolean scan() {
        return false;
    }

    public boolean scan(int modifier) {
        return false;
    }
    /**
     * 
     * @return deception status of the node to the calling object.
     */
    @Override
    public boolean interact() {
        return this.deceptive;
    }
    

}
