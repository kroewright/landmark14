package landmark;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RossOverworldTest {
	
	private Player ross;
	private Player mason;
	private Player kourtney;
	private Player irina;
	private Player[] players;
	private Player[] correctOrder;
	private Overworld map;
	
	@BeforeClass
	public static void testSetup() {
		System.out.println("Before class.");
	}
	
	@Before
	public void initialize() {
		ross = new Player("Ross", 1, 1, 3); // Ross has a score of 1600
		mason = new Player("Mason", 2, 1, 0); // Mason has a score of 600
		kourtney = new Player("Kourtney", 3, 1, 2); // Kourtney has a score of 1000
		irina = new Player("Irina", 4, 1, 2); // Irina has a score of 1000
		players = new Player[4];
		map = new Overworld(1);
		correctOrder = new Player[4];
	}

	@AfterClass
	public static void testCleanup() {
		System.out.println("After class.");
	}
	
	@Test
	public void testOrderPlayersByScore() {
		
		// Test Case 1: Ordering 4 players
		players[0] = ross;
		players[1] = mason;
		players[2] = kourtney;
		players[3] = irina;
		
		correctOrder[0] = mason;
		correctOrder[1] = kourtney;
		correctOrder[2] = irina;
		correctOrder[3] = ross;
		assertArrayEquals("The 4 players must be ordered by increasing score.", correctOrder, map.orderPlayersByScore(players));
		System.out.println("Test case 1 completed.");
		
		// Test Case 2: Ordering 4 players with the same score
		// The order should be the same as the initial player array so the order should not change
		players[0] = ross;
		players[1] = mason;
		players[2] = kourtney;
		players[3] = irina;
		mason.setMoney(1600);
		kourtney.setMoney(1600);
		irina.setMoney(1600);
		
		correctOrder = players;
		assertArrayEquals("Player order must not change when they all have the same score.", correctOrder, 
				map.orderPlayersByScore(players));
		System.out.println("Test case 2 completed.");
		
		// Test Case 3: Ordering 3 players
		players = new Player[3];
		players[0] = ross;
		players[1] = mason;
		players[2] = kourtney;
		mason.setMoney(1200);
		kourtney.setMoney(1199);
		
		correctOrder = new Player[3];
		correctOrder[0] = kourtney;
		correctOrder[1] = mason;
		correctOrder[2] = ross;
		assertArrayEquals("The 3 players must be ordered by increasing score.", correctOrder, 
				map.orderPlayersByScore(players));
		System.out.println("Test case 3 completed.");
		
		// Test case 4: Ordering 2 players 
		players = new Player[2];
		players[0] = ross;
		players[1] = mason;
		mason.setMoney(2400);
		
		correctOrder = new Player[2];
		correctOrder[0] = ross;
		correctOrder[1] = mason;
		assertArrayEquals("The 2 players must be ordered by increasing score.", correctOrder, 
				map.orderPlayersByScore(players));
		System.out.println("Test case 4 completed.");
	}
}
