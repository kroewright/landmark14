package landmark.Mules;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import landmark.Mule;

public class Farm extends Mule {


	private String type;
	private String image;
	
	
	public Farm(){
		this.type = "farm";
		//this.image = "Farm.jpg";
		File img = new File("Mules/farm.png");
		System.out.println(img);
		BufferedImage anImage = new BufferedImage(99,77, BufferedImage.TYPE_INT_ARGB);
		try { anImage = ImageIO.read(img ); } catch (IOException e) { }
		Graphics g = anImage.createGraphics();
		//image = g;
		
		
		image = "Mules/farm.jpg";
		
	}
	
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getImage() {
		return image;
	}

}
