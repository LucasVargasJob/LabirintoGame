import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Door {
	
	Image img;
	
	public Door(String imgDoor){
		AddImg(imgDoor);
	}
	
	public  Image AddImg(String imgDoor){
		try {
			 this.img = new Image("img/"+imgDoor+ ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}
