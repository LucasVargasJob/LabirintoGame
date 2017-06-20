import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Iten {

	Image img;
	String name;
	double damage = 0;
	double armor = 0;
	double chance = 0;
	
	public Iten(String iten){
		addImg(iten);
		addAttributes(iten);
	}
	
	public Image addImg(String imgIten){
		try {
			 this.img = new Image("img/"+imgIten+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void addAttributes(String iten ){
		if (iten == "key"){
			this.name = iten;
		}
		if (iten == "dagger"){
			this.name = iten;
			this.damage = 1;
		}
		if (iten == "knife"){
			this.name = iten;
			this.damage = 2;
			this.chance = 5;
		}
		if (iten == "sword"){
			this.name = iten;
			this.damage = 3;
			this.chance = 10;
		}
		if (iten == "longSword"){
			this.name = iten;
			this.damage = 5;
			this.chance = -10;
		}
		if (iten == "shield"){
			this.name = iten;
		}
	}
	
}
