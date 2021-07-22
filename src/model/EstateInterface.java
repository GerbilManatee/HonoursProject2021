/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Greg
 */
public interface EstateInterface {
    public void nodeInteract(int targetNode, LogArray logArray);
    public void nodeInteract(int targetNode);
    public boolean scan(int targetNode);
    public boolean scan(int targetNode, int modifier);
}
