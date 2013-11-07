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
 * The following problem exists: That the file cannot be found when the SAVE function is activated, 
 * a null pointer exception is found. I've done my best to adapt our code to Bob's example, by implementing
 * serializable in the store class and adding the save and load method there, but it appears that there is some sort of mis-communication.
 * 
 * 
 * 
 */


public class Serialize {

	public static Store theStore = PresenterStoreTownPanel.store;
	public Player[] players = Overworld.players;
	
	public static void serialTest(){

		
		
		try {
			FileOutputStream out = new FileOutputStream("store.dat");
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		theStore.save("store.dat");
		
		theStore.getFromFile("store.dat");
		System.out.println(theStore.getOreInv());
		System.out.println("It worked!");
	}
	
}
