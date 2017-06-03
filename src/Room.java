import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Room {
	
	String room, east, west, north, south, down, up;
	Door DoorEast, DoorWest, DoorNorth, DoorSouth, DoorDown, DoorUp;
	Image fundo;
	
	public Room ( String room, String east, String west, String north, String south, String down, String up){
		this.room = room;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
		this.down = down;
		this.up = up;
		Exibe();
		criaSala();
	}
	
	public void criaSala(){
		if (east != null){
			DoorEast = new Door();
		}
		if (west != null){
			DoorWest = new Door();
		}
		if (north != null){
			DoorNorth = new Door();
		}
		if (south != null){
			DoorSouth = new Door();
		}
		if (down != null){
			DoorDown = new Door();
		}
		if (up != null){
			DoorUp = new Door();
		}
		
	}
	
	public void Exibe(){
		try {
			 this.fundo = new Image("img/mapa.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
