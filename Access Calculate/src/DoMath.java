//Michael Huang APCS 3 8/29/19
//Call the code for the calculate class.
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(3));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(2, 3));
		System.out.println(Calculate.average(3, 4, 5));
		System.out.println(Calculate.toDegrees(6.28));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, 2, 3));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(5, 3)); //correct?
		System.out.println(Calculate.foil(2, 3,  6, -7, "n"));
		//end of part 1
		
		System.out.println(Calculate.isDivisibleBy(10,2));
		System.out.println(Calculate.absValue(-0.5));
		System.out.println(Calculate.max(0.2, 7.5));
		System.out.println(Calculate.max(2.0, 3.0, 4.0));
		System.out.println(Calculate.min(5,  10));
		System.out.println(Calculate.round2(-1234.57600));
		//end of part 2
		
		System.out.println(Calculate.exponent(0, 0)); 
		System.out.println(Calculate.factorial(4));
		System.out.println(Calculate.isPrime(20));
		System.out.println(Calculate.gcf(-5, 10)); //wrong
		System.out.println(Calculate.sqrt(0.00));

		//end of part 3
		
		System.out.println(Calculate.quadForm(1, 4, 4));
	}
}


