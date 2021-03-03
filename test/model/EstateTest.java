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
public class EstateTest {
    
    public EstateTest() {
    }
    
    @Test
    public void constructorTest() {
        Estate estate = new Estate();
        LogArray logArray = new LogArray(10,10);
        estate = new Estate(100,100, 10, 1,logArray);
    }
    
    @Test
    public void getEstateSizeTest() {
        System.out.println("Creating an estate of 10 honest and 10 deceptive nodes.");
        LogArray logArray = new LogArray(10,10);
        Estate estate = new Estate(10,10, 3, 3,logArray);
        System.out.println("The reported size is: " + estate.getEstateSize() + " nodes");
    }
    
    @Test
    public void nodeInteractTest() {
        Estate estate = new Estate();
        System.out.println("The reported size is: " + estate.getEstateSize() + " nodes");
        LogArray logArray  = new LogArray();
        estate.nodeInteract(0, logArray);
    }
}
