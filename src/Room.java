import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Room {
	
	String room, east, west, north, south, down, up;
	Door DoorEast, DoorWest, DoorNorth, DoorSouth, DoorDown, DoorUp;
	Warrior warrior;
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
		warrior = new Warrior();
		enemy = new Enemy();
	}
	
	public void criaSala(){
		if (east != null){
			DoorEast = new Door("east");
		}
		if (west != null){
			DoorWest = new Door("west");
		}
		if (north != null){
			DoorNorth = new Door("north");
		}
		if (south != null){
			DoorSouth = new Door("south");
		}
		if (down != null){
			DoorDown = new Door("down");
		}
		if (up != null){
			DoorUp = new Door("up");
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
