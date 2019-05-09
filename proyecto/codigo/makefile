
carsMobility: main.o Assignations.o Digraph.o
	$(CXX) -o $@ $^ -Wall

Digraph.o: Digraph.cpp Digraph.h ProjectExceptions.h

Assignations.o: Assignations.cpp Assignations.h Digraph.h ProjectExceptions.h

main.o: main.cpp Assignations.h Digraph.h ProjectExceptions.h

clean:
	rm *.o *.exe *~ CarsListFor*
