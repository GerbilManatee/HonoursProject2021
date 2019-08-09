/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
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
    
    /**
     * A VisibleNode with a configurable chance of detection.
     * @param detectChance 
     */
    public VisibleNode(int detectChance) {
        super(true);
        this.detectChance = detectChance;
    }
    
    public boolean scan() {
        Random rng = new Random();
        return (rng.nextInt(100) < detectChance);
    }
}
