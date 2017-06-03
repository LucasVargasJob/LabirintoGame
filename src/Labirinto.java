import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Resolution;

public class Labirinto extends GraphicApplication {
	Room sala[] = new Room [31];
	
	
	
	@Override
	protected void draw(Canvas canvas) {
		int cont = 1;
		canvas.drawImage(sala[cont].fundo, 0, 0);
		
		if(sala[cont].DoorEast != null){
			canvas.drawImage(sala[cont].DoorEast.img, 590, 200);
		}
		if(sala[cont].DoorWest != null){
			canvas.drawImage(sala[cont].DoorWest.img, -40, 200);
		}
		if(sala[cont].DoorNorth != null){
			canvas.drawImage(sala[cont].DoorNorth.img, 270, 20);
		}
		if(sala[cont].DoorSouth != null){
			canvas.drawImage(sala[cont].DoorSouth.img, 270, 350);
		}
		
		
	}
	
	@Override
	protected void setup() {
		Resolution res = Resolution.HIGHRES;
		this.setResolution(res);
		this.setFramesPerSecond(30);
		carregaArquivo();
		
		
	}

	@Override
	protected void loop() {
	
		
	}

	
	//METODOS -----------------------------------------------------------------------------------------------------------
	
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
