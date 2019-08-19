/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TestConditions;

/**
 *
 * @author Greg
 */
public class DAOTextImpl implements DAOInterface {
    static final char DELIMITER=',';
    @Override
    public TestConditions load(String filename) {

        TestConditions testConditions = new TestConditions();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { 
            String[] temp;
            String line = br.readLine();
            int lengthOfRun;
            int numberOfRuns;
            int numberOfHonestNodes;
            int numberOfDeceptiveNodes;
            int numberOfHonestEntryPoints;
            int numberOfDeceptiveEntryPoints;
            //while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                testConditions.setLengthOfRun(Integer.parseInt(temp[0]));
                testConditions.setNumberOfRuns(Integer.parseInt(temp[1]));
            //}
            line = br.readLine();
            //while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                testConditions.setNumberOfHonestNodes(Integer.parseInt(temp[0]));
                testConditions.setNumberOfDeceptiveNodes(Integer.parseInt(temp[1]));
                testConditions.setNumberOfHonestEntryPoints(Integer.parseInt(temp[2]));
                testConditions.setNumberOfDeceptiveEntryPoints(Integer.parseInt(temp[3]));
                if(temp.length > 5) {
                    testConditions.setVisibleNodes(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
                }
            //}

        br.close();
        } catch(IOException ex ) {
            Logger.getLogger(TestConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        Repository repository = new Repository(list);
        
       return testConditions;
    }
    
    @Override
    public void store(String filename, TestConditions testConditions) {

        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(testConditions.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestConditions.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
        private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
        
    public DAOTextImpl() {
        
    }
}
