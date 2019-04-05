#pragma once
#include <vector>
using namespace std;
/**
 * header for implementations of Digraphs
 * 
 * @author Santiago GZ, Felipe Rios 
 * @version 1
 */
class Digraph {
    public: 
   /**
    * Constructor of Graph
    * @param number of vertices
    */
   Digraph(int);

    /**
    * Constructor of Graph
    */
   ~Digraph();

   /**
    * Method that adds an arc between two vertices
    * @param source vertex 
    * @param destination vertex
    * @param weight of their arc
    */
   void addArc(int, int, int);
   /**
    * Metodo que retorna el un vector con el numero de todos los vertices que tengan una conexion
    * con uno
    * @param vertex to get its successors
    * @return a list with the vertices successors of the parameter
    */
   vector<int> getSuccessors(int);

   /**
    * Method that returns the weight of an arc between two vertices
    * @param vertex source
    * @param vertex destination
    * @return weight of the arc between two vertices (put in parameters)
    */
   int getWeight(int source, int destination);

   /**
    * Method that returns the Graph's size
    */
   int getSize() const;

    private:

    //Graph size
    int unsigned const size;

    //adjacence matrix
    vector<vector<int>> matrix;
};