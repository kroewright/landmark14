/**
 * 
 */
package landmark;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author k_wright0510
 *
 */
public class KourtneySelpage_createPlayersTest {

	
	private Player[] players;
	private int lengthOfArray;
	private Selpage page;
	//private Selpage setter;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		page = new Selpage();
		page.setSelpage(4);
	}
	
	/**
	 * Method that tests for an array of length 0.
	 */
	@Test
	public void test1CreatePlayer() {
		int numOfPlayers = 0;
		players = page.createPlayers(numOfPlayers);
		assertEquals("Should be equal", players.length, numOfPlayers);
	}
	
	/**
	 * Method that tests Player fields for one player.
	 */
	@Test
	public void testCreatePlayerField() {
		int numOfPlayers = 1;
		players = new Player[numOfPlayers];
		players[0] = new Player("Kourt", 0,0,0);
		assertEquals("Should be equal", players.length, numOfPlayers);
		assertEquals("Should be equal", players[0].getColor(), 0);
		assertEquals("Should be equal", players[0].getName(), "Kourt");
		assertEquals("Should be equal", players[0].getDifficulty(), 0);	
	}
	
	/**
	 * 
	 * Method that tests Player fields for two players.
	 */
	@Test
	public void testCreatePlayerField2() {
		int numOfPlayers = 2;
		players = new Player[numOfPlayers];
		players[0] = new Player("Kourt", 0,0,0);
		players[1] = new Player("Ross", 1,0,1 ); 
		assertEquals("Should be equal", players.length, numOfPlayers);
		assertEquals("Should be equal", players[0].getColor(), 0);
		assertEquals("Should be equal", players[0].getName(), "Kourt");
		assertEquals("Should be equal", players[0].getDifficulty(), 0);
		assertEquals("Should be equal", players[1].getColor(), 1);
		assertEquals("Should be equal", players[1].getName(), "Ross");
		assertEquals("Should be equal", players[1].getDifficulty(), 0);
	}
	
	/**
	 * 
	 * Method that tests Player fields for three players.
	 */
	@Test
	public void testCreatePlayerField3() {
		int numOfPlayers = 3;
		players = new Player[numOfPlayers];
		players[0] = new Player("Kourt", 0,0,0);
		players[1] = new Player("Ross", 1,0,1 ); 
		players[2] = new Player("Irina", 2,0,2);
		assertEquals("Should be equal", players.length, numOfPlayers);
		assertEquals("Should be equal", players[0].getColor(), 0);
		assertEquals("Should be equal", players[0].getName(), "Kourt");
		assertEquals("Should be equal", players[0].getDifficulty(), 0);
		assertEquals("Should be equal", players[1].getColor(), 1);
		assertEquals("Should be equal", players[1].getName(), "Ross");
		assertEquals("Should be equal", players[1].getDifficulty(), 0);
		assertEquals("Should be equal", players[2].getColor(), 2);
		assertEquals("Should be equal", players[2].getName(), "Irina");
		assertEquals("Should be equal", players[2].getDifficulty(), 0);
	}
	
	/**
	 * 
	 * Method that tests Player fields for four players.
	 */
	@Test
	public void testCreatePlayerField4() {
		int numOfPlayers = 4;
		players = new Player[numOfPlayers];
		players[0] = new Player("Kourt", 0,0,0);
		players[1] = new Player("Ross", 1,0,1 ); 
		players[2] = new Player("Irina", 2,0,2);
		players[3] = new Player("Mason", 3,0,3);
		assertEquals("Should be equal", players.length, numOfPlayers);
		assertEquals("Should be equal", players[0].getColor(), 0);
		assertEquals("Should be equal", players[0].getName(), "Kourt");
		assertEquals("Should be equal", players[0].getDifficulty(), 0);
		assertEquals("Should be equal", players[1].getColor(), 1);
		assertEquals("Should be equal", players[1].getName(), "Ross");
		assertEquals("Should be equal", players[1].getDifficulty(), 0);
		assertEquals("Should be equal", players[2].getColor(), 2);
		assertEquals("Should be equal", players[2].getName(), "Irina");
		assertEquals("Should be equal", players[2].getDifficulty(), 0);
		assertEquals("Should be equal", players[3].getColor(), 3);
		assertEquals("Should be equal", players[3].getName(), "Mason");
		assertEquals("Should be equal", players[3].getDifficulty(), 0);
	}
	
	/**
	 * Method to test the length of the array against the number of players in it.
	 */
	@Test
	public void testCreatePlayerFieldIndex() {
		int numOfPlayers = 5;
		players = new Player[numOfPlayers];
		players[0] = new Player("Kourt", 0,0,0);
		players[1] = new Player("Ross", 1,0,1 ); 
		players[2] = new Player("Irina", 2,0,2);
		players[3] = new Player("Mason", 3,0,3);
		assertFalse("The size of the array doens't match the number of players", false);
	}

}

	
	


