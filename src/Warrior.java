import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;

public class Warrior  {
	
	Image img;
	int x = 200;
	int y = 200;
	
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
	
	public Point getPosition() {
		return new Point((int)x,(int)y);
	}



}
