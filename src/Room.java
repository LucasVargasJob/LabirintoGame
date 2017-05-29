
public class Room {
	
	double room = 0;
	double east = 0;
	double west = 0;
	double north = 0;
	double south = 0;
	double down = 0;
	double up = 0;
	
	public Room ( double room, double east, double west, double north, double south, double down, double up){
		this.room = room;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
		this.down = down;
		this.up = up;
	}
	
	public String toString(){
		return
			"Sala "+room+" "+
			"south: " + south+ " "+
			"east: "+east+ " "+
			"west: "+ west+ " "+
			"north: "+north+ " "+
			"south: "+south+ " "+
			"down: "+ down+ " "+
			"up: "+ up + " ";
	}
	
}
