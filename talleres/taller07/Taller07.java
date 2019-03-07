import java.util.ArrayList;
import java.util.Arrays;

class Taller07{

	// determina el camino mas corto desde inicio a todos los demas
	public int[] dijkstra(Digraph g, int nodoInicio ){
        int[] tabla = infinitos(g.size(), nodoInicio);
        boolean[] visitados = new boolean[g.size()];
        int actual = nodoInicio;

        for(int i = 0; i < g.size(); ++i){
            actual = menorNoVisitado(g, visitados, tabla);
            visitados[actual] = true;
            actualizarTabla(g, actual, tabla);
        }
        return tabla;
	}

    // Llena un arreglo con valores infinitos
    private int[] infinitos(int size, int v){
        int[] a = new int[size];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[v]= 0;
        return a;
    }

    private int menorNoVisitado(Digraph g, boolean[] visitados, int[] tabla){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < g.size; i++) {
            if (tabla[i] < min && !visitados[i]){
                min = tabla[i];
            }
        }
        return min;
    }

    private void actualizarTabla(Digraph g, int actual, int[] tabla){
        if(tabla[actual] != Integer.MAX_VALUE){
          ArrayList<Integer> arr = g.getSuccessor(actual);
          for(int i = 0; i < arr.size(); i++){
            if(actual != i && g.getWeigth(actual,i) != Integer.MAX_VALUE && (g.getWeigth(actual,i)+tabla[actual])<tabla[i]){
              tabla[i] = tabla[actual] + g.getWeigth(actual,i);
            }
          }
        }
    }

	// encuentra el costo total del subconjunto de aristas de costo mínimo que conservan el grafo conectado
	public void prim(Digraph g, int nodoInicio){
        int cost = 0, vertex = nodoInicio;
        boolean[] register = new boolean[g.size()];
        ArrayList<Integer> sucessors;

        while(vertex < g.size()){
            register[vertex] = true;
            sucessors = g.getSuccessors(vertex);
            int min = Integer.MAX_VALUE, next = 0;

            for(int i: sucessors){
                if (!register[i]){
                    if (g.getWeight(vertex,i) < min){
                        min = g.getWeight(vertex,i);
                        next = i;
                    }
                }
            }
            cost += min;
            vertex = next;
            sucessors.clear();
        }
        System.out.println(cost);
	}

}