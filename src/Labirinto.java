import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Resolution;

public class Labirinto extends GraphicApplication {

	@Override
	protected void draw(Canvas canvas) {

		
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
		Room sala[] = new Room [31];
		String[] linha = new String[31];
		Scanner scanner = null;
		int i = 0;
		double room=0, east=0, west=0, north=0, south=0, down=0, up=0;
		
		try {
			scanner = new Scanner (new FileReader("Labirinto.txt")).useDelimiter("\n");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scanner.hasNext()) {
			linha[i] = scanner.next();
			String aux[] = linha[i].split(";");
			for (int b=0; b < aux.length ; b ++) {
				char [] letras = aux[b].toCharArray();
				
				if (letras[0] == 'r'){	
					aux[b] = aux[b].replace("room ", "");
					room = Double.parseDouble(aux[b]);	
				}
				if (letras[0] == 'e'){	
					aux[b] = aux[b].replace("east ", "");
					east = Double.parseDouble(aux[b]);	
				}	
				if (letras[0] == 'w'){	
					aux[b] = aux[b].replace("west ", "");
					west = Double.parseDouble(aux[b]);	
				}	
				if (letras[0] == 'n'){	
					aux[b] = aux[b].replace("north ", "");
					north = Double.parseDouble(aux[b]);	
				}	
				if (letras[0] == 's'){	
					aux[b] = aux[b].replace("south ", "");
					south = Double.parseDouble(aux[b]);	
				}	
				if (letras[0] == 'd'){	
					aux[b] = aux[b].replace("down ", "");
					down = Double.parseDouble(aux[b]);	
				}
				if (letras[0] == 'u'){	
					aux[b] = aux[b].replace("up ", "");
					up = Double.parseDouble(aux[b]);	
				}	
			}
			sala[i] = new Room (room, east, west, north,  south, down, up);
			i++;			
		}
		
	}
	
	
}
