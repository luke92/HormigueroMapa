package laOdisea;

import java.util.ArrayList;

public class Test{
	public static void main(String[] args) {
		Mapa m1 = new Mapa(8);
		m1.asignarNombre(0,"Troya");
		m1.asignarNombre(1,"Otra1");
		m1.asignarNombre(2,"Otra2");
		m1.asignarNombre(3,"Otra3");
		m1.asignarNombre(4,"Otra4");
		m1.asignarNombre(5,"Otra5");
		m1.asignarNombre(6,"Otra6");
		m1.asignarNombre(7,"Itaca");

		
		
		
		

		m1.agDist(0,1,10,true);
		m1.agDist(0,2,20,true);
		m1.agDist(0,3,5,true);
		m1.agDist(0,4,30,true);
		m1.agDist(0,5,70,true);
		m1.agDist(0,6,72,true);
		m1.agDist(0,7,900,true);
		
		m1.agDist(1,2,10,true);
		m1.agDist(1,3,20,true);
		m1.agDist(1,4,25,true);
		m1.agDist(1,5,30,true);
		m1.agDist(1,6,30,true);
		m1.agDist(1,7,800,true);
		

		m1.agDist(2,3,20,true);
		m1.agDist(2,4,2,true);
		m1.agDist(2,5,1,true);
		m1.agDist(2,6,40,true);
		m1.agDist(2,7,600,true);
		

		m1.agDist(3,4,2,true);
		m1.agDist(3,5,40,true);
		m1.agDist(3,6,50,true);
		m1.agDist(3,7,500,true);
		

		m1.agDist(4,5,20,true);
		m1.agDist(4,6,30,true);
		m1.agDist(4,7,400,true);
		

		m1.agDist(5,6,40,true);
		m1.agDist(5,7,2,true);
				
		m1.agDist(6,7,300,true);
		
		ArrayList <Ciudad> camino = m1.caminoMinimoProbable(0,7); 
		
		System.out.println("camino minimo probable= " + m1.imprimeCamino(camino));
		System.out.println("distancia= " + m1.distancia(camino));
		
	}
}

