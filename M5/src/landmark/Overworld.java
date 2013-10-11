package landmark;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Overworld extends JPanel {
	
	//private Tiles[] tiles;
	private BufferedImage picture;
	private JPanel panel;
	
	/**
	* Create the panel.
	*/
	public Overworld() {
		panel = new JPanel();
		try 
	    {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Show_Players_Fake.jpg");
			picture = ImageIO.read(input);
	    } 
	    catch(IOException e) 
	    {
	      e.printStackTrace();
	    }
		
		panel.setPreferredSize(new Dimension(800, 800));

	}
	
	/*
	public addTile(Tile mapPiece) {
		
	}
	*/
	
	protected void paintComponent(Graphics g) 
	  {
	    super.paintComponent(g);
	    g.drawImage(picture, 0, 0, getWidth(), getHeight(), this);
	  }
	

}
