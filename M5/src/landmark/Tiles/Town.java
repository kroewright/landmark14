package landmark.Tiles;

import java.awt.image.BufferedImage;

import landmark.Player;
import landmark.Tile;

public class Town extends Tile{

	@Override
	protected Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getR() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	protected int getC() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	protected BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setOwner(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int getFYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getEYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getOYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void setImage() {
		// TODO Auto-generated method stub
		
	}

}
