package landmark;

public class ProductionPhaseTurn {
	
	private static int productionRound = 0;
	private int turn = 0; //player1 = 0, player2 = 1, player3 = 2, player3 = 2, player4 = 3
	
	public ProductionPhaseTurn(Player[] players, TownPanel town) {
		productionRound += 1;
		
		Clock timer = new Clock(players[turn], productionRound, town);
		
		//This class needs to be filled in guys. This should be responsible for cycling through the player array for 
		//for the production phase. Once the clock goes out, the next player goes. If the player pushes the pub button,
		//their turn is ended and the next player goes.
		
	}

}
