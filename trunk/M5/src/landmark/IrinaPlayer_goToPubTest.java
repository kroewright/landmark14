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
 * @author IrinaBabkina
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
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		player1 = new Player("Irina", 1, 1, 0); 
		player2 = new Player("Amy", 4, 1, 0); 
		Player[] players = {player1, player2};
		map = new Overworld(1); //standard map
		driver = new GameDriver();
		town = new TownPanel(players, 1, 1, map, driver); 
		timer = new Clock(players, 1, 1, town, map, driver);
		player1.setTimer(timer);
		seed = 1;
		randomGenerator = new Random(seed);
	}


	//To test that the correct timeBonus applied for different time frames.
	//For the time frames we have partitions: 1, 12, 25, 37, 50.
	//Tests will check the partitions themselves and will go both (false/right) 
	//directions to check out of bounds
	//All TimeBonustimeLeft tests are performed for round 1 with roundBonus = 50  

	/**
	 * testTimeLeft_1 method checks time frame 1-12 sec, partition 1 sec,
	 * on boundary.
	 * For this time frame, timeBonus must be 50.
	 */
	@Test
	public void testTimeBonusTimeLeft_1() {
		int testGambl = calculateBonus(1, 1, 50, 50); //round=1, timeLeft=1, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(1, 1, seed); //timeLeft=1, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_0 method checks out of bound of time frame 1-12 sec, partition 1 sec.
	 * Goes false direction.
	 * For this time frame, timeBonus must be 0 since time frame changed to < 1 sec.
	 */
	@Test
	public void testTimeBonusTimeLeft_0() {
		int gambl = player1.goToPub(0, 1, seed); //timeLeft=0, round=1
		assertEquals("If you don't have timeLeft you can't get a bonus.", gambl, 0);
	}

	/**
	 * testTimeLeft_2 method checks time frame 1-12 sec, partition 1 sec.
	 * Goes right direction. 
	 * For this time frame, timeBonus must be 50. 
	 */
	@Test
	public void testTimeBonusTimeLeft_2() {
		int testGambl = calculateBonus(1, 2, 50, 50); //round=1, timeLeft=2, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(2, 1, seed); //timeLeft=2, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_12 method checks time frame 1-12 sec, partition 12 sec,
	 * on boundary.
	 * For this time frame, timeBonus must be 50. 
	 */
	@Test
	public void testTimeBonusTimeLeft_12() {
		int testGambl = calculateBonus(1, 12, 50, 50); //round=1, timeLeft=12, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(12, 1, seed); //timeLeft=12, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_11 method checks time frame 1-12 sec, partition 12 sec.
	 * Goes right direction.
	 * For this time frame, timeBonus must be 50. 
	 */
	@Test
	public void testTimeBonusTimeLeft_11() {
		int testGambl = calculateBonus(1, 11, 50, 50); //round=1, timeLeft=11, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(11, 1, seed); //timeLeft=11, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_13 method checks time frame 1-12 sec, partition 12 sec.
	 * Goes false direction.
	 * Also it checks time frame 13-25 sec, partition 13 sec, on boundary.
	 * For this time frame, timeBonus must be 100 since time frame changed to 13-25 sec. 
	 */
	@Test
	public void testTimeBonusTimeLeft_13() {
		int testGambl = calculateBonus(1, 13, 50, 100); //round=1, timeLeft=13, roundBonus=50, timeBonus=100
		int gambl = player1.goToPub(13, 1, seed); //timeLeft=13, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_25 method checks time frame 13-25 sec, partition 25 sec,
	 * on boundary
	 * For this time frame, timeBonus must be 100. 
	 */
	@Test
	public void testTimeBonusTimeLeft_25() {
		int testGambl = calculateBonus(1, 25, 50, 100); //round=1, timeLeft=25, roundBonus=50, timeBonus=100
		int gambl = player1.goToPub(25, 1, seed); //timeLeft=25, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_24 method checks time frame 13-25 sec, partition 25 sec.
	 * Goes right direction.
	 * For this time frame, timeBonus must be 100. 
	 */
	@Test
	public void testTimeBonusTimeLeft_24() {
		int testGambl = calculateBonus(1, 24, 50, 100); //round=1, timeLeft=24, roundBonus=50, timeBonus=100
		int gambl = player1.goToPub(24, 1, seed); //timeLeft=24, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_26 method checks time frame 13-25 sec, partition 25 sec.
	 * Goes false direction.
	 * Also it checks time frame 26-37 sec, partition 26 sec, on boundary.
	 * For this time frame, timeBonus must be 150 since time frame changed to 26-37 sec. 
	 */
	@Test
	public void testTimeBonusTimeLeft_26() {
		int testGambl = calculateBonus(1, 26, 50, 150); //round=1, timeLeft=26, roundBonus=50, timeBonus=150
		int gambl = player1.goToPub(26, 1, seed); //timeLeft=26, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_37 method checks time frame 26-37 sec, partition 37 sec,
	 * on boundary.
	 * For this time frame, timeBonus must be 150. 
	 */
	@Test
	public void testTimeBonusTimeLeft_37() {
		int testGambl = calculateBonus(1, 37, 50, 150); //round=1, timeLeft=37, roundBonus=50, timeBonus=150
		int gambl = player1.goToPub(37, 1, seed); //timeLeft=37, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_36 method checks time frame 26-37 sec, partition 37 sec.
	 * Goes right direction.
	 * For this time frame, timeBonus must be 150. 
	 */
	@Test
	public void testtimeBonusTimeLeft_36() {
		int testGambl = calculateBonus(1, 36, 50, 150); //round=1, timeLeft=36, roundBonus=50, timeBonus=150
		int gambl = player1.goToPub(36, 1, seed); //timeLeft=36, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_38 method checks time frame 26-37 sec, partition 37 sec.
	 * Goes false direction.
	 * Also it checks time frame 38-50 sec, partition 38 sec, on boundary
	 * For this time frame, timeBonus must be 200 since time frame changed to 38-50 sec. 
	 */
	@Test
	public void testTimeBonusTimeLeft_38() {
		int testGambl = calculateBonus(1, 38, 50, 200); //round=1, timeLeft=38, roundBonus=50, timeBonus=200
		int gambl = player1.goToPub(38, 1, seed); //timeLeft=38, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_50 method checks time frame 38-50 sec, partition 50 sec,
	 * on boundary.
	 * For this time frame, timeBonus must be 200. 
	 */
	@Test
	public void testTimeBonusTimeLeft_50() {
		int testGambl = calculateBonus(1, 50, 50, 200); //round=1, timeLeft=50, roundBonus=50, timeBonus=200
		int gambl = player1.goToPub(50, 1, seed); //timeLeft=50, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_49 method checks time frame 38-50 sec, partition 50 sec.
	 * Goes right direction.
	 * For this time frame, timeBonus must be 200. 
	 */
	@Test
	public void testTimeBonusTimeLeft_49() {
		int testGambl = calculateBonus(1, 49, 50, 200); //round=1, timeLeft=49, roundBonus=50, timeBonus=200
		int gambl = player1.goToPub(49, 1, seed); //timeLeft=49, round=1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testTimeLeft_51 method checks time frame 38-50 sec, partition 50 sec.
	 * Goes false direction.
	 * For this time frame, timeBonus must be 0 since time frame changed to > 50 sec. 
	 */
	@Test
	public void testTimeBonusTimeLeft_51() {
		int gambl = player1.goToPub(51, 1, seed); //timeLeft=51, round=1
		assertEquals("Expected they are equal.", gambl, 0);
	}


	//To test that the correct roundBonus applied for different rounds.
	//For the round frames we have partitions: 1, 3, 7, 11, 12.
	//Tests will check the partitions themselves and will go both (false/right) 
	//directions to check out of bounds
	//All RoundBonusRound tests are performed for timeLeft 1 with timeBonus = 50  

	/**
	 * testRoundBonusRound_1 method checks round frame 1-3, partition round 1,
	 * on boundary. 
	 * For this round frame, roundBonus must be 50.
	 */
	@Test
	public void testRoundBonusRound_1() {
		int testGambl = calculateBonus(1, 1, 50, 50); //round=1, timeLeft=1, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(1, 1, seed); //timeLeft=1, round 1
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_0 method checks out of bounds of round frame 1-3, partition round 1.
	 * Goes false direction.
	 * For this time frame, roundBonus must be 0 since round < 1.
	 */
	@Test
	public void testRoundBonusRound_0() {
		int gambl = player1.goToPub(1, 0, seed); //timeLeft=1, round=0
		assertEquals("Not a valid round.", gambl, 0);
	}

	/**
	 * testRoundBonusRound_2 method checks round frame 1-3, partition round 1 
	 * and partition round 3.
	 * Goes right direction for both partitions. 
	 * For this round frame, roundBonus must be 50. 
	 */
	@Test
	public void testRoundBonusRound_2() {
		int testGambl = calculateBonus(2, 1, 50, 50); //round=2, timeLeft=1, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(1, 2, seed); //timeLeft=1, round=2
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_3 method checks round frame 1-3, partition round 3, on boundary.
	 * Also it checks partition round 4 for round frame 4-7 going false direction.
	 * For this time frame, roundBonus must be 50. 
	 */
	@Test
	public void testRoundBonusRound_3() {
		int testGambl = calculateBonus(3, 1, 50, 50); //round=3, timeLeft=1, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(1, 3, seed); //timeLeft=1, round=3
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_4 method checks round frame 4-7, partition round 4, on boundary. 
	 * For this round frame, roundBonus must be 100.
	 */
	@Test
	public void testRoundBonusRound_4() {
		int testGambl = calculateBonus(4, 1, 100, 50); //round=4, timeLeft=1, roundBonus=50, timeBonus=50
		int gambl = player1.goToPub(1, 4, seed); //timeLeft=1, round 4
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_5 method checks round frame 4-7, partition round 4,
	 * going right direction. 
	 * For this round frame, roundBonus must be 100. 
	 */
	@Test
	public void testRoundBonusRound_5() {
		int testGambl = calculateBonus(5, 1, 100, 50); //round=5, timeLeft=1, roundBonus=100, timeBonus=50
		int gambl = player1.goToPub(1, 5, seed); //timeLeft=1, round=5
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_7 method checks round frame 4-7, partition round 7, on boundary.
	 * Also it checks partition round 8 for round frame 8-11 going false direction.
	 * For this time frame, roundBonus must be 100. 
	 */
	@Test
	public void testRoundBonusRound_7() {
		int testGambl = calculateBonus(7, 1, 100, 50); //round=7, timeLeft=1, roundBonus=100, timeBonus=50
		int gambl = player1.goToPub(1, 7, seed); //timeLeft=1, round=7
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_6 method checks round frame 4-7, partition round 7,
	 * going right direction. 
	 * For this round frame, roundBonus must be 100. 
	 */
	@Test
	public void testRoundBonusRound_6() {
		int testGambl = calculateBonus(6, 1, 100, 50); //round=6, timeLeft=1, roundBonus=100, timeBonus=50
		int gambl = player1.goToPub(1, 6, seed); //timeLeft=1, round=6
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_8 method checks round frame 8-11, partition round 8, on boundary.
	 * Also it checks partition round 7 for round frame 4-7 going false direction.
	 * For this time frame, roundBonus must be 150. 
	 */
	@Test
	public void testRoundBonusRound_8() {
		int testGambl = calculateBonus(8, 1, 150, 50); //round=8, timeLeft=1, roundBonus=150, timeBonus=50
		int gambl = player1.goToPub(1, 8, seed); //timeLeft=1, round=8
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_9 method checks round frame 8-11, partition round 8
	 * going right direction. 
	 * For this time frame, roundBonus must be 150. 
	 */
	@Test
	public void testRoundBonusRound_9() {
		int testGambl = calculateBonus(9, 1, 150, 50); //round=9, timeLeft=1, roundBonus=150, timeBonus=50
		int gambl = player1.goToPub(1, 9, seed); //timeLeft=1, round=9
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_11 method checks round frame 8-11, partition round 11, on boundary.
	 * Also it checks partition round 12 for round frame 12 going false direction.
	 * For this time frame, roundBonus must be 150. 
	 */
	@Test
	public void testRoundBonusRound_11() {
		int testGambl = calculateBonus(11, 1, 150, 50); //round=11, timeLeft=1, roundBonus=150, timeBonus=50
		int gambl = player1.goToPub(1, 11, seed); //timeLeft=1, round=11
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_10 method checks round frame 8-11, partition round 11
	 * going right direction. 
	 * For this time frame, roundBonus must be 150. 
	 */
	@Test
	public void testRoundBonusRound_10() {
		int testGambl = calculateBonus(10, 1, 150, 50); //round=10, timeLeft=1, roundBonus=150, timeBonus=50
		int gambl = player1.goToPub(1, 10, seed); //timeLeft=1, round=10
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_12 method checks round frame 12, partition round 12, on boundary.
	 * Also it checks partition round 11 for round frame 8-11 going false direction.
	 * For this time frame, roundBonus must be 200. 
	 */
	@Test
	public void testRoundBonusRound_12() {
		int testGambl = calculateBonus(12, 1, 200, 50); //round=12, timeLeft=1, roundBonus=200, timeBonus=50
		int gambl = player1.goToPub(1, 12, seed); //timeLeft=1, round=12
		assertEquals("Expected they are equal.", gambl, testGambl);
	}

	/**
	 * testRoundBonusRound_13 method checks out of bounds of round frame 12, partition round 12.
	 * Goes false direction.
	 * For this time frame, roundBonus must be 0 since round > 12.
	 */
	@Test
	public void testRoundBonusRound_13() {
		int gambl = player1.goToPub(1, 13, seed); //timeLeft=1, round=13
		assertEquals("Not a valid round.", gambl, 0);
	}

	//To test that all lines of code are executed and to test that the bonus 
	//cannot be more than $250. 
	//Settings: round = 12, timeLeft = 50, roundBonus = 200, timeBonus = 200,   

	/**
	 * testMoreThan250 method checks that all lines of code are executed, the bonus cannot be > $250,
	 */
	@Test
	public void testMoreThan250() {
		int gambl = player1.goToPub(50, 12, seed); //timeLeft=50, round=12
		assertEquals("Expected they are equal.", gambl, 250);
	}
	
	/**
	 * calculateBonus method is the helper method that calculates the expected bonus
	 * from the goToPub method,
	 */
	public int calculateBonus(int timeLeft, int round, int roundBonus1, int timeBonus) {
		Random randomGenerator1 = new Random(seed);
		int somerand = Math.abs((randomGenerator1.nextInt() % (timeBonus+1)));
		//System.out.println("random from test = " + somerand);
		int moneyBonus = roundBonus1 + somerand;  
		int maxBonus = 250;

		if(moneyBonus > maxBonus)
			moneyBonus = maxBonus;
		return moneyBonus;
	}

}
