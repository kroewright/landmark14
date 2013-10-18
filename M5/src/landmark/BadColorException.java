package landmark;

@SuppressWarnings("serial")
public class BadColorException extends Exception {

	public BadColorException (int num) {
		super("This color is already in use. \nPick another color for player " + num);
	}
}
