package landmark.Mules;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import landmark.Mule;

public class Mine extends Mule {


	private String type;
	private Graphics image;
	
	
	public Mine(){
		this.type = "mine";
		//this.image = "Mine.jpg";
		File img = new File("Tiles/mine.png");
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
