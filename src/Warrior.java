import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Warrior {
	
	Image img;
	
	public Warrior(){
		AddImg();
	}
	
	public Image AddImg(){
		try {
			 this.img = new Image("img/warrior.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}


}
