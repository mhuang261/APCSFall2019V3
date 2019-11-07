//Michael Huang
//11/5/19 APCS 3rd
//code produces a calculator that intakes two fractions of any form and calculates the result given an operator
package fracCalc;

import java.util.*;

public class FracCalc {

      public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	String quit = "";
    	String ans = "";
    	
    	while (!quit.equalsIgnoreCase("quit")) {
        	System.out.println("Input two fractions and the operation desired.");
    		ans = console.nextLine();
    		System.out.println(produceAnswer(ans));
    		System.out.println("continue? (quit to quit)");
		    quit = console.nextLine();	
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
        
        //1ST FRACTION
    	
        //describing 1st fraction        
        String num1 = ""; //could be more than a single digit, may be 5_1
        String denom1 = "";// can either be 1 if whole number or something like 5 if fraction (1/5)
        String whole1 = "";
        
        
        //FRACTION, INTEGER AND MIXED NUMBER TESTS
        String[] splitFrac1 = operand1.split("/"); //  if operand 2 is 21/2 then (21, 2)
        String[] splitFrac1Num = splitFrac1[0].split("_"); //splits index 0 at underscore like (5, 1) for 5_1 or (21) for 21,2
        
        //TESTS IF IT IS FRACTION OR INTEGER
        if (splitFrac1Num.length == 1) {//must be fraction or an integer (21/2 or 20)
       
        	//CHECKS FOR FRACTION LIKE 21/2 OR 1/2
        	if (splitFrac1.length > 1) {
        		splitFrac1Num[0] = "0_" + splitFrac1Num[0]; // given (1/2) --> (1) ==> (0_1)
        		String[] splitFrac1NumSingle= (splitFrac1Num[0]).split("_"); //0_1 splits into (0, 1)
        		whole1 = splitFrac1NumSingle[0]; 
        		num1 = splitFrac1NumSingle[1];
        		denom1 = splitFrac1[1];
        	}
        	
        	//CHECKS FOR WHOLE NUMBER LIKE 20 (INTEGER)

        	if (splitFrac1.length == 1) {
        		whole1 = splitFrac1[0];
        		num1 = "0";
        		denom1 = "1";
        	}
        }
     

        	//CHECKS FOR MIXED NUMBER LIKE 5_1/2
        	if (splitFrac1Num.length > 1 ) { // all mixed numbers will pass through here
        		
            	whole1 = splitFrac1Num[0]; 
            	num1 = splitFrac1Num[1];
            	denom1 = splitFrac1[1];
     	}
        
        	//PARSE FIRST FRACTION
        	
        	//NEED TO CONVERT BACK TO INT
            int num1Int = Integer.parseInt(num1);
            int denom1Int = Integer.parseInt(denom1);
            int whole1Int = Integer.parseInt(whole1);
        
        
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
        int whole2Int = Integer.parseInt(whole2);
        int num2Int = Integer.parseInt(num2);
        int denom2Int = Integer.parseInt(denom2);
        
        //MIXED NUMBER CONVERT TO IMPROPER IF 
        if (whole2Int != 0) { // if the whole number is not zero, then will call change mixed number into improper fraction
			num2Int = MixImp(whole2Int, num2Int, denom2Int);
		}else if (whole1Int != 0) {
			whole1Int = MixImp(whole1Int, num1Int, denom2Int);
		}

        return "whole:" + whole2Int + " " + "numerator:" + num2Int + " " + "denominator:" + denom2Int;
    }
    

    // TODO: Fill in the space below with any helper methods that you think you will need 
    //EXTRA METHODS GO HERE
    
    	//MIXED TO IMPROPER (5_1/2 --> 11/2)
    	public static int MixImp (int whole, int num, int denom) {
    		int improperNum = whole*denom + num;
    		return improperNum;
    	}
    	
    	//ADDITION
        public static String add (int whole, int num, int denom) {
        	
        	return "";
        }
        
        //SUBTRACTION
        public static String sub (int whole, int num, int denom) {
        	
        	return "";
        }
        //MULTIPLICATION
        public static String mult (int whole, int num, int denom) {
        	
        	return "";
        }
        //DIVISION 
        public static String divide (int whole, int num, int denom) {
        	
        	return "";
        }
        
    
    
}
