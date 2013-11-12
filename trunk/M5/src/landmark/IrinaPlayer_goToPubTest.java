/**
 * 
 */
package landmark;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author irinababkina
 *
 */
public class IrinaPlayer_goToPubTest {

	Player player1;
	Player player2;
	Clock timer;
	TownPanel town;
	Overworld map;
	GameDriver driver; 
	int seed;
	Random randomGenerator;

	int random;
	int roundBonus;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		player1 = new Player("Irina", 1, 1, 0); //Irina has $600
		player2 = new Player("Amy", 4, 1, 0); //Amy has $600
		Player[] players = {player1, player2};
		map = new Overworld(1); //standard map
		driver = new GameDriver();
		town = new TownPanel(players, 1, 1, map, driver); 
		timer = new Clock(players, 1, 1, town, map, driver);
		player1.setTimer(timer);
		seed = 1;
		randomGenerator = new Random(seed);

	}

	@Test
	public void testRoundBonus_Round_0() {
		roundBonus = player1.goToPub(20, 0, seed);
		assertEquals("Round number cannot be less than 1.", roundBonus, 0);
	}

	@Test
	public void testRoundBonus_Round_13() {
		roundBonus = player1.goToPub(20, 13, seed);
		assertEquals("Round number cannot be more than 13.", roundBonus, 0);
	}

	@Test
	public void testRoundBonus_Round_1_TimeLeft_37() {
		int rB_expected = calculateBonus(37, 1, 50, 150);
		roundBonus = player1.goToPub(37, 1, seed);
		assertEquals("Expected they are equal.", roundBonus, rB_expected);
	}

	public int calculateBonus(int timeLeft, int round, int roundBonus1, int timeBonus) {
		Random randomGenerator1 = new Random(seed);
		int somerand = Math.abs((randomGenerator1.nextInt() % (timeBonus+1)));
		System.out.println("random from test = " + somerand);
		int moneyBonus = roundBonus1 + somerand;  
		int maxBonus = 250;

		if(moneyBonus > maxBonus)
			moneyBonus = maxBonus;
		return moneyBonus;
	}
}
