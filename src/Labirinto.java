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
	int cont = rand(1,30);;
	int warriorX = 200, warriorY = 200;
	int enemyX = 450, enemyY = 200;
	int itenX = 300, itenY = 400;
	int southX = 350, southY = 510;
	int northX = 350, northY = 5;
	int eastX = 707, eastY = 250;
	int westX = 10, westY = 250;
	
	/* Adicionar Armadura e imagem para quando o warrior morrer ou quando ele chegar na sala 0 (-1) */
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		canvas.drawImage(sala[cont].fundo, 0, 0);
		canvas.drawImage(warrior.img, warriorX, warriorY);
		
		if(warrior.armor != null){
			canvas.drawImage(warrior.armor.img, 600, 4);
		}
		if(warrior.inventory.iten[0] != null){
			canvas.drawImage(warrior.inventory.iten[0].img, 680, 6);
		}
		if(warrior.inventory.iten[1] != null){
			canvas.drawImage(warrior.inventory.iten[1].img, 712, 6);
		}
		canvas.putText(110, 10, 20, String.format(" "+sala[cont].room));
		canvas.putText(230, 10, 20, String.format(" "+ warrior.life));
		if(sala[cont].enemy != null){
			canvas.putText(enemyX+5,enemyY-20, 16, String.format("HP: "+ sala[cont].enemy.life));
			canvas.drawImage(sala[cont].enemy.img, enemyX, enemyY);
		}
		if(sala[cont].iten != null){
			canvas.drawImage(sala[cont].iten.img, itenX, itenY);
		}
		if(sala[cont].key != null){
			canvas.drawImage(sala[cont].key.img, itenX+30, itenY+20);
		}
		if(sala[cont].armor != null){
			canvas.drawImage(sala[cont].armor.img, itenX+60, itenY+50);
		}
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
	
	//Metodo de eventos de mouse.
	@Override
	public void notify(MouseEvent event, int button, Point point) {
		
		if (event == MouseEvent.CLICK) {
			//Warrior
			if(warriorX+60 > point.x && warriorX < point.x-20 && warriorY+90 > point.y && warriorY < point.y-20){

			}
			//Enemy
			if(sala[cont].enemy != null & enemyX+90 > point.x && enemyX < point.x-5 && enemyY+90 > point.y && enemyY < point.y-10){
				chanceAcertoWarrior();
				if(sala[cont].enemy != null){
					chanceAcertoEnemy();
				}
			}
			//Iten
			if(sala[cont].iten != null & itenX+90 > point.x && itenX < point.x-5 && itenY+20 > point.y && itenY < point.y+5){
				if(warrior.inventory.full() == false){
					warrior.inventory.addIten(sala[cont].iten.name); 
					sala[cont].iten = null;
				}else{
					Console.println("Inventario lotado");
				}
			}
			//Key
			if(sala[cont].key != null & itenX+110 > point.x && itenX+30 < point.x-5 && itenY+40 > point.y && itenY+20 < point.y+5){
				if(warrior.inventory.full() == false){
					warrior.inventory.addIten(sala[cont].key.name); 
					sala[cont].key = null;
				}else{
					Console.println("Inventario lotado");
				}
			}
			//armor
			if(sala[cont].armor != null & itenX+140 > point.x && itenX+60 < point.x-5 && itenY+70 > point.y && itenY+50 < point.y+5){
				if(warrior.armor == null){
					warrior.armor = sala[cont].armor; 
					sala[cont].armor = null;
				}else{
					Console.println("Armadura já equipada");
				}
			}
			//Primeiro Iten do inventario.
			if(warrior.inventory.iten[0] != null && 680+20 > point.x && 680 < point.x-5 && 6+25 > point.y && 6 < point.y+5){
				if(sala[cont].iten == null){
					sala[cont].iten = warrior.inventory.iten[0];
				} else if(sala[cont].key == null){
					sala[cont].key = warrior.inventory.iten[0];
				}
				warrior.inventory.removeIten(0);
				
			}
			//Segundo Iten do inventario.
			if(warrior.inventory.iten[1] != null && 712+20 > point.x && 712 < point.x-5 && 6+25 > point.y && 6 < point.y+5){
				if(sala[cont].iten == null){
					sala[cont].iten = warrior.inventory.iten[1];
				} else if(sala[cont].key == null){
					sala[cont].key = warrior.inventory.iten[1];
				}
				warrior.inventory.removeIten(1);
			}
			
			//Armadura inventario.
			if(warrior.armor != null && 605+20 > point.x && 605 < point.x-5 && 6+25 > point.y && 6 < point.y+5){
				if(sala[cont].armor == null){
					sala[cont].armor = warrior.armor;
					warrior.armor = null;
				}else{
					warrior.armor = null;
				}
			}
						
			//South
			if(sala[cont].south != null && southX+90 > point.x  && southX <point.x-5 && southY+65 > point.y && southY < point.y+5){
				if (sala[cont].doorSouth.padlock == false || warrior.inventory.vefiricaKey() == true){
					sala[cont].doorSouth.AddImg("southOpen");
					if (sala[cont].doorSouth.padlock != false){
						warrior.inventory.removeKey();
					}
					sala[cont].doorSouth.padlock = false;
					cont = Integer.parseInt(sala[cont].south);
					cont -=1;
					sala[cont].doorNorth.AddImg("northOpen");
					sala[cont].doorNorth.padlock = false;
					enemyPositionRandom();
				}else{}
			}
			
			//North
			if(sala[cont].north != null && northX+90 > point.x  && northX <point.x-5 && northY+65 > point.y && northY < point.y+5){
				if (sala[cont].doorNorth.padlock == false || warrior.inventory.vefiricaKey() == true){
					sala[cont].doorNorth.AddImg("northOpen");
					if (sala[cont].doorNorth.padlock != false){
						warrior.inventory.removeKey();
					}
					sala[cont].doorNorth.padlock = false;
					cont = Integer.parseInt(sala[cont].north);
					cont -=1;
					sala[cont].doorSouth.AddImg("southOpen");
					sala[cont].doorSouth.padlock = false;
					enemyPositionRandom();
				}else{}
			}
			//East
			if(sala[cont].east != null && eastX+90 > point.x  && eastX <point.x+5 && eastY+90 > point.y && eastY < point.y-10){
				if (sala[cont].doorEast.padlock == false || warrior.inventory.vefiricaKey() == true){	
					sala[cont].doorEast.AddImg("eastOpen");
					if (sala[cont].doorEast.padlock != false){
						warrior.inventory.removeKey();
					}
					sala[cont].doorEast.padlock = false;
					cont = Integer.parseInt(sala[cont].east);
					cont -=1;
					sala[cont].doorWest.AddImg("westOpen");
					sala[cont].doorWest.padlock = false;
					enemyPositionRandom();
				}else{}
			}
			//West
			if(sala[cont].west != null && westX+90 > point.x  && westX <point.x+5 && westY+90 > point.y && westY < point.y-10){
				if (sala[cont].doorWest.padlock == false || warrior.inventory.vefiricaKey() == true){
					sala[cont].doorWest.AddImg("westOpen");
					if (sala[cont].doorWest.padlock != false){
						warrior.inventory.removeKey();
					}
					sala[cont].doorWest.padlock = false;
					cont = Integer.parseInt(sala[cont].west);
					cont -=1;
					sala[cont].doorEast.AddImg("eastOpen");
					sala[cont].doorEast.padlock = false;
					enemyPositionRandom();
				}else{}	
			}
		}
	}
	
	//Metodo de carregar arquivo e criação do labirinto.
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
	
	//Metodo random.
    public int rand(int Str, int End) {
        return (int) Math.ceil(Math.random() * (End  - Str + 1)) - 1 + Str;
    }
    
    //Metodo de trocar posição do inimigo.
    public void enemyPositionRandom(){
		enemyX = rand(300,550);
		enemyY = rand(100, 400);
    }
    
    //Metodo de combate do Warrior.
    public void chanceAcertoWarrior(){
    	warrior.atribuiAtackAndChance();
    	int atackWarrior = rand(1,100);
    	if (sala[cont].enemy != null && atackWarrior <= warrior.chance){
    		 sala[cont].enemy.life -= warrior.damage;
    		 	if (sala[cont].enemy.life <= 0){
    			 sala[cont].enemy = null;
    			 sala[cont].key = new Iten("key");
    		 	}
    	}else{
    		enemyX += 20;
    	}
    	warrior.resetAtributtos();
    }
  //Metodo de combate do Enemy.
    public void chanceAcertoEnemy(){
    	int atackEnemy = rand(1,100);
    	int temp = sala[cont].enemy.chance;
    	if (warrior.inventory.verificaShield() == true){
    		sala[cont].enemy.chance -= 25;
    	}
    	if (atackEnemy <= sala[cont].enemy.chance){
    		if (warrior.armor != null){
    			int dano = (int) (sala[cont].enemy.damage - warrior.armor.armor);
    			if (dano >= 0){
    			warrior.life -= dano;
    			}
    		}else{
    			warrior.life -= sala[cont].enemy.damage;
    		}
    		
    		if (warrior.life <= 0)
    			cont = -1;
    	}else{
    		warriorX += 20;
    	}
    	sala[cont].enemy.chance = temp;
    }
    

    
    
	
}
