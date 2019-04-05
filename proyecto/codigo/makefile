all: carsMobility

carsMobility: Assignations.o main.o Digraph.o
    $(CXX) -o $@ $^ -Wall

Assignations.o: Assignations.cpp Assignations.h Digraph.h

main.o: main.cpp Assignations.h Digraph.h

Digraph.o: Digraph.cpp Digraph.h

clean:
    rm *.o *.exe *.*~