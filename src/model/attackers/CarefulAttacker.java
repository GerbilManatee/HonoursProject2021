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
public class CarefulAttacker extends Attacker{
    
    public CarefulAttacker(){
        super();
    }
    
    public CarefulAttacker(LogArray logArray, Estate estate){
        super(logArray, estate);
    }
    
   
    
    private boolean scanNode(int targetNode){
        return estate.scan(targetNode);
    }

    @Override
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
        
        //Once we've finished a run, we tell the LogArray that the run is over.
        logArray.endLog();
    }
}
