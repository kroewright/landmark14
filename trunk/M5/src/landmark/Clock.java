package landmark;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Clock {
	
	private static int interval;
	private static Timer timer;
	private static Player[] players;
	private static TownPanel town;
	private static int turn;
	private static Overworld map;
	private static GameDriver driver;
	
	public Clock(Player[] players, int productionRound, int turn, final TownPanel town, Overworld map) {
		this.players = players;
		this.turn = turn;
		this.town = town;
		this.map = map;
		int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    int food = players[turn].getFood();
	    
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
	            JLabel time = town.getTimeLabel();
	            time.setText(String.valueOf(setInterval()));
	        }
	    }, delay, period);
	}
	
	public int getCurrentTime() {
		return setInterval();
	}

	private static final int setInterval() {
	    if (interval == 1) {
	    	timer.cancel();
	    	
	    	if(turn == (players.length - 1)) {
	    		turn = 0;
	    		
	    	}
	    	else {
	    		turn += 1;
	    	}
	    	
	    	
	    	JOptionPane.showMessageDialog(town, (players[turn].getName() + " begin production phase!"), "Production Phase"
					, JOptionPane.INFORMATION_MESSAGE);
	    	
	    	ProductionPhaseTurn productionTurn = new ProductionPhaseTurn(players, map);
	    	map.setProduction(productionTurn);
	    	driver.changeToMapPanel(map);
	    }
	    return --interval;
	}
	
	public int getStartingInterval() {
		return interval;
	}
	
	public void setPanel(GameDriver game) {
		driver = game;
	}
	
	public void stopTimer() {
		timer.cancel();
	}
}

