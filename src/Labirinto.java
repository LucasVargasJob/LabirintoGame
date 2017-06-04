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
	Warrior warrior = new Warrior();
	int cont = 0;
	int warriorX = 200, warriorY = 200;
	int enemyX = 450, enemyY = 200;
	int southX = 350, southY = 510;
	int northX = 350, northY = 5;
	int eastX = 707, eastY = 250;
	int westX = 10, westY = 250;
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		canvas.drawImage(sala[cont].fundo, 0, 0);
		canvas.drawImage(warrior.img, warriorX, warriorY);
		canvas.drawImage(sala[cont].enemy.img, enemyX, enemyY);
		canvas.putText(100, 10, 28, String.format("Sala "+sala[cont].room));
		
		if(sala[cont].doorEast != null){
			canvas.drawImage(sala[cont].doorEast.img, eastX, eastY);
		}
		if(sala[cont].doorWest != null){
			canvas.drawImage(sala[cont].doorWest.img, westX, westY);
		}
		if(sala[cont].doorNorth != null){
			canvas.drawImage(sala[cont].doorNorth.img, northX, northY);		
		}
		if(sala[cont].doorSouth != null){
			canvas.drawImage(sala[cont].doorSouth.img, southX, southY);
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
				enemyPositionRandom();
			}
			//North
			if(sala[cont].north != null && northX+90 > point.x  && northX <point.x-5 && northY+65 > point.y && northY < point.y+5){
				cont = Integer.parseInt(sala[cont].north);
				cont -=1;
				enemyPositionRandom();
			}
			//East
			if(sala[cont].east != null && eastX+90 > point.x  && eastX <point.x+5 && eastY+90 > point.y && eastY < point.y-10){
				cont = Integer.parseInt(sala[cont].east);
				cont -=1;
				enemyPositionRandom();
			}
			//East
			if(sala[cont].west != null && westX+90 > point.x  && westX <point.x+5 && westY+90 > point.y && westY < point.y-10){
				cont = Integer.parseInt(sala[cont].west);
				cont -=1;
				enemyPositionRandom();
				
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
	
    public int rand(int Str, int End) {
        return (int) Math.ceil(Math.random() * (End  - Str + 1)) - 1 + Str;
    }
    
    public void enemyPositionRandom(){
		enemyX = rand(300,550);
		enemyY = rand(100, 400);
    }
	
	
}
