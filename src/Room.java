import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Room {
	
	String room, east, west, north, south, down, up;
	Door doorEast, doorWest, doorNorth, doorSouth, doorDown, doorUp;
	Enemy enemy;
	Iten key = null;
	Iten iten = null;
	Armor armor = null;
	Image fundo;
	
	public Room ( String room, String east, String west, String north, String south, String down, String up){
		this.room = room;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
		this.down = down;
		this.up = up;
		AddImg();
		criaSala();
		criaInimigo();
		randomMapIten();
	}
	
	public void criaSala(){
		if (east != null){
			doorEast = new Door("east");
		}
		if (west != null){
			doorWest = new Door("west");
		}
		if (north != null){
			doorNorth = new Door("north");
		}
		if (south != null){
			doorSouth = new Door("south");
		}
		if (down != null){
			doorDown = new Door("down");
		}
		if (up != null){
			doorUp = new Door("up");
		}
		
	}
	
	public void criaInimigo(){
		int numb = (int) (Math.random() * 3);
		
		if (numb == 0){
			this.enemy = new Enemy("orc");
		}
		if (numb == 1){
			this.enemy = new Enemy("goblin");
		}
		if (numb == 2){
			this.enemy = new Enemy("troll");
		}
	}
	
	public void randomMapIten(){
		int numb = (int) (Math.random() * 2);
		
		if (numb == 0 ){
			criaIten();
		}
		if (numb == 1){
			
		}
	}
	
	public void randomArmor(){
		int numb = (int) (Math.random() * 3);
		
		if (numb == 0){
			this.armor = new Armor("couro");
		}
		if (numb == 1){
			this.armor = new Armor("metal");
		}
		if (numb == 2){
			this.armor = new Armor("mithril");
		}
	}
	
	public void criaIten(){
		int numb = (int) (Math.random() * 6);
		
		if (numb == 0){
			this.iten = new Iten("dagger");
		}
		if (numb == 1){
			this.iten = new Iten("shield");
		}
		if (numb == 2){
			randomArmor();
		}
		if (numb == 3){
			this.iten = new Iten("longSword");
		}
		if (numb == 4){
			this.iten = new Iten("knife");
		}
		if (numb == 5){
			this.iten = new Iten("sword");
		}
	}
	
	public void AddImg(){
		try {
			 this.fundo = new Image("img/mapa.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
