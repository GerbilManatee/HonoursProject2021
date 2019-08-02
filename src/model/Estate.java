/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hulle_000
 */
public class Estate {

    List<Node> nodeArray;
    int numberOfDeceptiveEntryPoints;
    int numberOfHonestEntryPoints;
    
    //Default constructor - one honest and 1 deceptive node.
    public Estate() {
        nodeArray = new ArrayList<Node>();
        nodeArray.add(new Node(false));
        nodeArray.add(new Node(true));
        
    }
    
    public Estate(int numberOfDeceptiveNodes, int numberOfHonestNodes, int numberOfDeceptiveEntryPoints, int numberOfHonestEntryPoints) {
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
        this.numberOfDeceptiveEntryPoints = numberOfDeceptiveEntryPoints;
        this.numberOfHonestEntryPoints = numberOfHonestEntryPoints;
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
        }
        
        
        
        
    }
    /**
     * 
     * @return The size of nodeArray as an integer value.
     */
    public int getEstateSize() {
        return nodeArray.size();
    }
    
    /**
     * A given node in the Estate is selected.  The node's interact() method is called and the node is then moved from the array.
     * @param targetNode The node the Attacker is attacking
     * @param logArray The LogArray to log the interaction with.
     */
    public void nodeInteract(int targetNode, LogArray logArray) {
        Node node = nodeArray.get(targetNode);
        node.interact(logArray);
        nodeArray.remove(targetNode);
        //System.out.println("Attacked and removed node" + targetNode);
    }
    /**
     * Gives either an honest node or a deceptive one as the entry point to the network.
     * @return either 0 or the size of the nodeArray.
     */
    //Expect to change this once the attacker gets a different form of knowledge.
    public int getReconData() {
        
        int numberOfEntryPoints = this.numberOfHonestEntryPoints + this.numberOfDeceptiveEntryPoints;
            Random rng = new Random();
            int targetNode = rng.nextInt(numberOfEntryPoints);
            if(targetNode < this.numberOfHonestEntryPoints) {
                return 0;
            } else {
                return (nodeArray.size() - 1);
            }

    }
    
} 
