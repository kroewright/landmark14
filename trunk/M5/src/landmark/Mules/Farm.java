package landmark.Mules;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import landmark.Mule;

public class Farm extends Mule {


	private String type;
	private Graphics image;
	
	
	public Farm(){
		this.type = "farm";
		//this.image = "Farm.jpg";
		File img = new File("Tiles/farm.png");
		System.out.println(img);
		BufferedImage anImage = new BufferedImage(99,77, BufferedImage.TYPE_INT_ARGB);
		try { anImage = ImageIO.read(img ); } catch (IOException e) { }
		Graphics g = anImage.createGraphics();
		image = g;
		
	}
	
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public Graphics getImage() {
		return image;
	}

}
