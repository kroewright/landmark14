package landmark;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock {
	
	private static int interval;
	private static Timer timer;
	private static boolean stopped = false;
	
	public Clock(Player player, int productionRound, final TownPanel town) {
		int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    int food = player.getFood();
	    
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
	
	public boolean getStopped() {
		return stopped;
	}

	private static final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    	stopped = true;
	    return --interval;
	}
}

