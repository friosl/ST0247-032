import TravelAgent
from Digraph import *

def main():
    graph = Digraph(4)
    graph.addArc(0,1,23)
    graph.addArc(0,2,82)
    graph.addArc(0,20,8)
    graph.addArc(2,20,92)
    graph.addArc(2,1,2)
    graph.addArc(20,1,18)
    lista = TravelAgent.path(graph,0)

    print (lista)

main()
