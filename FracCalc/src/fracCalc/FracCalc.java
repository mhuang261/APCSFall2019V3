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
    		System.out.println("continue? (quit to quit, yes to continue)");
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
    	
        String[] arrOfStr = input.split(" "); //test with 1/2 + 5 1/2
        String operand1 = arrOfStr[0];
        String operator = arrOfStr[1];
        String operand2 = arrOfStr[2];
        
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
     
        //MIXED NUMBER CONVERT TO IMPROPER TO ACCESS LCM EASIER
			num2Int = mixImp(whole2Int, num2Int, denom2Int);
			num1Int = mixImp(whole1Int, num1Int, denom1Int); 
       
       //TESTING FOR OPERATORS
       
       if (operator.equals("+") || operator.equals("-")) {
           return addSub(num1Int, num2Int, denom1Int, denom2Int, operator);   
    	   
       }else if (operator.equals("*")) {
    	   return mult(num1Int, denom1Int, num2Int, denom2Int);

       }else {
    	   return divide(num1Int, denom1Int, num2Int, denom2Int);
       }
    }  
    //EXTRA METHODS GO HERE
    
    	//MIXED TO IMPROPER (5_1/2 --> 11/2)
    	public static int mixImp (int whole, int num, int denom) {
    		int improperNum = 0;
    		if (whole < 0) {
    		    improperNum = whole*denom - num;
    		}else {
    		    improperNum = whole*denom + num;
    		}
       		return improperNum; 
    	}
    	
    	//CHECKS FOR OPERATOR FUNCTIONS
    	public static String opChecks (int whole, int remain, int lcm, int sumOrDiff) {
    		int tester = 0;
    		
    		if(remain == 0 && whole != 0) { //if remainder = zero, do not print 1_0/2 print 1
        		return (whole) + ""; //prints whole num
        		
    		}else if (whole == 0 && sumOrDiff > lcm) {//if whole = zero do not print 0_1/2 print 1/2 
        		return (remain) + "/" + lcm; //prints fraction
        		
    		}else if ((whole != 0) && (remain != 0)) {// will check for mixed fractions
    			return  whole + "_" + remain + "/" + lcm; //prints mixed num LOOK HERE
    			
    		}else if (sumOrDiff < lcm && sumOrDiff != 0) {// need to simplify 
    				tester = gcf(sumOrDiff, lcm);
    				sumOrDiff /= tester;
    				lcm /= tester;

    				return sumOrDiff + "/" + lcm; 
    				
    		}else if (sumOrDiff == 0) {//default will assume it is only two fractions 
    				return sumOrDiff + "";
    				
    			}
    			return (remain) + "/" + lcm;
    		}   		
    	
    	//ADDITION
        public static String addSub (int num1, int num2, int denom1, int denom2, String operator) { //at this step all inputs will be ints
        	//CALCULATION
        	int gcf = gcf(denom1, denom2);
        	int lcm = (denom1/gcf) * denom2; //lcm is now denom of final fractions
        	num1 = num1 * (lcm/denom1); //num1 + num2 = numerator for final fraction
        	num2 = num2 * (lcm/denom2); 
        	int sumOrDiff = 0;
        	
        	if (operator.equals("+")) {
        		sumOrDiff = num1+num2; 	
        	}else if (operator.equals("-")) {
        		sumOrDiff = num1 - num2;
        	}
        	
        	//RETURN IMPROP ANSWER TO MIXED NUM ANSWER
        	int whole = 0; //whole number of the improper fraction created as a result of adding the two fractions
        	int remain = 0;
        	
        	if (Math.abs(sumOrDiff) > lcm) { //if num of final frac is greater than lcm, it will be a improper fraction we need to find whole num and remainder of the fraction
        		whole = (sumOrDiff/lcm); //dividing by ints gives no remainder
        		remain = Math.abs(sumOrDiff % lcm); //mod will find remainder, need the denom (1/2)
        	}else {
        		whole = sumOrDiff / lcm;
        	}        
        	int tester = gcf(remain, lcm);
        	remain /= tester;
    		lcm /= tester;
    		
        	//RETURN ANSWER
        	return opChecks(whole, remain, lcm, sumOrDiff);
     }
        
        //MULTIPLICATION
        public static String mult (int num1, int denom1, int num2, int denom2) {
        	int gcf = gcf(denom1, denom2);
        	int lcm = (denom1/gcf) * denom2;
        	int prodOfNum = num1 * num2;
        	int prodOfDenom = denom1 * denom2;
        	int tester = 0;
        	int whole = prodOfNum / prodOfDenom;
        	int remain = prodOfNum % prodOfDenom;
        	
        	if (prodOfNum < 0 && remain != 0) {//checks for negatives
        		prodOfNum *= -1;
        		prodOfDenom *= -1;
        		tester = gcf(remain, lcm);
        		remain /= tester;
        		lcm /= tester;
        		
        		return prodOfNum / prodOfDenom + "_" + Math.abs(remain) + "/" + lcm;

        	}else if (prodOfNum == 0) {//checks for zero answers
    		return 0 + "";
    		
        	}else if (remain == 0) {
    		return whole + "";
    		
        	}else if (prodOfNum > prodOfDenom) {// will be improper fraction and will need 
        		tester = gcf(remain, prodOfDenom);  // this is least greatest common factor
        		remain /= tester;
        		prodOfDenom /= tester;
        		return whole + "_" + remain + "/" + prodOfDenom;
        		
        	}else   
        		return prodOfNum + "/" + prodOfDenom;
}
        //DIVISION 
        public static String divide (int num1, int denom1, int num2, int denom2) {
        	int num = num1 * denom2;//if given 1/2 and 1/4 will do 1/2 *4/1
        	int denom = denom1 * num2; //these will be the final num and denoms
        	int whole = num / denom;
        	int remain = num % denom;
        	int tester = gcf(remain, denom);
        	
        	remain /= tester;
    		denom /= tester;
        	        	
        	if (num < 0 && whole == 0) {//checks for negative fraction
        		num *= -1;
        		denom *= -1;
        		return num + "/" + denom;   
        		
        	}else if (num < 0 && denom < 0 && Math.abs(denom) != 1) {//checks for negative improp answer
        		return whole + "_" + Math.abs(remain) + "/" + Math.abs(denom);
        		
        	}else if (num < 0 && denom < 0 && Math.abs(denom) == 1) {
        		num *= -1;
        		denom *= -1;
        		return num + "";
        		
        	}else if (denom == 1 || denom == -1) {//checks for 1 in denom
        		return num/denom + "";
        		
        	}else if (num == 0) {//checks for zero answers
        		return 0 + "";
        		
        	}else if (remain == 0) {
        		return whole + "";

        	}else if (Math.abs(num) > denom && whole != 0) {//checks for improper answer
        		return whole + "_" + Math.abs(remain) + "/" + Math.abs(denom);
        		
        	}else if (Math.abs(num) > denom && whole == 0) {//checks for improper answer
        		return remain * -1 + "/" + Math.abs(denom);
        	}
            	return num + "/" + denom;
        	}

        //GCF   
        public static int gcf(int a, int b) {
    		int greatestcommon = 1;
    		int smaller = 0;
    		
    		if (a<=b) {//finds the smaller of a and b (want smaller)
    			smaller = a;
    		}else {
    			smaller = b;
    		}
    		if ( a<1 || b<1 ) {//if a or b is less than 1, execute code for negative gcf
    			
    			//-1 runs to -5, 5 times i = -5, a = -5, b = 10
    			for (int i = -1; i >= smaller; i--) {// i starts at -1, if -1 is greater than a and b then decrement until finds the larger of a and b
    				if (a % i == 0 && b % i == 0) { //if a and b modulo have no remainder, they are even and then return -i
    					greatestcommon = -i;
    				}
    			}
    		}
    		for (int i = 1; i <= smaller; i++) {
    			if (a % i == 0 && b % i == 0) {
    					greatestcommon = i;
    			} 
    		}
    		if (a == b) {
    			greatestcommon = a;
    		}  		
    		return greatestcommon;       
        }

        //LCM (find gcf, x/gcf then multiply to y
        public static int lcm (int denom1, int denom2) {
        	int answer = 0;
        	int gcf = 0;
        	gcf = gcf(denom1, denom2);
        	answer = (denom1/gcf) * denom2;
        	
        	return answer;
        }
}


