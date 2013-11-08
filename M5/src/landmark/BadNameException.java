package landmark;

/**
 * 
 * @author landmark - team 14
 * Makes sure that a player enters a name in the text field.
 *
 */

@SuppressWarnings("serial")
public class BadNameException extends Exception {

	public BadNameException (int num) {
		super("Enter name for player " + num + ".");
	}
}
