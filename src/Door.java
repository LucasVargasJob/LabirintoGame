import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Door {
	
	Image img;
	Iten iten;
	boolean padlock = true;
	
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
	
	public boolean openDoor(Iten iten){
		if(iten.name == "key"){
			return true;
		}else{
			return false;
		}
	}


}
