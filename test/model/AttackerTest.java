/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//import org.junit.Assert;
//import static org.junit.Assert.fail;
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
        LogArray logArray = new LogArray(10, 10);
        Estate estate = new Estate(250, 250);
        
        int lengthOfWalk = 10;
        int numberOfRuns = 10;
        logArray = new LogArray(numberOfRuns,lengthOfWalk);
        
        Attacker attacker = new Attacker(logArray, estate);
        attacker.attackRun(10);
    }
    
    
}
