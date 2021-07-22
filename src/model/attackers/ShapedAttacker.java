/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attackers;

import java.util.HashSet;
import java.util.Iterator;
import model.ShapedEstate;
import org.apache.commons.math3.random.MersenneTwister;

/**
 *
 * @author Greg
 */
public class ShapedAttacker implements AttackerInterface{


//Necessary object variables inclued the Estate it's attacking and sets holding knowledge about the estate.
//also the strength of the attacker, passed as a modifier when scanning
    private ShapedEstate estate;
    private MersenneTwister rng;
    private int strength;
/**
 * Default constructor - puts in a default ShapedEstate.
 */    
    public ShapedAttacker() {
        this.estate = new ShapedEstate();
        rng = new MersenneTwister();
        strength = 0;
}
    
    public ShapedAttacker(ShapedEstate estate) {
        this.estate = estate;
        rng = new MersenneTwister();
        strength = 0;
    }
    

    /**
     * 
     * @param lengthOfAttack how many attacks should be made in the run 
     */
    @Override public void attackRun(int lengthOfAttack) {
        int targetNode = -1;
        HashSet targetPool = new HashSet();
        HashSet reconPool = new HashSet();
        HashSet dangerNodes = new HashSet();
        HashSet ownedNodes = new HashSet();
        int lastCapturedNode = -1;
        
        for(int n=0; n < lengthOfAttack; n++) {
            boolean targetIdentified = false;
                if(n==0) {
                    reconPool.addAll(estate.getReconData());
                    //reconPool.removeAll(dangerNodes); //Didn't actually need this - faulty assumption when adding scout functions into the while statement for target finding.
                }

            //Target identification - has a number of options to run through, so uses a while loop.
                
            while(targetIdentified == false) {
                
                //If it's the attacker's first move, a target is selected from the recon pool.
                if(n==0) {
                    if(reconPool.size() > 0) {
                        targetNode = getRandomSetMember(reconPool);
                        reconPool.remove(targetNode);
                        if(estate.scan(targetNode, strength)) {
                            dangerNodes.add(targetNode);
                        }
                        else {
                            targetIdentified = true;
                        }
                    }
                    else {
                        System.out.println("Recon pool emptied while scouting first move");
                        return;
                    }
                }

                //Otherwise, go to the standard target identification routine.
                else {
                    //If you have captured a node in your last attempt (and generally you should have), scout from that node
                    //and add results to the target pool, then clean the pool.
                    if(lastCapturedNode > -1) {
                        targetPool.addAll(scout(lastCapturedNode));
                        targetPool.removeAll(dangerNodes);
                        targetPool.removeAll(ownedNodes);
                    }
                    
                    //Following that, choose a random target node from the target pool if you can.
                    if(targetPool.size() > 0) {
                        targetNode = getRandomSetMember(targetPool);
                        targetPool.remove(targetNode);
                        if(estate.scan(targetNode, strength)) {
                            dangerNodes.add(targetNode);
                        }
                        else {
                            targetIdentified = true;
                        }
                    }
                    //If the pool is empty and the recon pool isn't, go back to the recon pool to find a target.
                    else {
                        if(reconPool.size()>0){
                            targetNode = getRandomSetMember(reconPool);
                            reconPool.remove(targetNode);
                            targetIdentified = true;
                        }
                        
                        //...and if the recon pool is empty too, end the run.
                        
                        else {
                            System.out.println("In move "+n+" the attacker ran out of targets");
                            return;
                        }
                    }
                    
                }
            
            }
            //Ok, target identified if possible.  Attack it.
            attackNode(targetNode);
            ownedNodes.add(targetNode);
            lastCapturedNode = targetNode;

            
                
        }

    }
    
    /**
     * This method pulls a random item from a set and returns it as an int value.
     * @param set a HashSet of integer values.
     * @return 
     */
    public int getRandomSetMember(HashSet set) {
        int index = rng.nextInt(set.size());
        Iterator<Object> iter = set.iterator();
        for(int i = 0; i < index; i++) {
            iter.next();
        }
        return (int) iter.next();

    }
    
    /**
     * Gets scout data  from the attacker's target ShapedEstate.
     * @param scoutNode
     * @return a HashSet of possible targets.
     */
    private HashSet scout(int scoutNode) {
        return estate.getScoutData(scoutNode);
    }
    
    private void attackNode(int targetNode) {
        estate.nodeInteract(targetNode);
    }
    
    /**
     * Sets an attacker strength
     * @param strength the desired strength (modifies the * chance of detecting a deceptive VisibleNode)
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
