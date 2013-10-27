package landmark.Mules;


import landmark.Mule;

public class Farm extends Mule {


	private String type;
	private String image;
	
	
	public Farm(){
		this.type = "farm";
		this.image = "Farm.jpg";
		
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
