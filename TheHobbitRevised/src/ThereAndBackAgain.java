//Michael Huang 2/19/20 
//APCS 3rd Hobbit Activity
//getting a band of travelers to travel a certain amount of miles using inheritance and object manipulation

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThereAndBackAgain {

	public static void main(String[] args) {
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		// Then, use a loop to make all travelers go a distance of 50 miles  
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		//    traveled in miles.  (In the next piece, you'll do this in methods, but 
		//    for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		
		Traveler[] party1 = {frodo, sam, gimli};
			for (int i = 0; i < party1.length; i++) {
				party1[i].travel(50);
				System.out.println(party1[i].getName() + " has traveled " + party1[i].getDistanceTraveled() + " miles.");
			}
		
			System.out.println("\n\n\nPART 2: \n");

			String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin",
			"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};
			
			ArrayList <Traveler> party2 = new ArrayList<>(3);
			
			Hobbit bilbo = new Hobbit("Bilbo");
			party2.add(bilbo);
			//make a new hobbit named bilbo and add him to party2
			Wizard gandalf = new Wizard("Gandalf", "Grey");
			//make a new wizard named gandalf and add him to party2
			party2.add(gandalf);
			
			createParty(party2, dwarfNames);
			allTravel(party2, 100);
	}
			public static void allTravel(ArrayList<Traveler> a, int b) {
				for (int i = 0; i < a.size(); i++) {
					(a.get(i)).travel(b);
					System.out.println(a.get(i).getName() + " traveled " + (a.get(i)).getDistanceTraveled() + " miles.");		
				}
			}
			//write createParty
			public static void createParty(ArrayList<Traveler> a, String[] b) {
				for (int i = 0; i < b.length; i++) {
					Dwarf c = new Dwarf(b[i]); 
					a.add(c);
				}
			}
			
			// Call the createParty method and pass it party2 and the dwarfNames array.

			// create party should add all the new dwarves to party2,

			//Write allTravel
			// Finally, call the allTravel method passing it party2 and 100 (representing
			// the 100 miles that party2 has traveled together.

			//Make sure your code prints out the name and distances party2 has traveled.
	}
