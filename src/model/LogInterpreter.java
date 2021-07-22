/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
/**
 *
 * @author hulle_000
 */
public class LogInterpreter {
 
    private LogArray logArray;
    private ArrayList firstDecArray;
    
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
    
    public float interpretInterceptResults() {
        int[] interceptResults = this.getInterceptResults();
        float sum = 0;
        
        for(int i = 0; i < (interceptResults.length); i++) {
            sum += interceptResults[i];
        }
        return ((sum/interceptResults.length)*100);
    }
    
    public int[] getInterceptResults(int startStep, int endStep) {
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
                for(int interaction = startStep;((interaction < resultLogSize) && (interaction < endStep)); interaction++) {
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

        public double interpretInterceptResults(int startStep, int endStep) {
        int[] interceptResults = this.getInterceptResults(startStep, endStep);
        float sum = 0;
        
        for(int i = 0; i < (interceptResults.length); i++) {
            sum += interceptResults[i];
        }
        return ((sum/interceptResults.length)*100);
    }
    
    
    
    //private int getInterceptCount()
    public int[] getInterceptCount(int startStep, int endStep) {
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
            //Default output[logNumber] to 0:
            output[logNumber] = 0;
            //Then iterate through the interactions, looking for a hit.
            for(int interaction = startStep;((interaction < resultLogSize) && (interaction < endStep)); interaction++) {

                hitDeception = logArray.getResult(logNumber, interaction);
                //Then, if it's true:
                if(hitDeception == true){
                    ++output[logNumber];
                
                }
            //break if hitDeception never becomes true
            break;
            }
            
        }
        //return the output array.
        return output;
        
    }
    
    public String printInterceptResults() {
        String output = "Overall likelihood of the attacker interacting with deceptive nodes: "
                + BigDecimal.valueOf(interpretInterceptResults()).setScale(3, RoundingMode.HALF_UP) + "%\n";
        double firstDec = getMeanFirstDeception();
        if(firstDec > 0) {
            output += "When deceived, the attacker hit deception at a mean average of " + BigDecimal.valueOf(firstDec).setScale(2, RoundingMode.HALF_UP) + " moves\n";
        }
        else {
            output += "The attacker never encountered deception in any of their runs";
        }
        return output;
    }
    
    /**
     * 
     * @return the average move in which an attacker is deceived (or -1 if the attacker is never deceived).
     */
    public double getMeanFirstDeception() {
        //Warm up; get the size of the logArray.
        int logArraySize = logArray.getLogArraySize();
        //Count how many results come back with a result
        int positiveResultCount = 0;
        int moveTally = 0;
        
        for(int n=0; n<logArraySize; n++) {
            double m = logArray.getFirstDeception(n);
            if(m > 0) {

                ++positiveResultCount;
                moveTally += m;
            }

        }
        
        if(positiveResultCount > 0) {
            return (double) moveTally/positiveResultCount;
        }
        else {
            return -1;
        }

        
    }
    /**
     * Make Deception Array Returns an ArrayList containing deception results for each run formatted as integers: for a run that interacts with 
     * deception, the integer for that run is the first lateral move in which the attacker encounters deception.  
     * If no deception is encountered, the value is -1.
     * @return Arraylist()
     */
    private ArrayList<Integer> makeDecArray() {
        ArrayList<Integer> decArray = new ArrayList();
        
        for(int logNumber = 0; logNumber < logArray.getLogArraySize(); logNumber++) {
            decArray.add(logArray.getFirstDeception(logNumber));
        }
        
        return decArray;
    }
    
    /**
     * Takes an ArrayList of integer values and returns the mean of all the positive values;
     * @param decArray
     * @return the mean of all positive values in the ArrayListy
     */
    private double getMeanFirstDeception(ArrayList<Integer> decArray) {
        int sum = 0;
        int tally = 0;
        for(Integer value:decArray) {
            int result = (int) value;
            if(result >0) {
                sum += result;
                ++tally;
            }
        }
        if(tally>0) {
            return (double)sum/tally;
        }
        
        return -1;
    }
    
    private int getModalFirstDeception(ArrayList<Integer> decArray, int runLength) {
        int maxValue = 0, maxCount = 0;
        //Collections.sort(decArray);

        for (int i = 0; i <= runLength; ++i) {
            int count = 0;
            for (int j = 0; j < decArray.size(); ++j) {
                if (decArray.get(j) == i) {++count;}
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = i;
            }
        }

        return maxValue;
    }
        
    public double getMedianFirstDeception(ArrayList<Integer> decArray) {
        int middle = decArray.size()/2;
        if (decArray.size()%2 == 1) {
            return decArray.get(middle);
        } else {
            return ((decArray.get(middle-1) + decArray.get(middle)) / 2.0);
        }
    }
        
    public double getInterceptChance(ArrayList<Integer> decArray) {
 
        int total = 0;
        total = decArray.stream()
                .filter((n) -> (n.intValue() > 0))
                .map((n) -> 1)
                .reduce(total, Integer::sum);
        
        if(decArray.size()>0) {
            return (double) 100*total/decArray.size();
        }
        return 0;
    }
    
    public void printArrayedResults() {
        ArrayList<Integer> decArray = makeDecArray();
        System.out.println("The attacker encountered deception in " + getInterceptChance(decArray) + "% of runs");

        ArrayList<Integer> filteredArray = new ArrayList();
        decArray.stream().filter((value) -> (value.intValue()>0)).forEachOrdered((value) -> {
            filteredArray.add(value);
        });
        
        if(filteredArray.size()>0) {
            System.out.println(filteredArray.size() + " runs encountered deception. From these, the average number of lateral moves taken to interact with a deceptive node was: ");
            double mean = getMeanFirstDeception(filteredArray);
            System.out.println("Mean value: " + BigDecimal.valueOf(mean).setScale(2, RoundingMode.HALF_UP) + " lateral moves");
            System.out.println("Standard deviation is  " + BigDecimal.valueOf(stDev(filteredArray, mean)).setScale(2, RoundingMode.HALF_UP));
            System.out.println("Modal value: " + getModalFirstDeception(filteredArray,logArray.getResultLogLength(0)) + " lateral moves");
            System.out.println("Median Value: " + getMedianFirstDeception(filteredArray) + " lateral moves");
        } else {
            System.out.println("As there were no encounters with deception, no additional data could be calculated");
        }
    }
    
    public double stDev(ArrayList<Integer> decArray, double mean) {
        double total = 0;
        for(int i=0; i<decArray.size();++i) {
            double x = (decArray.get(i)-mean);
            total += (x*x);
        }
        total = total/(decArray.size()-1);
        total = sqrt(total);
        return total;
    }

}
