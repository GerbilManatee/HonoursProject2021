/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class AttackerTest2 {
    
    public AttackerTest2() {

 }
    @Test
    public void AttackerCreationTest() {
        LogArray logArray = new LogArray(10, 10);
        Estate estate = new Estate(250, 250);
        
        int lengthOfWalk = 10;
        int numberOfRuns = 10;
        logArray = new LogArray(numberOfRuns,lengthOfWalk);
        
        Attacker attacker = new Attacker(logArray, estate);
    }
    
    
}
