import java.util.*;

public class HourGlass {
	
	static Scanner console = new Scanner(System.in);
	static int size = 10; //size and scanner set to static so it can be accessed through the static topHalf and main methods

	//topBot method here
	
	public static void topBot() {
		System.out.print("|");
		
		for (int i = 0; i<size; i++) {
			System.out.print("\"");
			
		}
			System.out.println("|");//at the end of the 10th loop, will close with |	
	}

//top half begins method
	public static void topHalf(String[] args) {		
		for (int row = 1; row <= 4; row++) {//from rows 1-4 we will print out increasing amounts of spaces 	
				for (int spaces = 1; spaces<= row; spaces++ ) {
					printSpace();
				}
				System.out.print("\\");

				//if colon is less than the num of the colons (which is equal to the row number times -2 + 10)
				//numOfColons has min val of -2*(1)+10 or 8, then 6, then 4, etc
					int numOfColons = -2*row+10;
					for (int colon = 1; colon <= numOfColons; colon++) {
						printColon();
						 } 
					System.out.println("/");
		}
	}
	
	//lower half method 
	
	public static void bottomHalf (String[]args) {
	
	for (int row = 1; row <=4; row++) { //will run 4 times
		for (int spaces = row; spaces<= 4; spaces++) { //spaces = 1, 2, 3, 4; if spaces <= rows, it will increase # of spaces and then 
			printSpace(); //will run 4 times, subtracting a space every time

		} 		System.out.print("/");//will add a / after each space entry
			
		
		int numOfColons = 2*row;//will print 2*row worth of colons. so 2, 4, 6, 8
		for (int colon = 1; colon <= numOfColons; colon++) { //will print the character ":" until it catches up with numOfColons, so 2, 4, 6, 8 times,
			printColon();
			 } 	
		System.out.println("\\");//adds ending "\"
		}
	}
	
	// MAIN METHOD BEGINS HERE
		
		public static void main(String[] args) {
		    topBot();

			topHalf(args); //calls method topHalf with args and prints entire top half 
			
		 System.out.println("     ||"); //prints out middle lines
		
		//lower half
		 
		 	bottomHalf(args);
		
		// end lines printed
		    topBot();

			}
		
		public static void printSpace() {
			System.out.print(" ");
		}
		
		public static void printColon() {
			System.out.print(":");
		}
		
	
		}
