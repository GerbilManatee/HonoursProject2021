/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.nodes.Node;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class NodeTest {
    
    public NodeTest() {
    }
    
    @Test
    public void ConstructorTest() {
        Node testNode1 = new Node(false);
        Node testNode2 = new Node(true);
        Node testNode3 = new Node();
    }
    
    public void InteractTest() {
        LogArray logArray = new LogArray();
        Node testNode1 = new Node(false);
        Node testNode2 = new Node(true);
        logArray.addResult(testNode1.interact());
        logArray.addResult(testNode2.interact());
        
       
    }
    
    
}
