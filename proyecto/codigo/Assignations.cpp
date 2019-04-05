#include "Digraph.h"
#include "Assignations.h"
#include <fstream>      // ifstream to read files
#include <string>
#include <iostream>
#include <sstream>
using namespace std;

/**some functions We made
(rmZeros, getLines, extractK)*/
inline string rmZeros(float);
inline vector<string>* getLines(ifstream &);
inline string makeLine(vector<int>);
vector<int> extractK(string &s, char c);

Assignations :: ~Assignations () { }

Digraph* Assignations :: readFile(int numVertices, float increment){
    //making file Name
    string fileName = "dataset-ejemplo-U=" + to_string(numVertices);
    fileName.append("-p="+rmZeros(increment)); //  rmZeros in "helper.h"
    fileName.append(".txt");

    ifstream file;
    file.open(fileName);
    if (file.is_open()){
        vector<string> *lines = getLines(file);
        Digraph *g  = new Digraph(numVertices);
        while(!(lines->empty())){
            vector<int> data = extractK(lines->back(), ' ');
            try{
                g->addArc(data[0], data[1], data[2]);
            } catch(...){
                cerr << "Less than 3 data extracted" << endl;
                throw;
            }
            lines->pop_back();
        }
        return g;
    }
    cerr << "File not found" << endl;
    throw;
}

vector<vector<int> >* Assignations :: assign( Digraph* g, float increment){
    return 0;
}

void Assignations :: saveRegister(vector<vector<int> >* assignedCars, float increment, short people) {
    //Making the fileOut name
    string fileName("CarsListFor-U=");
    fileName += to_string(people) + "-p=";
    fileName += rmZeros(increment) + ".txt";

    ofstream out;
    out.open(fileName);
    string out_Line = "ASSIGNED CARS: DRIVER ( PASSENGER i)* \n\n";
    
    while(!assignedCars->empty()){
        out_Line += makeLine(assignedCars->back());
        assignedCars->pop_back();
    }
    out << out_Line;
    out.close();
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
    throw;
}

vector<int> extractK(string &s, char c){
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