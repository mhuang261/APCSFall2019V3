import java.util.*;
public class ProcessingNumbers {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int max = 0;
		int min = 0;
		int evenSum = 0;
		int numAmount = 0;
		int evenMax = 0;
		
		System.out.println("How many numbers do you want?");
		numAmount = console.nextInt();

		for (int i = 1; i <= numAmount; i++ ) {
			System.out.println("Give me the number.");
			int num = console.nextInt();
			//code for getting first num
			if (i == 1) {//calling first variable in order to set min and max to it, they need to have a value for max and min code to work
				min = num;//formatted with min and max first because we are calling min and max in the final string, not the num
				max = num;
			}
			//code for getting max and min
			if (num > max) {
				max = num;
			} else if (num < min) {
				min = num;
			}
			//code for getting sum
			if (num % 2 == 0) {
				evenSum += num;//adds previous num to the evenSum variable after confirming if its even
				
				//code for largest even num
				if (num > evenMax) {//evenMax at this point is 0 and num is constantly increasing due to loop, so evenMax will be changed until the varaible will equal 
					evenMax = num;
					
				}
			}			
			
		}
			
			System.out.println("Even sum:" + evenSum + "\n" + "Largest even number:" + evenMax + "\n" + "Smallest number:" + min + "\n" + "Largest number:"+ max);
			console.close();
	}
		
}