package landmark;

import java.awt.image.BufferedImage;

public abstract class Mule {

	private String type;
	private String image;
	
	public abstract String getType();
	public abstract String getImage();
	
	public String setType(String type){
		return type;
	}
	
}
