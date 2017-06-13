import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;

public class Warrior  {
	
	Image img;
	int life = 20;
	int damage = 2;
	int chance = 75;
	Weapon weapon;
	Inventory inventory;
	
	
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
	
	public void addWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
}
