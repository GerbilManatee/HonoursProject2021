/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlosim;
import controllers.ShapedMonteCarloSimController;
/**
 *
 * @author hulle_000
 */
public class MonteCarloSim {
    /**
     * @param args the command line arguments
     */
    
    public static void run() {
        ShapedMonteCarloSimController monteCarloSimController = new ShapedMonteCarloSimController();
        monteCarloSimController.run();
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        MonteCarloSim monteCarloSim = new MonteCarloSim();
        monteCarloSim.run();
    }
    
}
