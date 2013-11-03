package landmark;

import java.util.Random;

public class RandomEvents {
	
	private Player player;
	private int multiplier;

	/**
	 * Constructor for RandomEvents. It takes a player and round number
	 * in order to see if the player will get a random event before his or her turn.
	 * 
	 * @param player
	 * @param gameRound
	 */
	public RandomEvents(Player player, int gameRound) {
		this.player = player;
		
		if(gameRound <= 3) {
			multiplier = 25;
		}
		else if(gameRound <= 7) {
			multiplier = 50;
		}
		else if(gameRound <= 11) {
			multiplier = 75;
		}
		else {
			multiplier = 100;
		}
	}
	
	/**
	 * Calculates the chance that a random event will happen
	 * to the certain player.
	 * 
	 * @return int
	 */
	public int calculateChance() {
		Random randomGenerator = new Random();
		int chance = randomGenerator.nextInt(101);
		return chance;
	}
	
	/**
	 * Gets one of the seven events that can happen based on a random generated
	 * number. This string will be put into a dialog box.
	 * 
	 * @return String
	 */
	public String getRandomEvent() {
		Random randomGenerator = new Random();
		int eventType = randomGenerator.nextInt(7) + 1;
		int currentFood = player.getFood();
		int currentOre = player.getOre();
		int currentEnergy = player.getEnergy();
		int currentMoney = player.getMoney();
		int amount;
		String event = "This will change.";
		
		switch(eventType) {
			case 1: 
				event = "You just received a package from the GT alumni containing 3 food and 2 energy units.";
				player.setFood(currentFood + 3);
				player.setEnergy(currentEnergy + 2);
				break;
			case 2:
				event = "A wandering Tech student repaid your hospitality by leaving two bars of ore.";
				player.setOre(currentOre + 2);
				break;
			case 3:
				amount = 8*multiplier;
				event = "The museum bought your antique personal computer for $" + amount + ".";
				player.setMoney(currentMoney + amount);
				break;
			case 4:
				amount = 2*multiplier;
				event = "You found a dead moose rat and sold the hide for $" + amount + ".";
				player.setMoney(currentMoney + amount);
				break;
			case 5:
				amount = 4*multiplier;
				event = "Flying cat-bugs ate the roof off your house. Repairs cost $" + amount + ".";
				int newMoneyLevel = currentMoney - amount;
				
				if(newMoneyLevel < 0) {
					newMoneyLevel = 0;
				}
				
				player.setMoney(newMoneyLevel);
				break;
			case 6:
				event = "Mischievous UGA students broke into your storage shed and stole half your food.";
				int newFoodLevel = (int)(currentFood * 0.5);
				player.setFood(newFoodLevel);
				break;
			case 7:
				amount = 6*multiplier;
				event = "Your space gypsy inlaws made a mess of the town. It cost you $" + amount + " to clean it up.";
				int moneyLevel = currentMoney - amount;
				
				if(moneyLevel < 0) {
					newMoneyLevel = 0;
				}
				
				player.setMoney(moneyLevel);
				break;
		}
		
		return event;
	}
}
