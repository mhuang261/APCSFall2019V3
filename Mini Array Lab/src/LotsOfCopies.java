import java.util.Arrays;

public class LotsOfCopies {
	
public static void main(String[] args)
{
	int num = 7;
	String strMain = "APCS";
	int[] arrMain = {1, 2, 3, 4, 5};
	changeMe(num, strMain, arrMain);
	System.out.println("Number: " + num);
	System.out.println("String: " + strMain);
	System.out.println("Array: " + Arrays.toString(arrMain));//converts array to string
}

	public static void changeMe(int x, String str, int[] arr) {// creates different array of integers
		x = 8;
		str += "Hello";
		arr[3]++;//checks main method and prints, not a copy
	}//primitives pare passed by value, copies are made and passed, copies do not effect original
	//objects are passed by reference, instructions to where to go look, when changed in method, will be changed outside the method
}