import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Enemy {

	Image img;

	
	public Enemy(){
		AddImg();
	}
	
	public Image AddImg(){
		try {
			 this.img = new Image("img/orc.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
