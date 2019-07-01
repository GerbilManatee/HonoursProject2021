/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import model.TestConditions;

/**
 *
 * @author Greg
 */
public interface DAOInterface {
    public TestConditions load(String filename);
    
    public void store(String filename, TestConditions testConditions);
    
}
