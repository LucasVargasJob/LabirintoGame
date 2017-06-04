import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

public class Labirinto extends GraphicApplication implements MouseObserver {
	Room sala[] = new Room [31];
	int cont = 0;
	int warriorX = 200, warriorY = 200;
	int southX = 350, southY = 510;
	int northX = 350, northY = 5;
	int eastX = 707, eastY = 250;
	int westX = 10, westY = 250;
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		canvas.drawImage(sala[cont].fundo, 0, 0);
		canvas.drawImage(sala[cont].warrior.img,warriorX,warriorY);
		canvas.putText(400, 200, 20, String.format("Sala "+sala[cont].room));
		
		if(sala[cont].DoorEast != null){
			canvas.drawImage(sala[cont].DoorEast.img, eastX, eastY);
		}
		if(sala[cont].DoorWest != null){
			canvas.drawImage(sala[cont].DoorWest.img, westX, westY);
		}
		if(sala[cont].DoorNorth != null){
			canvas.drawImage(sala[cont].DoorNorth.img, northX, northY);		
		}
		if(sala[cont].DoorSouth != null){
			canvas.drawImage(sala[cont].DoorSouth.img, southX, southY);
		}
		
	}
	
	@Override
	protected void setup() {
		Resolution res = Resolution.HIGHRES;
		this.setResolution(res);
		this.setFramesPerSecond(30);
		carregaArquivo();
		addMouseObserver(MouseEvent.CLICK, this);
		
		
	}

	@Override
	protected void loop() {
		redraw();
	}

	
	//METODOS -----------------------------------------------------------------------------------------------------------
	
	@Override
	public void notify(MouseEvent event, int button, Point point) {
		
		if (event == MouseEvent.CLICK) {
			//Warrior
			if(warriorX+60 > point.x && warriorX < point.x-20 && warriorY+90 > point.y && warriorY < point.y-20){
				warriorX += 20;
			}
			//South
			if(sala[cont].south != null && southX+90 > point.x  && southX <point.x-5 && southY+65 > point.y && southY < point.y+5){
				cont = Integer.parseInt(sala[cont].south);
				cont -=1;
			}
			//North
			if(sala[cont].north != null && northX+90 > point.x  && northX <point.x-5 && northY+65 > point.y && northY < point.y+5){
				cont = Integer.parseInt(sala[cont].north);
				cont -=1;
			}
			//East
			if(sala[cont].east != null && eastX+90 > point.x  && eastX <point.x+5 && eastY+90 > point.y && eastY < point.y-10){
				cont = Integer.parseInt(sala[cont].east);
				cont -=1;
			}
			//East
			if(sala[cont].west != null && westX+90 > point.x  && westX <point.x+5 && westY+90 > point.y && westY < point.y-10){
				cont = Integer.parseInt(sala[cont].west);
				cont -=1;
				
			}

		}
		
	}
	
	public void carregaArquivo (){
		String[] linha = new String[31];
		Scanner scanner = null;
		int i = 0;
		
		try {
			scanner = new Scanner (new FileReader("Labirinto.txt")).useDelimiter("\n");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scanner.hasNext()) {
			String room = null, east=null, west=null, north=null, south=null, down=null, up=null;
			linha[i] = scanner.next();
			String aux[] = linha[i].split(";");
			for (int b=0; b < aux.length ; b ++) {
				char [] letras = aux[b].toCharArray();
				
				if (letras[0] == 'r'){	
					aux[b] = aux[b].replace("room ", "");
					room = aux[b];	
				}
				if (letras[0] == 'e'){	
					aux[b] = aux[b].replace("east ", "");
					east = aux[b];	
				}	
				if (letras[0] == 'w'){	
					aux[b] = aux[b].replace("west ", "");
					west = aux[b];	
				}	
				if (letras[0] == 'n'){	
					aux[b] = aux[b].replace("north ", "");
					north = aux[b];	
				}	
				if (letras[0] == 's'){	
					aux[b] = aux[b].replace("south ", "");
					south = aux[b];	
				}	
				if (letras[0] == 'd'){	
					aux[b] = aux[b].replace("down ", "");
					down = aux[b];	
				}
				if (letras[0] == 'u'){	
					aux[b] = aux[b].replace("up ", "");
					up = aux[b];	
				}	
			}
			sala[i] = new Room (room, east, west, north,  south, down, up);
			i++;			
		}
	}
	
	
}
