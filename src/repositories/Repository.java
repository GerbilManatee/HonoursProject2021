/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import daos.DAOTextImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TestConditions;
import helpers.InputHelper;

/**
 *
 * @author mga
 */
public class Repository implements java.io.Serializable {
    private TestConditions testConditions;    
    static char DELIMITER=',';
    
    public Repository() {
        this.testConditions = new TestConditions();
    }
    
    public Repository(TestConditions testConditions) {        
        this.testConditions = testConditions;
    }
    
    public Repository(String filename) {
        //this();

        DAOTextImpl dao = new DAOTextImpl();
        this.testConditions = dao.load(filename);
   }
    

    
    public void store(String filename) {
       DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this.testConditions);
    }

    /**
    @return the number of nodes the attacker will be interacting with.
    */
    public int getLengthOfRun() {
        return testConditions.getLengthOfRun();
    }
    
    /**
    @return the number of honest nodes in the estate
    */
    public int getNumberofHonestNodes() {
        return testConditions.getNumberOfHonestNodes();
    }
    
    /**
     * @return the number of deceptive nodes
     */
    public int getNumberofDeceptiveNodes() {
        return testConditions.getNumberOfDeceptiveNodes();
    }
 
    /**
     * @return The number of honest entry points to the estate.
     */
    public int getNumberOfHonestEntryPoints() {
        return testConditions.getNumberOfHonestEntryPoints();
    }

    /**
     * @return The number of deceptive entry points to the estate.
     */
    public int getNumberOfDeceptiveEntryPoints() {
        return testConditions.getNumberOfDeceptiveEntryPoints();
    }
    
    /**
     * 
     * @return The number of simulated runs to make in this Monte Carlo sim.
     */
    public int getNumberOfRuns() {
        return testConditions.getNumberOfRuns();
    }
    
    
    /**
    @param lengthOfRun the number of nodes the attacker will be interacting with.
    */
    public void setLengthOfRun(int lengthOfRun) {
        this.testConditions.setLengthOfRun(lengthOfRun);
    }
    
    /**
     * 
     * @param numberOfHonestNodes the number of honest nodes in the estate
     */
    public void setNumberofHonestNodes(int numberOfHonestNodes) {
        this.testConditions.setNumberOfHonestNodes(numberOfHonestNodes);
    }
    
    /**
     * 
     * @param numberOfDeceptiveNodes the number of deceptive nodes
     */
    public void setNumberofDeceptiveNodes(int numberOfDeceptiveNodes) {
        this.testConditions.setNumberOfDeceptiveNodes(numberOfDeceptiveNodes);
    }
 
    /**
     * 
     * @param numberOfHonestEntryPoints The number of honest entry points to the estate.
     */

    public void setNumberOfHonestEntryPoints(int numberOfHonestEntryPoints) {
        this.testConditions.setNumberOfHonestEntryPoints(numberOfHonestEntryPoints);
    }

    /**
     * 
     * @param numberOfDeceptiveEntryPoints  The number of deceptive entry points to the estate.
     */

    public void setNumberOfDeceptiveEntryPoints(int numberOfDeceptiveEntryPoints) {
        testConditions.setNumberOfDeceptiveEntryPoints(numberOfDeceptiveEntryPoints);
    }
    
    /**
     * 
     * @param numberOfRuns The number of simulated runs to make in this Monte Carlo sim.
     */
    public void setNumberOfRuns(int numberOfRuns) {
        testConditions.setNumberOfRuns(numberOfRuns);
    }
    
    @Override
    public String toString() {
        return this.testConditions.toString();
    }
}
