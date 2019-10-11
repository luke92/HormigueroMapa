package hormiguero;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Dado dado = new Dado ();
//		// TODO Auto-generated method stub	
//		for (int i = 0; i < 40; i++) {
//			if(dado.quedanjugadas()){
//			System.out.println("el numero es " + dado.lanzardado());
//			}
//		}
//		System.out.println("tiradas totales =" + dado.getCantidadtiradas());
		Hormiguero h = new Hormiguero (20);
		h.agregarAtajo (9,11);
		h.agregarAtajo(13, 4);
		h.agregarAtajo(3, 7);
		h.agregarAtajo(6, 2);
		while(h.isEstadoJuego())
		{
			
			System.out.println();
			System.out.println("Tirar dado... ");
			System.out.println();
			Entrada.readLine();
			h.jugar();
			System.out.println(h.ver());
			
		}
		
		System.out.println(h.msjResultadoJuego());
			
	}
	


}
