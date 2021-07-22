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
public class ShapedAttackRunTest {
    public void ShapedAttackRunTest() {
        
    }
    
    @Test
    public void attackRunTest() {
        ShapedAttacker attacker = new ShapedAttacker();
        for(int n=0; n<100;n++) {
            System.out.println("Attack Run "+n);
            attacker.attackRun(5);
        }
    }
}
