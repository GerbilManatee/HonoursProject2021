/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nodes;

/**
 *
 * @author Greg
 */
public interface NodeInterface {
    public boolean interact();
    public boolean scan();
    public boolean scan(int modifier);
}
