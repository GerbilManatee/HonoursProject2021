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
                lengthOfRun = Integer.parseInt(temp[0]);
                numberOfRuns = Integer.parseInt(temp[1]);
            //}
            line = br.readLine();
            //while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                numberOfHonestNodes = Integer.parseInt(temp[0]);
                numberOfDeceptiveNodes = Integer.parseInt(temp[1]);
                numberOfHonestEntryPoints = Integer.parseInt(temp[2]);
                numberOfDeceptiveEntryPoints = Integer.parseInt(temp[3]);
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
