package landmark;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
	private static int interval;
	private static Timer timer;
	private Player player;
	
	public Clock(Player player, int productionRound) {
		this.player = player;
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
	            System.out.println(setInterval());

	        }
	    }, delay, period);
	}
	
	public int getCurrentTime() {
		return setInterval();
	}

	private static final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    return --interval;
	}
}

