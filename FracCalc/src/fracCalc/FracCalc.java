//Michael Huang
//11/5/19 APCS 3rd
//code produces a calculator that intakes two fractions of any form and calculates the result given an operator
package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	boolean quit = false;
    	String ans = "";
    	
    	System.out.println("fraction please:");

    	while (quit = false) {
        	System.out.println("fraction please:");
    		ans = console.nextLine();
    		System.out.println(produceAnswer(ans));
    		
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
        String num1 = "";
        String denom1 = "";   
        String whole1 = "";
        
        
        
        //2ND FRACTION
                	
        //describing 2nd fraction        
        String num2 = ""; //could be more than a single digit, may be 5_1
        String denom2 = "";// can either be 1 if whole number or something like 5 if fraction (1/5)
        String whole2 = "";
        
        
        //FRACTION, INTEGER AND MIXED NUMBER TESTS
        String[] splitFrac2 = operand2.split("/"); //  if operand 2 is 21/2 then (21, 2)
        String[] splitFrac2Num = splitFrac2[0].split("_"); //splits index 0 at underscore like (5, 1) for 5_1 or (21) for 21,2
        
        //TESTS IF IT IS FRACTION OR INTEGER
        if (splitFrac2Num.length == 1) {//must be fraction or an integer (21/2 or 20)
        	
        	//String[] splitFrac2NumWholeTest = splitFrac2Num[0].split("/"); // difference between frac and whole num (1/2 & 5) is / so we split.
        	//splitFrac2NumWholeTest = (21)
        	
        	//CHECKS FOR FRACTION LIKE 21/2 OR 1/2
        	if (splitFrac2.length > 1) {
        		splitFrac2Num[0] = "0_" + splitFrac2Num[0]; // given (1/2) --> (1) ==> (0_1)
        		String[] splitFrac2NumSingle= (splitFrac2Num[0]).split("_"); //0_1 splits into (0, 1)
        		whole2 = splitFrac2NumSingle[0]; 
        		num2 = splitFrac2NumSingle[1];
        		denom2 = splitFrac2[1];
        	}
        	
        	//CHECKS FOR WHOLE NUMBER LIKE 20 (INTEGER)

        	if (splitFrac2.length == 1) {
        		whole2 = splitFrac2[0];
        		num2 = "0";
        		denom2 = "1";
        	}
        }
     

        	//CHECKS FOR MIXED NUMBER LIKE 5_1/2
        	if (splitFrac2Num.length > 1 ) { // all mixed numbers will pass through here
        		
            	whole2 = splitFrac2Num[0]; 
            	num2 = splitFrac2Num[1];
            	denom2 = splitFrac2[1];
     	}
             
        //NEED TO CONVERT BACK TO INT
        int num2Int = Integer.parseInt(num2);
        int denom2Int = Integer.parseInt(denom2);
        int whole2Int = Integer.parseInt(whole2);

        return "whole:" + whole2Int + " " + "numerator:" + num2Int + " " + "denominator:" + denom2Int;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
