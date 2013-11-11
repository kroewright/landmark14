package landmark;

import static org.junit.Assert.*;
import landmark.Tiles.Mountains;
import landmark.Tiles.Plains;
import landmark.Tiles.River;
import landmark.Tiles.Town;

import org.junit.Test;

public class MasonTileFactoryTest {
	
	/**
	 * Test for negative i value throwing ioob exception
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void outOfBoundsTest1(){
		Overworld.tileFactory(-1,2);
	}
	
	/**
	 * Test for negative j value throwing ioob exception
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void outOfBoundsTest2(){
		Overworld.tileFactory(1,-2);
	}
	
	
	/**
	 * Test for too large j throwing ioob
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void outOfBoundsTest3(){
		Overworld.tileFactory(1,30);
	}
	
	/**
	 * Test for too large i throwing ioob
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void outOfBoundsTest4(){
		Overworld.tileFactory(54,2);
	}
	
	
	/**
	 * Ensures town created correctly
	 */
	@Test
	public void townProducedTest(){
		Tile town = Overworld.tileFactory(2,4);
		Town aTown = new Town();
		assertEquals(aTown.getClass(),town.getClass());
	}
	
	/**
	 * Ensures river created correctly
	 */
	@Test
	public void riverProducedTest(){
		Tile river = Overworld.tileFactory(0, 4);
		River aRiver = new River(4);
		assertEquals(aRiver.getClass(), river.getClass());
		assertEquals(aRiver.getLocation(), river.getLocation());
	}
	
	/**
	 * Ensures plains created correctly
	 */
	@Test
	public void plainsProducedTest(){
		Tile plain = Overworld.tileFactory(0, 0);
		Plains aPlain = new Plains(0);
		assertEquals(aPlain.getClass(), plain.getClass());
		assertEquals(aPlain.getLocation(), plain.getLocation());
		
	}
	
	/**
	 * Ensures mountains created correctly
	 */
	@Test
	public void mountainsProducedTest() {
		Tile mountain = Overworld.tileFactory(2,0);
		Mountains aMountain = new Mountains(18,3);
		assertEquals(aMountain.getClass(), mountain.getClass());
		assertEquals(aMountain.getLocation(),mountain.getLocation());
		assertEquals(aMountain.getType(), ((Mountains) mountain).getType());
	}

}
