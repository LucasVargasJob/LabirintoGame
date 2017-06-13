import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Enemy {

	Image img;
	int damage;
	double life;
	Boolean weapon = false;

	
	public Enemy(String Enemy){
		addImg(Enemy);
		addDamage(Enemy);
	}
	
	public Image addImg(String imgEnemy){
		try {
			 this.img = new Image("img/"+imgEnemy+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void addDamage(String enemy ){
		if (enemy == "goblin"){
			this.damage = 2;
			this.life = 4;
			
		}
		if (enemy == "orc"){
			this.damage = 4;
			this.life = 6;
		}	
		if (enemy == "troll"){
			this.damage = 6;
			this.life = 8;
		}
	}
}

