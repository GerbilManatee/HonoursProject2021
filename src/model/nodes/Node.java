/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nodes;

import java.util.Random;
import model.LogArray;

/**
 *
 * @author hulle_000
 */
public class Node implements NodeInterface {
    /**
     * boolean deceptive indicates whether the node is deceptive or not.
     */
    private boolean deceptive;
    /**
     * int nodeID  stores the ID of the node.
     */
    public Node() {
        this.deceptive = false;
    }
    
    public Node(boolean deceptive) {
        this.deceptive = deceptive;
    }
    
    
    /**
     * @return nothing.  Updates ResultLog about the content of the node.
     * Uses this.deceptive in order to not have a getter method that could be
     * used to reveal deceptive status.
     */
    public void interact(LogArray logArray){
        //Calls a resultlog method, updating the ResultLog about the result of the interaction.
        logArray.addResult(this.deceptive);
    }
    
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

    @Override
    public boolean interact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
