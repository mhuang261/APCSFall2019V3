package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	boolean quit = false;
    	System.out.println("fraction please:");
		String a = console.nextLine();

    	while (quit == false) {
    		System.out.println(produceAnswer(a));
        	System.out.println("fraction please:");
    		a = console.nextLine();
    		System.out.println(produceAnswer(a));
    		
    		if (console.nextLine().equals("quit")) {//if quit then will not continue
    			quit = true;
    		}
    	}	
    	
    	
        // TODO: Read the input from the user and call produceAnswer with an equation   	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
    	//first level takes inputs
        String operand1 = "";
        String operand2 = "";
        String operator = "";
        
        String[] arrOfStr = input.split(" "); //test with 1/2 + 5 1/2
        operand1 = arrOfStr[0];
        operator = arrOfStr[1];
        operand2 = arrOfStr[2];
        
        //splits first level of inputs
        
        String[] splitFrac1 = operand1.split("/"); //declaring and splitting operand 1/2 into (1, 2)
        //describing 1st fraction
        String num1 = splitFrac1[0];
        String denom1 = splitFrac1[1];   
        String whole1 = "";
        
        
        
        //2ND FRACTION
                	
        //describing 2nd fraction

        String[] splitFrac2 = operand2.split("/"); //  now I have 1_1, 2
        
        String num2 = splitFrac2[0]; //could be more than a num  
        String denom2 = splitFrac2[1];// operand2 = 20 if 
        String whole2 = "";
        
        
        //TESTS IF IT IS FRACTION
        String[] splitFrac2Num = splitFrac2[0].split("_"); //splits index 0 at underscore (1, 1)
        
        if (splitFrac2Num.length == 1) {//must be fraction or an integer
        	String[] splitFrac2NumWholeTest = splitFrac2Num[0].split("/"); //splits num at _
        	//CHECKS FOR FRACTION
        	if (splitFrac2NumWholeTest.length > 1) {
        		splitFrac2Num[0] = "0_" + splitFrac2Num[0]; // 1 (1) --> 0_1 given (1/3)
        		String[] splitFrac2NumWhole = (splitFrac2Num[0]).split("_"); //0_1 splits at _
        		whole2 = splitFrac2NumWhole[0]; //0_1
        		num2 = splitFrac2NumWhole[1];
        	}
        	//CHECKS FOR INTEGER
        	if (splitFrac2NumWholeTest.length == 1) { 
            	String[] splitFrac2NumWhole = (splitFrac2Num[0]).split("_"); //split fraction at 
            	whole2 = splitFrac2NumWhole[0]; 
            	num2 = "0";
            	denom2 = "1";
     	}
  }
        
        //TESTS IF IT IS MIXED NUM & ASSIGNS WHOLE NUMBER AND NUM (DENOM ALREADY ASSIGNED ABOVE)
        
        if (splitFrac2Num.length != 1) { //must have a whole number and therefore be a mixed number
        	whole2 = splitFrac2Num[0]; //whole number will equal the whole number 
        	num2 = splitFrac2Num[1];
        }
             
        //NEED TO CONVERT BACK TO INT
        int num2Int = Integer.parseInt(num2);
        int denom2Int = Integer.parseInt(denom2);
        int whole2Int = Integer.parseInt(whole2);
        return "whole:" + whole2Int + " " + "numerator:" + num2Int + " " + "denominator:" + denom2Int;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
