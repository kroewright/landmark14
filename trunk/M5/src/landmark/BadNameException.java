package landmark;

@SuppressWarnings("serial")
public class BadNameException extends Exception {

	public BadNameException (int num) {
		super("Enter name for player " + num + ".");
	}
}
