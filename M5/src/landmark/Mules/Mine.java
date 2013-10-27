package landmark.Mules;


import landmark.Mule;

public class Mine extends Mule {


	private String type;
	private String image;
	
	
	public Mine(){
		this.type = "mine";
		this.image = "Mine.jpg";
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
