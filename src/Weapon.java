import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Weapon {
	
	Image img;
	double damage;


	public Weapon(String weapon){
		AddImg(weapon);
		addDamage(weapon);
	}
	
	public Image AddImg(String imgWeapon){
		try {
			 this.img = new Image("img/"+imgWeapon+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void addDamage(String weapon){
		if (weapon == "adaga"){
			this.damage = 1;
		}
		if (weapon == "faca"){
			this.damage = 2;
		}
		if (weapon == "espada"){
			this.damage = 3;
		}
		if (weapon == "espadaLonga"){
			this.damage = 5;
		}
	}

}
