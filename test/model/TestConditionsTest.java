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
public class TestConditionsTest {
    
    public TestConditionsTest() {
    }
    
    @Test
    public void ConstructorTest() {
        TestConditions testConditions = new TestConditions(9999,9999,9999,9999,9999,9999);
    }
    
    @Test
    public void gettersToStringTest() {
        TestConditions testConditions = new TestConditions(9999,9999,9999,9999,9999,9999);
        System.out.println(testConditions.getLengthOfRun());
        System.out.println(testConditions.getNumberOfRuns());
        System.out.println(testConditions.getNumberOfHonestNodes());
        System.out.println(testConditions.getNumberOfDeceptiveNodes());
        System.out.println(testConditions.getNumberOfHonestEntryPoints());
        System.out.println(testConditions.getNumberOfDeceptiveEntryPoints());
        System.out.println(testConditions.toString(','));
    }
    
}
