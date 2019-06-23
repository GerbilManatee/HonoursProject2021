/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hulle_000
 */
public class LogInterpreter {
 
    private LogArray logArray;
    
    /**
     * Default constructor - fallback only
     */
    public LogInterpreter(){
    
        logArray = new LogArray();
    }
    
    /**
     * Standard constructor.  Creates a LogInterpreter pointing at the LogArray being used by the app.
     * LogInterpreter contains methods used to query the LogArray it is referred to.
     * @param logArray This is the LogArray used by the creating object.
     */
    public LogInterpreter(LogArray logArray) {
        this.logArray = logArray;
    }
    
    /**
     * 
     * @return An int array of length equal to the length of the LogArray, 
     * holding in each entry a value of 1 if there was an interception and 0 
     * if there wasn't.
     */
    public int[] getInterceptResults() {
        //First check the size of the LogArray
        int logArraySize = logArray.getLogArraySize();
        //Then set up an array of the correct size to contain all the results.
        int[] output = new int[logArraySize];
        //Now we iterate through all the ResultLogs
        for(int logNumber = 0; logNumber < logArraySize; logNumber++) {
            /*
            In each loop, first get the size of the ResultLog.  Never mind that 
            they're likely all the same, that might not always be the case.
            */
            int resultLogSize = logArray.getResultLogLength(logNumber);
            //create a boolean to record whether the run involves an interaction
            //with a deceptive Node.
            boolean hitDeception = false;
            //Use a while loop to pull out of the check once we have a confirmed hit.
            //Could dump this if it's inelegant, but for huge logs it might save time.
            while(hitDeception == false){
                //Default output[logNumber to 0:
                output[logNumber] = 0;
                //Then iterate through the interactions, looking for a hit.
                for(int interaction = 0;interaction < resultLogSize; interaction++) {
                    /*
                    change hitDeception to true when you find an interaction 
                    with a deceptive node - it goes to false again in the 
                    */
                    hitDeception = logArray.getResult(logNumber, interaction);
                    //Then, if it's true and you're about to fall out of the while loop:
                    if(hitDeception == true){
                        output[logNumber] = 1;
                    }
                }
                //break if hitDeception never becomes true
                break;
            }
                
        }
        //return the output array.
        return output;
        
    }
    
    
    
}
