package landmark.Mules;


import landmark.Mule;

public class PPlant extends Mule {


	private String type;
	private String image;
	
	
	public PPlant(){
		this.type="PPlant";
		this.image = "PPlant.jpg";
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
