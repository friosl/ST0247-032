#include "Digraph.h"
#include "ProjectExceptions.h"
#include <iostream>

Digraph :: Digraph(int size) : 
size(size) { 
    matrix.resize(size);
    
    for (int c = 0; c < matrix.size(); c++)
        matrix[c].resize(size);
}

Digraph :: ~Digraph() {
    for (vector<int> aVector: matrix){
        aVector.clear();
    }
    matrix.clear();
    delete this;
 }

void Digraph :: addArc(int source, int destination, int weight) {
    try{
        matrix[(source-1)][(destination-1)] = weight;
    } catch (...){
        std :: cerr << "Can't add Arc" << endl;
        throw IndexError;
    }
}

vector<int> Digraph :: getSuccessors(int vertex) {
    vector<int> successors;
    
    for(int i = 0;i < size;i++)         
        if(matrix[vertex-1][i] != 0)
            successors.push_back(i+1);
            
    return successors;
}

int Digraph :: getWeight(int source, int destination){
    return matrix[source-1][destination-1];
}

int Digraph :: getSize() const { return size; }
