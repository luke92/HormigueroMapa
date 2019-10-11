package hormiguero;
import java.util.Random;

public class Dado {
	private int numero;
	
public int random (){
	Random  rnd = new Random();
	return  (int)(rnd.nextDouble() * 5 + 1);
}

public void lanzardado (){
	this.numero = random();
}

public int getNumero() {
	return numero;
}


}