/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nodes;

//import java.util.Random;
//import org.apache.commons.math3.random.MersenneTwister;

/**
 *VisibleNodes are a deceptive node that can be detected as such by an Attacker
 * that scans them.
 * @author Greg
 * VisibleNodes are a deceptive node that can be detected as such by an Attacker
 * that scans them.
 */
public class VisibleNode extends Node {
    
    /**
     * Percentage chance of an Attacker being able to detect the node
     */
    int detectChance;
    
    /**
     * VisibleNodes are deceptive by default, with a 10% default chance
     * of detection
     */
    public VisibleNode() {
        super(true);
        this.detectChance = 10;
    }

    public VisibleNode(boolean deceptive) {
        super(deceptive);
        this.detectChance = 0;
    }
    
    /**
     * A VisibleNode with a configurable chance of detection.
     * @param deceptive as per the super class, this is the deceptive state of the node
     * @param detectChance 
     */
    public VisibleNode(boolean deceptive,int detectChance) {
        super(deceptive);
        this.detectChance = detectChance;
    }
    
    /**
     * Overridden scan() methods.  When scanned, detectChance is used as a
     * percentage chance of the node being detected as deceptive.
     * @return true if the node is successfully scanned.
     */
    @Override
    public boolean scan() {
        if(NodeRNG.nextInt(100) < detectChance) {
            return this.deceptive;
        }
        else {
           return false; 
        }
    }

    @Override
    public boolean scan(int modifier) {

        if(NodeRNG.nextInt(100) < (detectChance + modifier)) {
            return this.deceptive;
        }
        else {
           return false; 
        }

    } 
}
