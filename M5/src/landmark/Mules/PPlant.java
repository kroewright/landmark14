package landmark.Mules;


import java.awt.Graphics;

import landmark.Mule;

public class PPlant extends Mule {


	private String type;
	private Graphics image;
	
	
	public PPlant(){
		this.type="PPlant";
		//this.image = "PPlant.jpg";
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
