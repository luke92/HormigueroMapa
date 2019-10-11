package hormiguero;

import java.util.ArrayList;

public class Tablero {

	private ArrayList<Casillero> casilleros = new ArrayList<Casillero>();

	public ArrayList<Casillero> getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(ArrayList<Casillero> casilleros) {
		this.casilleros = casilleros;
	}

	public Tablero(int n) {
		
		for (int i = 0; i < n; i++) 
		{
			casilleros.add(new Casillero(i + 1));
			
		}
		
	}
	
	public int cantidadCasilleros()
	{
		return this.getCasilleros().size();
	}
	
	public Casillero primerCasillero()
	{
		return this.getCasilleros().get(0);
	}
}
