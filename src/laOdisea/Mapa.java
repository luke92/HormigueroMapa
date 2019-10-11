package laOdisea;


import java.util.ArrayList;

public class Mapa {
	private Ciudad [] ciudades;
	private int [][] ady;
	private int n;
	
	public Mapa(int longitud){
		n= longitud;
		ciudades = new Ciudad [n];
		ady = new int [n][n];
		for (int i=0; i<n; i++){
			ciudades [i] = new Ciudad(i,"Ciudad" + i);
			for (int j=0; j<n; j++){
			ady[i][j] = 0;
			//distancias default en 0
			}
		}
	}

	

	public void asignarNombre(Integer IDciudad, String nomb){
		ciudades[IDciudad].Nombre = nomb;
	}
	
	
	
	public void agDist(int i, int j, int dist, boolean simetrico){
		ady[i][j] = dist;
		if (simetrico){
			ady[j][i] = dist;
		}
	}
	// distancia en tiempos nominales
	
	public int dist(int i, int j){ // si es adyacente tomamos ady[i][j]
		return ady[i][j];
	}

	public ArrayList<Ciudad> caminoMinimoProbable (int ciudadOrigen, int ciudadDestino){ 
		ArrayList<Ciudad> ret = new ArrayList<Ciudad> ();
		
		int auxAdy[][] = guardaDistancias(ady);
		int ciudadActual= ciudadOrigen;
		ret.add(ciudades[ciudadOrigen]);
		
		
		if (distanciasIguales(ady[ciudadOrigen],ciudadOrigen) || !hayDistancia(ady,ciudadOrigen,ciudadDestino)){
			System.out.println("distancia principio a fin = " + hayDistancia(ady,ciudadOrigen,ciudadDestino));
			System.out.println("todas distancias iguales = " + distanciasIguales(ady[ciudadOrigen],ciudadOrigen));
			ret.add(ciudades[ciudadDestino]);			
			System.out.println("cantida de elementos = " + ret.size());
			return ret;
		}
	
		else{
			
		while ( !ret.contains (ciudades[ciudadDestino])){
			
			//System.out.println("contiene ciudad destino = " + ret.contains (ciudades[ciudadDestino]));
			//System.out.println("hay distancia entre ciudad actual y destino = " + hayDistancia(ady,ciudadActual,ciudadDestino));
			if (!hayDistancia(ady,ciudadActual,ciudadDestino)){;
				ret.add (ciudades[ciudadDestino]);
				ady = guardaDistancias(auxAdy);
				return ret;
			}
			
			else{
				
				System.out.println("posicion = " + ciudadActual + " ciudad prox = " + ciudadMasProxima(ady[ciudadActual],ciudadActual,ciudadDestino));
				//System.out.println("DISTANCIA ENTRE CIUDAD Y PROXIMA = " + dist() ) ;
				int ciudadProxima = ciudadMasProxima(ady[ciudadActual],ciudadActual,ciudadDestino);
			
				
				
			ady = anulaDistancia (ady, ciudadActual, ciudadProxima);
			
			
			
			ciudadActual = ciudadProxima;
			if (ciudades[ciudadActual] == ciudades[ciudadDestino]){
				System.out.println("ciudad actual es igual a ciudad destino");
				ret.add (ciudades[ciudadDestino]);
				
				
			}
			else{
			ret.add (ciudades[ciudadActual]);
			}
			
			
			}
			System.out.println("contiene ciudad destino = " + ret.contains (ciudades[ciudadDestino]));

		}
		
		
		}

		ady = guardaDistancias(auxAdy);
		
		return ret;
	}

	static boolean distanciasIguales (int [] distancias, int miPos){
		boolean igualdad = true;
		int patron = 0;
		if (miPos != 0){
			patron = distancias [0];
		}
		else{
			patron = distancias [1];
		}				
		for (int i = 0; i < distancias.length; i++){
			if (i!=miPos){
			igualdad = igualdad && distancias[i] == patron;
			}
		}
		return igualdad;
	}

	public boolean hayDistancia (int [][]distancias, int ciudad1,int ciudad2){
		return distancias[ciudad1][ciudad2] != 0;
	}
	
	public static int ciudadMasProxima ( int [] distancias, int miPos,int miDest){
		int menor = 0;
		int posMenor = 0;
		int i = 0;
		
		if ((miPos != 0) && (distancias [0] != -1)){
			menor = distancias [0];
		}
		else{
			while (i< distancias.length){				
			if (distancias[i] != -1 && i != miPos){
			menor = distancias [i];
			posMenor=i;
			break;			
			}

			i ++;
		}
		}
		
		for (int a = 0; a<distancias.length;a++){
			if (a != miPos){
				if (distancias[a] != -1){
					if (distancias[a] < menor){
						menor = distancias[a];

						posMenor = a;
					}
				}
			}
			
		}
		
		if ( distancias[posMenor] == distancias [miDest]){
			return miDest;
		}
		else{

		return posMenor;
		}
	}
		
	
		 
	static int [][] anulaDistancia (int [][] distancias, int ciudad1, int ciudad2){
		
		if (distancias[ciudad1][ciudad2] == distancias[ciudad2][ciudad1]){
			distancias[ciudad1][ciudad2]= -1;
			distancias[ciudad2][ciudad1]= -1;
		}
		else{
			distancias[ciudad1][ciudad2]=-1;
		}
		
		return distancias;
	}


	public int distancia (ArrayList <Ciudad> camino){
	
		int i=0;
		int distancia = 0;
		while (i < camino.size()-1){
			distancia = distancia + dist(camino.get(i).id,camino.get(i+1).id);
			i++;
			}
		return distancia;
	}	



	public String imprimeCamino (ArrayList <Ciudad> camino){
		String recorrido ="";
		int i=0;
		while ( i < camino.size()){
			recorrido = recorrido + camino.get(i).toString();
			i++;
			}
		return recorrido;
	}	
	
	public static int[][] guardaDistancias(int [][] distancias){
		int [][] guarda = new int[distancias.length][distancias.length];
		
		for (int i=0; i<distancias.length; i++){
			for (int j=0; j<distancias.length; j++){
				guarda[i][j] = distancias[i][j];
			}
		
		
		}
		return guarda;
	}
}

	
