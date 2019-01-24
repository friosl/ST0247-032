import java.util.ArrayList;
import javafx.util.Pair;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */

public class DigraphAL extends Digraph {

    ArrayList<LinkedList<Pair<Integer,Integer>>> lista;

    /**
     * Constructor para el grafo dirigido
     * @param size
     *
     */
    public DigraphAL(int size) {
        super(size);
        lista = new ArrayList(size);
        for (int i = 0; i < size; i++)
            lista.add(new LinkedList());
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino  
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        lista.get(source).add(new Pair(destination,weight));
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> sucesores = new ArrayList<>();
        for (int i = 0; i < lista.get(vertex).size(); ++i)
	    sucesores.add(lista.get(vertex).get(i).getKey());
	return sucesores;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */ 
    @Override
    public int getWeight(int source, int destination) {
        for (int i = 0; i < lista.get(source).size(); i++)
            if (lista.get(source).get(i).getKey() == destination)
                return lista.get(source).get(i).getValue();
     	return 0;
    }

}
