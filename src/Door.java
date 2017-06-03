import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Door {
	
	Image img;
	
	public Door(){
		AddImg();
	}
	
	public  Image AddImg(){
		try {
			 this.img = new Image("img/porta.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}
