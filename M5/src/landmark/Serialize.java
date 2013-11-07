package landmark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * 
 * The following class is for TEST purposes, what I have changed is added a single line into the energy button 
 * listener in the town, which, although temporarily breaks the button, will be used to SAVE and then LOAD
 * the information held in the current STORE that has been initialized.
 * 
 * 
 *
 *
 *An update:
 *So this code works for saving/loading the store, now trying to implement it for the overworld.

 * 
 * 
 */


public class Serialize {

	public static Store theStore = Overworld.store;
	public Player[] players = Overworld.players;
	
	public static void serialTest(){

		
	

		theStore.save("store1.dat");
		
		theStore.getFromFile("store1.dat");
		System.out.println(theStore.getOreInv());
		System.out.println("It worked!");
	}
	
}
