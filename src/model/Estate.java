/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hulle_000
 */
public class Estate {

    List<Node> nodeArray;
    
    //Default constructor - 
    public Estate() {
        
    }
    
    public Estate(int numberOfDeceptiveNodes, int numberOfHonestNodes) {
        /* I was thinking of using an array, but I'd prefer a List structure for nodes just now.
        It makes Bayesian handling interactions with individual Nodes and their
        removal from the pool of available nodes for an Attacker to interact with
        implicit rather than explicit.
        This could be replaced in the end by an Attacker having a memory of 
        where it has been, so it doesn't backtrack and the Estate does not
        shrink as a result of standard interactions.
        
        Thought: what if some interactions *could* shrink the Estate?
        
        Some array implementation code is present but commented out.
        */
        
        //Node[] nodeArray;
        //nodeArray = new Node[numberOfDeceptiveNodes + numberOfHonestNodes];
        nodeArray = new ArrayList<Node>();
        
        //Create honest nodes first, one at a time.
        for (int i = 0; i < numberOfHonestNodes; i++) {
            //nodeArray[i] = new Node(false);
            nodeArray.add(i, new Node(false));
            //System.out.println("Honest: " + i);
        }
        
        
        //Now create the deceptive nodes the same way.
        for (int i = (0 + numberOfHonestNodes); i < (numberOfDeceptiveNodes + numberOfHonestNodes); i++) {
            //nodeArray[i] = new Node(true);
            nodeArray.add(i, new Node(true));
            //System.out.println("Deceptive: " + i);
        }
        
        
        
        
    }
    /**
     * 
     * @return The size of nodeArray as an integer value.
     */
    public int getEstateSize() {
        return nodeArray.size();
    }
    
    public void nodeInteract(int targetNode, LogArray logArray) {
        Node node = nodeArray.get(targetNode);
        node.interact(logArray);
        nodeArray.remove(targetNode);
        //System.out.println("Attacked and removed node" + targetNode);
    }
} 
