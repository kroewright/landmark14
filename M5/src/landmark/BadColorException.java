package landmark;

/**
 * 
 * @author landmark - team 14
 * 
 * Makes sure each player chooses a different color for the game.
 *
 */

@SuppressWarnings("serial")
public class BadColorException extends Exception {

	public BadColorException (int num) {
		super("This color is already in use. \nPick another color for player " + num + ".");
	}
}
