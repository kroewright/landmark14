package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 5
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person5(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 3 positions.
	 * given "gtg123b" it should return
	 * "123bgtg".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private static String calc(String input) {
		int sizey= input.length();
		String outy= input;
		if (sizey>1){
			String wd= (input.substring(3,sizey));
			outy= (wd+input.substring(0,3));		
		}
		return outy;
	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
