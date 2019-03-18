from Digraph import *
from Exercise1 import shortest
from nReinas import nReinas
from time import time_ns

if __name__ == "__main__":
    graph = Digraph(6)

    graph.addArc(0,5,1)
    graph.addArc(0,2,4)
    graph.addArc(0,3,2)
    graph.addArc(0,1,20)
    graph.addArc(2,1,30)
    graph.addArc(3,2,1)
    graph.addArc(3,5,400)
    graph.addArc(1,4,15)

    weigth = shortest(graph,0,4)
    print (weigth,"\n")

    initial = time_ns()
    nReinas(4)
    final = time_ns()
    print("tiempo: ", final - initial, " ns")

