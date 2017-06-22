import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;

public class Warrior  {
	
	Image img;
	int life = 20;
	int damage = 2;
	int chance = 75;
	Inventory inventory = new Inventory();
	Armor armor;
	
	
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
	
	public void atribuiAtackAndChance(){
    	for(int a=0;a<=1;a++){
    		if(inventory.iten[a] != null){
    			this.damage += inventory.iten[a].damage;
    			this.chance += inventory.iten[a].chance;
    		}
    	}
    }
	
	public void resetAtributtos(){
		this.chance = 75;
		this.damage = 2;
	}
	
}
