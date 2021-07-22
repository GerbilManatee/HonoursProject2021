/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.HashSet;
import model.attackers.ShapedAttacker;
import org.junit.Test;
/**
 *
 * @author Greg
 */
public class ShapedAttackerTest {
    public ShapedAttackerTest() {
        
    }
    
    @Test
    public void AttackerCreationTest() {
        ShapedAttacker attacker = new ShapedAttacker();
        HashSet testSet = new HashSet();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
        testSet.add(4);
        testSet.add(5);
        testSet.add(6);
        testSet.add(7);
        testSet.add(8);
        testSet.add(9);
        testSet.add(10);
        testSet.add(11);
        testSet.add(12);
        testSet.add(13);
        
        for(int n=0;n<50;n++){
            System.out.println(attacker.getRandomSetMember(testSet));
        }
    }
}
