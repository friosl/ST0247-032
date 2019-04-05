#pragma once
#include "Digraph.h"

/**
*@see Digraph.h where Digraph implementation is 
*/

class Assignations {
    public:

    /**
    * class destructor
    */
    ~Assignations();

    /**
    * Function that reads a file which contains the graph's data
    * @param number of that the file saves
    * @param time increase allowed to expand every path
    * @return Pointer to a Digraph created with all data found in the file
    */
     Digraph* readFile(int vertices, float incremet);

    /**
    * Function that looks for most convenients partitions of a Digraph
    * @param Pointer to a Digraph
    * @param Maximum time increase allowed for every driver
    * @return List of assigned cars
    */
    vector<vector<int> >* assign( Digraph* g, float incremet);

    /**
    * Procedure that saves every assignation in an out file
    * @param Pointer to the generated list of assigned cars 
    * @param Maximum allowed time
    * @param number of vertices
    */
    void saveRegister(vector<vector<int> >* assinedCars, float increment, short people);

};