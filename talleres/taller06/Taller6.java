

/**
 * Clase en la cual se implementan los metodos del Taller 6
 * 
 * @author Mauricio Toro, Andres Paez
 */

 import java.util.ArrayList;
 
 public class Taller6 {

	/**
	* Metodo que dado un entero n y un conjunto de denominciones de dinero
	* busque la manera optima de dar el cambio
	* @param n cantidad a devolver
	* @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
	* @return un conjunto de unidades por denominacion
	*/
	public static int[] cambioGreedy(int n, int[] denominaciones) {
        int[] devuelta = new int[denominaciones.length];
        int resta = n;
		for (int i = 0; i<denominaciones.length; ++i){
            devuelta[i] = resta / denominaciones[i];
            resta%=denominaciones[i];
        }
        return devuelta;
	}

	/**
	* Metodo que recorre todo el grafo con la intencion de buscar un
	* camino que represente el menor costo pasando por todos los vertices exactamente
	* una vez y vuelva al nodo inicial
	* @param g grafo dado 
	* @return cual es el costo que tiene
	*/
	public static int recorrido(Digraph g) {
        boolean[] register = new boolean[g.size()];
        int cost = 0, vertex = 0;

        while (vertex < g.size()){
            int min = Integer.MAX_VALUE, next;
            ArrayList <Integer> sucessors = g.getSuccessors(vertex);
            register[vertex] = true;
            for (int i: sucessors){
                if (!register[i]){
                    if (g.getWeight(vertex,i) < min){
                        min = g.getWeight(vertex,i);
                        next = i;
                    }
                }
            }
            cost += min;
            vertex = next;
        }
        
        return cost;
	}

}
