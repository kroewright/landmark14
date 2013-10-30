package landmark;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Clock {
	
	private static int interval;
	private static Timer timer;
	private static Player[] players;  //static
	private static TownPanel town;
	private static int turn;
	private static Overworld map;
	private static GameDriver driver;
	
	/**
	 * Constructor for the Clock class. The starting time is first
	 * determined by getting the food levels for the player. The clock
	 * then deducts 1 second from that starting time with a 1000 millisecond
	 * delay.
	 * 
	 * @param players
	 * @param productionRound
	 * @param turn
	 * @param town
	 * @param map
	 */
	public Clock(Player[] players, int productionRound, int turn, final TownPanel town, final Overworld map) {
		this.players = players;
		this.turn = turn;
		this.town = town;
		this.map = map;
		int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    int food = players[turn].getFood();
	    players[turn].setTimer(this);
	    
	    if(productionRound <= 4) {
	    	if(food >= 3) {
	    		interval = 50;
	    	}
	    	else if(food > 0) {
	    		interval = 30;
	    	}
	    	else {
	    		interval = 5;
	    	}
	    }
	    else if(productionRound <= 8) {
	    	if(food >= 4) {
	    		interval = 50;
	    	}
	    	else if(food > 0) {
	    		interval = 30;
	    	}
	    	else {
	    		interval = 5;
	    	}
	    }
	    else if(productionRound <= 12) {
	    	if(food >= 5) {
	    		interval = 50;
	    	}
	    	else if(food > 0) {
	    		interval = 30;
	    	}
	    	else {
	    		interval = 5;
	    	}
	    }
	    
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	        	int momentInTime = setInterval();
	        	if(momentInTime >= 0) {
	        		JLabel time = town.getTimeLabel();
		            time.setText(String.valueOf(momentInTime));
		            JLabel mapTime = map.getTimeLabel();
		            mapTime.setText(String.valueOf(momentInTime));
	        	}
	        }
	    }, delay, period);
	}
	
	/**
	 * Gets the current time from the clock by calling the helper method.
	 * 
	 * @return interval
	 */
	public int getCurrentTime() {
		return setInterval();
	}

	/**
	 * This helper method returns the right time for the clock.
	 * If the time hits 0, a dialog box appears telling the turn
	 * is over. The next player turn occurs.
	 * 
	 * @return interval
	 */
	private static final int setInterval() {
	    if (interval == 0) {
	    	timer.cancel();
	    	
	    	if(turn == (players.length - 1)) {
	    		turn = 0;
	    		players = map.orderPlayersByScore(players);
	    	}
	    	else {
	    		turn += 1;
	    	}
	    	
	    	
	    	JOptionPane.showMessageDialog(town, "Time's up! " + players[turn].getName() + " begin production phase!"
	    			, "Production Phase", JOptionPane.INFORMATION_MESSAGE);
	    	
	    	ProductionPhaseTurn productionTurn = new ProductionPhaseTurn(players, map);
	    	map.setProduction(productionTurn);
	    	if(driver.getPanel() == map) {
	    		driver.changeToMapPanel(map);
	    	}
	    }
	    return --interval;
	}
	
	/**
	 * Retrieves the starting time for the clock.
	 * 
	 * @return interval
	 */
	public int getStartingInterval() {
		return interval;
	}
	
	/**
	 * Sets the GameDriver for the clock so the graphics
	 * can be updated.
	 * 
	 * @param game
	 */
	public void setPanel(GameDriver game) {
		driver = game;
	}

	/**
	 * Gets the GameDriver JPanel.
	 * 
	 * @return driver
	 */
	public GameDriver getPanel() {
		return driver;
	}
	
	/**
	 * Stops the running clock.
	 */
	public void stopTimer() {
		timer.cancel();
	}
}

