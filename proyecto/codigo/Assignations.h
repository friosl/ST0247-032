#pragma once
#include "Digraph.h"
#include <string>
#include <fstream>      // To read or write files

/**
*@see Digraph.h where Digraph implementation is 
*/


/**some functions We made
(rmZeros, getLines, split, orderedByNearest, canTake)*/

/**
* function that takes a float removes zeros after last digit
* @param : number float to convert
* @return : the parameter with out zeros at the end, converted to string
*/
inline string rmZeros(float);

/**
* function that extracts every line for the graph
* @param: input file where the data are. 
* @return: a list with every line to get the graph's data
*/
inline vector<string>* getLines(ifstream &);

/**
* function that prepare a list to be printed
* @param: a int list containing the line of numbers
* @return: a string of numbers separated by spaces
*/
inline string makeLine(vector<int>);

/**
* modification of an standar split to extract every number present on a line
* @param s: line with numbers
* @param c: character separator
*/
vector<int> split(string &s, char c);

class Assignations {
    public:

    /**
    * class destructor
    */
    ~Assignations();

    /**
    * Method that makes the program execution
    * @param number of that the file saves
    * @param time increase allowed to expand every path
    */
    void execute(int vertices, float increment);
    
    private:

    /**
    * Function that reads a file which contains the graph's data
    * @param number of that the file saves
    * @param time increase allowed to expand every path
    * @return Pointer to a Digraph created with all data found in the file
    */
    Digraph* readFile(int vertices, float incremet);

    /**
    * Function that looks for most convenients partitions of a Digraph
    * @param g: Pointer to a Digraph
    * @param increment: Maximum time increase allowed for every driver
    * @param initial: company's id
    * @return List of assigned cars
    */
    vector<vector<int> >* assign( Digraph* g, float increment, int initial);

    /**
    * Procedure that saves every assignation in an out file
    * @param Pointer to the generated list of assigned cars 
    * @param Maximum allowed time
    * @param number of vertices
    */
    void saveRegister(vector<vector<int> >* assinedCars, float increment, int people);

    /**
    * function that order a list of successor by the weight between each one and the head
    * @param g: Pointer to the structure where the info is.
    * @param ids: the list of ids to order
    * @param initial: the head
    * @return: successors ordered by nearest initial vertex
    */
    vector<int> orderedByNearest(Digraph* g, vector<int> ids, int initial);

    /**
    * function that evaluates if a candidate vertex can be taken in a car
    * @param g: Pointer to the structure where the info is.
    * @param car: list of people when the candidate may be stored
    * @param timeLimit: Maximum time allowed for the path
    * @param candidate: vertex in process of including to the car
    * @param initial: main vertex where the path finishes
    * @return: boolean value for the candidate after several conditions
    */
    bool canTake(Digraph *g, vector<int> &car, const int timeLimit, int candidate, int initial);

    /**
    * Method that eliminates an ID if it's alredy in a car
    * @param orderedIDs: list of ordered IDs with out assigned car
    * @param readyPassenger: passenger that is now in a car
    */
    void erase(vector<int> &orderedIDs, int &readyPassenger);
};