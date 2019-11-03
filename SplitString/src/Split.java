//Michael Huang 10/28/19 
//This is code that manipulates arrays by splitting them and excluding certain indexes
import java.util.*;
public class Split {
	
	//practice
	public static void sandwich(String vege) {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Name of string you want to be removed?");
		 String take = input.nextLine();
		 String[] answer = new String[(vege.split(take)).length];
		 answer = (vege.split(take));
		 
		 System.out.println(Arrays.toString(answer));
		 }  
	
	public static void practice1(String apples) {
	String[] answer = new String[apples.length()];
	answer = apples.split(" ");
	System.out.println(Arrays.toString(answer));
	}
	
	public static void practice2(String apples2) {
		String[] answer = new String[apples2.length()];
		answer = apples2.split("really");		
		System.out.println(Arrays.toString(answer));
	}
	
	//part 1

 	public static String sandwich2(String info) {
 		String[] first = info.split("bread"); //assigns given string into a an array 
 		String mid = first[1];//first value of the array is assigned to a string and returned 
 		return mid;//index 0 = pineapple, index 1 = what we want, index 2 = cheese
 	}
 	
 	public static String sandwich3(String sandwich) {
		 String mid = "";
 		 String[] ingred = sandwich.split("bread");//splits at bread
 		 ingred[0] = "";
 		 ingred[ingred.length - 1] = "";//first and last to spaces so they wont appear in string
 		 for (String i : ingred) { //goes through array and += index string values to a string
 			 mid+=i;
 		 }
 		 return mid;
 	 }
 	//extra cred testing for more than two breads
 	public static String sandwichThreeExtra(String sandwich) {
 		String a = "";
 		String[] first = sandwich.split("bread"); // " ", tomato, ham, fingers
 		first[0] = "";
 		first[first.length -1] = "";
 		 for (String i : first) { //goes through array and += index string values to a string
 			 a+=i;
 		 }
 		 return a;
 	} 
 	
 public static void main(String[] args) {
	 //part0
	 practice1("I like apples!");
	 practice2("I really like really red apples!");
	 practice2("I reallyreally likeapples");
	 //part1
	 sandwich("i like to eat each banana."); //this one is for practice
	 System.out.println(sandwich2("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
	 System.out.println(sandwich3("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));
	 System.out.println(sandwichThreeExtra("bread tomato bread ham bread fingers"));
 }
 
}
	 

// Your task Part 0

//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array

// Example: "I like apples!".split(" ");

// it will split at spaces and return an array of ["I","like","apples!"]

// Example 2: "I really like really red apples!".split("really")

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

//play around with String.split!

//What happens if you "I reallyreally likeapples".split("really") ?

//Your task Part 1:

/*Write a method that take in a string like
* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"
* describing a sandwich.
* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of
* the sandwich and ignores what's on the outside
* What if it's a fancy sandwich with multiple pieces of bread?
*/

//Your task pt 2:

/*Write a method that take in a string like
* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
* describing a sandwich
* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of
* the sandwich and ignores what's on the outside.
* Again, what if it's a fancy sandwich with multiple pieces of bread?
*/