import com.senac.SimpleJava.Console;

public class Inventory {
	Iten iten [] = new Iten [2];
	
	public void addIten(String param){
		if(full() == false){
			if(iten[0] == null){
				iten[0] = new Iten(param);
			}else{
				iten[1] = new Iten(param);
			}
		}else{
			Console.println("Inventario Lotado");
		}
	}
	
	public void removeIten(int index){
		this.iten[index] = null;
	}
	
	public boolean vefiricaKey(){
		if (iten [0] != null && iten[0].name =="key"){
			return true;
		}
		if (iten [1] != null && iten[1].name =="key"){
			return true;
		}
		return false;
	}
	
	public void removeKey(){
		if (iten[0].name == "key"){
			iten[0] = null;
		}else{
			iten[1] = null;
		}
	}
	
	
	
	public boolean full(){
		if (iten[0] == null || iten[1] == null){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	
}
