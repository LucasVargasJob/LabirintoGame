import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Armor {

	Image img;
	String name;
	double armor = 0;
	
	
	public Armor (String armor){
		addImg(armor);
		addAttributes(armor);
	}
	
	public Image addImg(String imgArmor){
		try {
			 this.img = new Image("img/"+imgArmor+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void addAttributes(String iten ){
		if (iten == "couro"){
			this.name = iten;
			this.armor = 2;
		}
		if (iten == "metal"){
			this.name = iten;
			this.armor = 3;
		}
		if (iten == "mithril"){
			this.name = iten;
			this.armor = 5;
		}
	}
	
}