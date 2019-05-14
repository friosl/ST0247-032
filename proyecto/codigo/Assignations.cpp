#include "Digraph.h"
#include "Assignations.h"
#include "ProjectExceptions.h"
#include <iostream>
#include <sstream>
#include <math.h>
using namespace std;

Assignations :: ~Assignations () { }

void Assignations :: execute(int vertices, float increment){
    int initial = 1;
    this->saveRegister(this->assign(this->readFile(vertices,
                                                   increment),
                                    increment, 
                                    initial),
                       increment,
                       vertices);
}

Digraph* Assignations :: readFile(int numVertices, float increment){
    //making file Name
    string fileName = "datasets/dataset-ejemplo-U=" + to_string(numVertices);
    fileName.append("-p="+rmZeros(increment)); //  rmZeros's implemented below
    fileName.append(".txt");

    ifstream file;
    file.open(fileName);
    if (file.is_open()){
        vector<string> *lines = getLines(file);
        Digraph *g  = new Digraph(numVertices);
        while(!(lines->empty())){
            vector<int> data = split(lines->back(), ' ');
            try{
                g->addArc(data[0], data[1], data[2]);
            } catch(...){
                cerr << "Less than 3 data extracted" << endl;
                throw DataError;
            }
            lines->pop_back();
        }
        return g;
    }
    cerr << "File not found" << endl;
    throw FileNotFound;
}

vector<vector<int> >* Assignations :: assign( Digraph* g, float increment, int initial){
    int length = g->getSize();
    vector<vector<int> >* assignedCars = new vector<vector<int> >;
    
    //successors are the same for every vertex due g is complete 
    vector<int> successors;
    for (int c = 2; c <= length; ++c ) successors.push_back(c);
    vector<int> orderedIDs = this->orderedByNearest(g, successors, initial);
    while(! orderedIDs.empty()){
        int driver = orderedIDs.back();
        vector <int> car;
        
        const int timeLimit = (int) (increment * g->getWeight(driver, initial));
        vector<int> nearestTheDriver = this->orderedByNearest(g, orderedIDs, driver);

        for(int candidate: nearestTheDriver){
            if (car.size() == 5) break; // 5 max. number of passengers including the driver
            if (this->canTake(g, car, timeLimit, candidate, initial)){
                car.push_back(candidate);
                this->erase(orderedIDs, candidate);
            }
        }
        assignedCars->push_back(car);
    }
    cout << "For a set U with size = " 
	 << g->getSize()
	 << " and P = "
	 << increment
	 << ", there have been assigned "
	 << assignedCars->size()
	 << " cars."
	 << endl;
    return assignedCars;
}

void Assignations :: saveRegister(vector<vector<int> >* assignedCars, float increment, int people) {
    //Making the fileOut name
    string fileName("output/CarsListFor-U=");
    fileName += to_string(people) + "-p=";
    fileName += rmZeros(increment) + ".txt";

    ofstream out;
    out.open(fileName);
    string out_Line = "ASSIGNED CARS: DRIVER ( PASSENGER)* \n\n";
    
    while(!assignedCars->empty()){
        out_Line += makeLine(assignedCars->back());
        assignedCars->pop_back();
    }
    out << out_Line;
    out.close();
}

vector<int> Assignations :: orderedByNearest(Digraph* g, vector<int> ids, int initial){
    if(ids.empty() or !g->getSize()) {
        cerr << "Couldn't find the farthest vertex due error in parametres"<< endl;
        throw EmptyStructure;
    }
    
    vector<int> orderedIDs;

    while(!ids.empty()){
        int index = 0;
        int min = ids[0];

        for (int i = 0; i < ids.size(); ++i)
            if (g->getWeight(initial, ids[i])
                < g->getWeight(initial, min)){ 
                    min = ids[i];
                    index = i;
            }

        orderedIDs.push_back(min);
        ids[index] = ids.back();
        ids.pop_back();
    }
    return orderedIDs;
}

bool Assignations :: canTake(Digraph *g, vector<int> &car, const int timeLimit, int candidate, int initial){
    if (car.empty()) return true;

    int sum = 0;
    int source = car[0];
    for(int passenger: car){
        sum += g->getWeight(source, passenger);
        source = passenger;
    }
    return timeLimit >= (sum + 
            g->getWeight(source, candidate) +
            g->getWeight(candidate, initial));
}

void Assignations :: erase(vector<int> &orderedIDs, int &readyPassenger){
    const int N = orderedIDs.size();
    if (orderedIDs.empty()) return;

    for(int c=0; c<N; ++c)
        if(orderedIDs[c] == readyPassenger){
            orderedIDs.erase(orderedIDs.begin()+c);
            return;
        }
}

//Implementation of fuctions defined above 
inline string rmZeros(float f) {
    string s = to_string(f);

    if (s.length() <=3) return s;

    while (s[s.length()-1] == '0') s.pop_back();

    return s;
}

inline vector<string>* getLines(ifstream &f){
    if (f.is_open()){
        vector<string> *lines;
        lines = new vector<string>;
        string line("");
        
        while(line.length() == 0 or line[0] != 'C') getline(f, line);
        getline(f, line);

        while(!f.eof()) {
            getline(f, line);
            lines->push_back(line);
        }
        f.close();
        return lines;
    } 
    cerr << "File isn't open" << endl;
    throw FileNotFound;
}

vector<int> split(string &s, char c){
	string buff("");
	vector<int> v;

	for(char n: s) {
		if(n != c) buff += n;
        else if(n == c && buff != "") {
            int x;
            stringstream geek(buff);
            geek >> x;
            v.push_back(x); 
            buff = "";
        }
	}

	if(buff != "") {
        int x;
        stringstream geek(buff);
        geek >> x;
        v.push_back(x);
    }
	return v;
}

inline string makeLine(vector<int> line){
    
    vector<int> invertLine;

    while(!line.empty()){
        invertLine.push_back(line.back());
        line.pop_back();
    }

    string s_line("");

    while(!invertLine.empty()){
        s_line += (" " + to_string(invertLine.back()));
        invertLine.pop_back();
    }
    
    return s_line.substr(1) + "\n";
}
