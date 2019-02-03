

class MedellinGraph:
    
    def __init__(self, fileName):
        """
        The class constructor's going to read the file which contains data and initializes
        the attributes.
        Constructor also calls some private methods the class needs 
        :param fileName: It receives the name of the file that we will read 
        
        """
        file = open(fileName,"r")
        self.lines = file.readlines()
        self.nodes = []
        self.edges = []
        self.adjacents = dict()
        self.__extracNodes()
        self.addArcs()

    def getNodes(self):
        """
        This method return a list with the vertexs
        """
        return self.nodes

    def __extracNodes(self):
    	for i in range(1,310154):
    		self.nodes.append(int(self.lines[i].split(" ")[0]))

    def addArcs(self):
        """
        In this method we fill the labeled-adjacent lists. Moreover, we store the edges found.
        """
        source, destination, weight = 0,0,0
        for i in range(310157,len(self.lines)):
            line = self.lines[i].split(" ")
            source = int(line[0]); destination = int(line[1]); weight = float(line[2])
            self.edges.append([source,destination,weight])
            if source in self.adjacents:
                self.adjacents[source][destination] = weight
            else:
                self.adjacents[source] = {destination : weight}

    def getDistance(self, source, destination):
        """
        Given two vertex (source and destination) this method returns distance between both  
        :parm source: It's the vertex of the beginning
        :parm destination: It's the vertex of the end
        :ruturn: the distance stored by the keys [source][destination] 
        """
        return self.adjacents[source][destination]

    def getSuccessors(self, vertex):
        """
        Given a vertex, this method returns the adjacent vertexs, it means, the keys
        of the dictionary returned by the other one in position [vertex]
        :parm vertex: It's the main key in my dictionary, where the values are all the adjacent vertexs 
        """
        return self.adjacents[vertex].keys()

    def getEdges(self):
        """
        It returns all conexions between the grph vertexs
        :return: attribute 'edges' wich contains all conexions (vertex vertex)
        """
        return self.edges

if __name__ == "__main__":
    medellin = MedellinGraph("medellin_colombia-grande.txt")
    
