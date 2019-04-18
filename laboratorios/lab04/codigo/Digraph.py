class Digraph:

    """
    The implementation we'll do is based on a dictionaries 
    list where each index of this one will be the source vertex
    and the value stored will be a dictionary. For each dictionary,
    keys are destination vertices and values are the weight of the 
    correspodent arc (conection between source and destination).
    """
    
    def __init__(self, size):
    
        """
        Constructor para el grafo dirigido
        :param size: tamaño de la matriz de orden nxn
        """
        #Creamos la lista
        self.__listt = dict()
        self.__size = size
        
        #for i in range(size):
        #Llenamos la lista con diccionarios vacio
        #    self.__listt[i] = dict()
      
    def addArc(self, vertex, edge, weight):
        
        """
        :param vertex: desde donde se hara el arco
        :param edge: hacia donde va el arco
        :param weight: el peso de la longitud entre source y destination
        """
            
        """
        Agregamos una clave valor al diccionario ya existente
        Que sera el inicio y el destino que conforma al arco nuevo
        #see <https://www.programiz.com/python-programming/methods/dictionary/update> ver documentacion de la funcion update
        """
        if not vertex in self.__listt.keys():
            self.__listt[vertex] = dict()
        if not edge in self.__listt.keys():
            self.__listt[edge] = dict()
        
        self.__listt[edge].update({vertex : weight})
        self.__listt[vertex].update({edge : weight})

    def getSuccessors(self, vertice):
        
        """
        param vertex desde donde se hara el arco     
        :return: una lista con las llaves de la lista del diccionario, que vendrian siendo los nodos succesores
        """
        
        return self.__listt[vertice].keys()
    
    def getWeight(self, source, destination):
                  
        """
        :param source: desde donde se inicia el arco
        :param destination: desde donde se hara el arco
        :return: el peso del arco entre el inicio y el destino
        """
        
        return self.__listt[source][destination]


    def size(self):
        """
        :return: Number of vertices the graph has
        """
        return self.__size

    def ids(self):
        """
        :return: a list with the id of every vertex existent in the graph
        """
        
        return self.__listt.keys()

    def __str__(self):

        pass