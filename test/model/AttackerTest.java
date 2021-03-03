/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//import org.junit.Assert;
//import static org.junit.Assert.fail;

import model.attackers.Attacker;

//import org.junit.Test;
/**
 *
 * @author Greg
 */
public class AttackerTest {
    public AttackerTest() {
        
    }
    
    /*
    * Test Attacker creation
    */
//    @Test
    public void AttackerCreationTest() {        
        int lengthOfWalk = 10;
        int numberOfRuns = 10;
        LogArray logArray = new LogArray(numberOfRuns,lengthOfWalk);
        Estate estate = new Estate(250, 250, 10, 10,logArray);
        
        Attacker attacker = new Attacker(estate);
    }
        
}
