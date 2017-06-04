import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Enemy {

	Image img;

	
	public Enemy(String imgEnemy){
		AddImg(imgEnemy);
	}
	
	public Image AddImg(String imgEnemy){
		try {
			 this.img = new Image("img/"+imgEnemy+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}

