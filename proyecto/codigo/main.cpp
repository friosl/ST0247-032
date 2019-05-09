#include "Assignations.h"
#include "Digraph.h"
#include "ProjectExceptions.h"
#include <string>
#include <iostream>
#include <sstream> //to convert to format
#include <cstdlib> //to use EXIT_SUCCESS const
#include <unistd.h> //to manage options in the arguments

void usage(const char *progName);

int main(int argc, char *argv[]) {
    if(argc != 5) {
        usage(argv[0]);
        throw UnrecognizedOption;
    }

    Assignations a = Assignations();
    float increment;
    string arg("");
    int option, numberOfVertices;
    while ((option = getopt(argc, argv, "n:p:"))!= -1){
        switch(option){
            case 'n':
                try{
                    istringstream ss(optarg);
                    ss >> numberOfVertices;
                }catch(...){
                    cerr << "Error with parameter n" 
                         << endl;
                    throw MissingArguments;
                }
                break;

            case 'p':
                try{
                    istringstream ss(optarg);
                    ss >> increment;
                }catch(...){
                    cerr << "Error with parameter p" 
                         << endl;
                    throw MissingArguments;     
                }
                break;  
                
            case ':':
                cerr << "Options need values" 
                     << endl;
                usage(argv[0]);
                throw MissingArguments;
                break;

            case '?':
                cerr << "Unrecognized option." << endl;
                usage(argv[0]);
                throw UnrecognizedOption;
                break;
        }
    }
    
    //Assignations a = Assignations();
    a.execute(numberOfVertices, increment);
    return EXIT_SUCCESS;
}

void usage(const char *progName){
    cerr << "Usage: "<< *progName << " -n <vertices> -p <increment>"
         << endl;
}
