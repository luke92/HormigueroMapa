package hormiguero;

public class Casillero {
	
	private int casilla;
	private int salto;
	boolean ultimo;
	
	public Casillero(int casilla)
	{
		this.setCasilla(casilla);
		this.salto = -1;
	}
	
	public int getCasilla() {
		return casilla;
	}

	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}

	public int getSalto() {
		return salto;
	}

	public void setSalto(int salto) {
		this.salto = salto;
	}
	
	public boolean existeSalto()
	{
		return this.getSalto() > 0;
	}

}

	



