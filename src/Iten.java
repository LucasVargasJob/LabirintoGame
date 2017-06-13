import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Iten {

	Image img;
	
	public Iten(String iten){
		addImg(iten);
	}
	
	public Image addImg(String imgIten){
		try {
			 this.img = new Image("img/"+imgIten+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}
