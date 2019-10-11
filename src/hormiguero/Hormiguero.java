/*
 * Interfaz:
Hormiguero (n) //tamaño del hormiguero, donde n > 1
Int cantJugadas() //devuelve el nro de jugadas hasta el momento
Void agregarAtajo (int desde, int hasta) //Agrega un atajo
void jugar() // tira los dos dados
String ver() // muestra el estado del tablero y de la hormiga
Int ultimaCasilla() // casilla actual de la hormiga
Ejemplo del código principal:
Hormiguero m = new Hormiguero(8); // Instancia: n == 8
m. agregarAtajo(6,1);//atajo desde 6 hasta 1
m.agregarCasilla(3, 7);
while m. ultimaCasilla() != 8{ //como máximo hacerlo 1000 veces
m.jugar(); // La hormiga “tira” el dado
System.out.println(m.ver()) //Se muestra un resumen del
hormiguero
}
System.out.println(m. cantJugadas ());
Test1
Modelar la instancia del enunciado.
b) Escribir el invariante de representación del Hormiguero.
Describir que Hormigueros son instancias validas del Hormiguero que se quiere
representar
 */

package hormiguero;

public class Hormiguero {
	private Tablero tablero ;
	private int cantidadJugadas;
	private int totalJugadas = 20;
	private Casillero casilleroActual;
	private Dado dado = new Dado();
	private boolean victoria;
	private boolean estadoJuego;
	
	
	public Hormiguero(int cantidadCasilleros)
	{
		this.tablero = new Tablero(cantidadCasilleros);
		this.setCasilleroActual(this.tablero.primerCasillero());
		this.setEstadoJuego(true);
		this.setVictoria(false);
	}
	
	public boolean isVictoria() {
		return victoria;
	}

	public void setVictoria(boolean victoria) {
		this.victoria = victoria;
	}

	public int getCantidadJugadas() {
		return cantidadJugadas;
	}

	public void setCantidadJugadas(int cantidadJugadas) {
		this.cantidadJugadas = cantidadJugadas;
	}

	public int cantJugadas() {
		return cantidadJugadas;
	}
	
	public Casillero getCasilleroActual() {
		return casilleroActual;
	}

	public void setCasilleroActual(Casillero casilleroActual) {
		this.casilleroActual = casilleroActual;
	}
	public void moverHormiga(int i){
		if ((i + this.ultimaCasilla()) > tablero.getCasilleros().size())
		{
			this.setEstadoJuego(false);
		}
		
		if((i + this.ultimaCasilla()) == tablero.getCasilleros().size())
		{
			this.setVictoria(true);
			this.setEstadoJuego(false);
		}
		
		if ((i + this.ultimaCasilla()) <= tablero.getCasilleros().size()) {
			setCasilleroActual(tablero.getCasilleros().get(tablero.getCasilleros().indexOf(casilleroActual) + i));
		}
	}
	
	public int ultimaCasilla (){
		return casilleroActual.getCasilla();
	}
	
	public int lanzarDado(){
		dado.lanzardado();
		return dado.getNumero();
	}

	public void jugar(){
		if ( cantidadJugadas != totalJugadas)
		{
		int valor = lanzarDado();
		System.out.println("Sacaste un " + dado.getNumero());
		
		System.out.print("La hormiga se mueve del casillero " + ultimaCasilla ());
		if(ultimaCasilla() + valor > this.tablero.getCasilleros().size())
		{
			System.out.println(" hasta afuera del hormiguero");
		}
		else 
		{
			System.out.println(" al casillero " + (ultimaCasilla() + valor) );
		}
		moverHormiga(valor);
		if(this.casilleroActual.existeSalto())
		{
			this.casilleroActual = this.tablero.getCasilleros().get(this.casilleroActual.getSalto());
			System.out.println("Se encontro un atajo asi que se va a la casilla " + ultimaCasilla());
		}
		aumentarJugada();
		System.out.println("Tenes " + this.getTotalJugadas() + " tiros y usaste " + cantidadJugadas);
		}
	
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getTotalJugadas() {
		return totalJugadas;
	}

	public void setTotalJugadas(int totalJugadas) {
		this.totalJugadas = totalJugadas;
	}

	public Dado getDado() {
		return dado;
	}

	public void setDado(Dado dado) {
		this.dado = dado;
	}

	public void agregarAtajo(int desde, int hasta)
	{
		if( hasta > tablero.getCasilleros().size() || desde == tablero.getCasilleros().size()) System.out.println("Atajo invalido");
		this.tablero.getCasilleros().get(desde - 1).setSalto(hasta - 1);
	}
	
	public String ver()
	{
		String tablero = " ";
		
		for (int i = 0; i < this.tablero.getCasilleros().size(); i++) 
		{
			if(casilleroActual == this.tablero.getCasilleros().get(i))
			{
				tablero+= "[*]";
			}
			else
			{
				tablero+= "[ ]";
			}
			
		}
		return tablero;
	}
	
	public void aumentarJugada() {
		this.cantidadJugadas++;
	}
	
	public boolean isEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(boolean estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	public String msjResultadoJuego()
	{
		if(this.isVictoria())
		{
			return "Ganaste la partida";
		}
		else return "Perdiste, mejor suerte para la proxima";
	}

}
