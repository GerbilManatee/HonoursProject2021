/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TestConditions;

/**
 *
 * @author Greg
 */
public class DAOObjImpl implements DAOInterface {
    @Override
    public TestConditions load(String filename) {
        
        TestConditions testConditions = new TestConditions();
        
        try{
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                testConditions = (TestConditions) ois.readObject();
            
            }
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        }
        return testConditions;
    }
    
    @Override
    public void store(String filename, TestConditions testConditions) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));       
            output.writeObject(testConditions);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(TestConditions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(TestConditions.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
