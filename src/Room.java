import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Room {
	
	String room, east, west, north, south, down, up;
	Door doorEast, doorWest, doorNorth, doorSouth, doorDown, doorUp;
	Enemy enemy;
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
	
	public void AddImg(){
		try {
			 this.fundo = new Image("img/mapa.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
