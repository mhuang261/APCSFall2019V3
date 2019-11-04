//Michael Huang APCS 3rd 8/29/19
//Library of Math Functions, Multiple Methods declared here to be called in DoMath project.
public class Calculate {
//this method squares a number

	public static int square(int number) {
		return number * number;

	} // this method cubes a number

	public static int cube(int numbercubed) {
		return numbercubed * numbercubed * numbercubed;

	}// this method averages two numbers

	public static double average(double numaverage1, double numaverage2) {
		return (numaverage1 + numaverage2) / 2.0;
	}// this methods averages three numbers (overloads)

	public static double average(double numaverage1, double numaverage2, double numaverage3) {
		return (numaverage1 + numaverage2 + numaverage3) / 3;
	}// this method converts a radian value to degrees

	public static double toDegrees(double toDegrees) {
		return toDegrees * (180 / 3.14159);
	}// this method converts a degree value to radians

	public static double toRadians(double toRadians) {
		return toRadians * (3.14159 / 180);

	}// this method calculates the discriminant of three values

	public static double discriminant(double num1, double num2, double num3) {
		return (num2 * num2) - 4.0 * (num1 * num3);

	}// this method calculates an improper fraction

	public static String toImproperFrac(int whole, int numer, int denom) {
		return (denom * whole + numer) + "/" + denom;
	}// this method calculates a mixed fraction

	public static String toMixedNum(int mixed1, int mixed2) {
		return (mixed1 / mixed2 + "_" + mixed1 % mixed2 + "/" + mixed2);
	}// this method calculates a quadratic equation in its standard form

	public static String foil(int a, int b, int c, int d, String n) {
		return (a * c + "n^" + a + " + " + (a * d + b * c + "n ") + "+ " + b * d);
	}// need to add string to method and call

	// end of part 1
	// this method calculates the divisibility of two integers

	public static boolean isDivisibleBy(int numer, int denom) {
		int remainder = numer % denom;
		boolean isDivisible = false;
		
		if (remainder == 0) {
			return (isDivisible = true);
		} else if (remainder !=0) {
			return (isDivisible = false);

		} else throw new IllegalArgumentException("Thats not an accepted character!");

	}// this method calculates the absolute value of a double

	public static double absValue(double deci) {
		if (deci >= 0) {
			return deci;
		} else {
			return deci * -1;
		}
	}// this method calculates the max of two decimals

	public static double max(double num1, double num2) {
		if (num2 >= num1) {

			return num2;

		} else {

			return num1;
		}

	}// this method overloads the previous and calculates the largest of three
		// numbers

	public static double max(double num1, double num2, double num3) {

		if (num3 >= num2 && num3 >= num1) {
			return num3;

		} else if (num2 >= num1 && num2 >= num3) {
			return num2;

		} else {
			return num1;

		}

	}// this method calculates the minimum of two integers

	public static int min(int val1, int val2) {
		if (val1 <= val2) {
			return val1;
		} else {
			return val2;

		} // this method rounds a double to two decimal places
	}

	public static double round2(double answer) {

		answer = answer * 100 - 0.5;
		answer = (int) answer;
		answer = answer / 100;
		return answer;

	}// end of part 2
		// tests for exponent of positive integer

	public static double exponent(double base, int expo) {
		double answer = 0;
		
		if (expo <0 || base <0) {
			throw new IllegalArgumentException();
			
		}
		
		if (expo == 0 && base != 0) {
			return 1;
			
		}
		
		if (expo == 0 && base == 0) {
			return 0;
		}
		 
		for (int i = 0; i < expo; i++) { // if b = 2 and e = 3 then will run 3 times
			answer = answer + 1 * base; //1*2, then 2*2 then 4*2

		}
		return answer;
		

		}// calculate factorial of an integer

	public static int factorial(int fact) {
		int factanswer = 1; // declares variable
		
		if (fact<0) {
			throw new IllegalArgumentException("Not an accepted value!");
			
		}
		
		for (int i = 1; i <= fact; i++) { // i keeps increasing until it hits fact

			factanswer = factanswer * i;// the declared variable is equal to itself times i, which has a limit of 4

		} // the loop continues to run and so
		return factanswer;
		

	}// calculates whether a number is prime (boolean)

	public static boolean isPrime(int input) {

		if (input <= 2 || isDivisibleBy(input, 2)) {

			return input == 2;

		}

		int i = 3;
		if (input % i != 0) {

			i += 2;
		}

		return true;
	}// greatest common factor of two integers

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
		
		for (int i = 1; i >= smaller; i++) {
			if (a % i == 0 && b % i == 0) {
				greatestcommon = i;
			} 
		}
		return greatestcommon;

	}//accounts for square root of a value

	public static double sqrt(double input) {
		
		double guess = 100;
		
if (input<0) {
			
			throw new IllegalArgumentException("No negative square roots.");
			
		} else if (input == 0) {
			return guess = 0;
		}

		
		while (absValue(input-guess*guess) > .005) {
			

			guess = 0.5 * (input/guess + guess);
			
			
		}
		
		return guess;
		
		
		}
	
	public static String quadForm(int a, int b, int c) {
		
		
		if (discriminant(a, b, c) == 0 ) {
			double dis = Math.sqrt(discriminant(a, b, c)); 
			dis = (-b + dis)/(2*a);
			
			double rounding= round2(dis);
			
			return rounding + " ";
			
		}else if (discriminant(a, b, c) > 0 ) {
			double disPre = Math.sqrt(discriminant(a, b, c)); 
			double dis = (-b + disPre)/(2*a);
			double dis2 = (-b - disPre)/(2*a);
			
			double rounding1 = round2(dis);
			double rounding2 = round2(dis2);
			
			return rounding1 + " and " + rounding2;
			
		}else if (discriminant(a, b, c) < 0 ) {
			throw new IllegalArgumentException("No real roots.");
			
		}else throw new IllegalArgumentException("not accepted characters!"); 

		
	}
		
	}
