package landmark;

@SuppressWarnings("serial")
public class BadRaceException extends Exception {

	public BadRaceException (int num) {
		super("This race is already in use. \nPick another race for player " + num);
	}
}
