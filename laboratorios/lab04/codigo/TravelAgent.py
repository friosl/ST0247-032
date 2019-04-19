
def path (g, initial):
    """
    Method to search the best route in a circuit

    :param g: an instance of Digraph to do the searching
    :param initial: the initial vertex, where the search will begin
    :return: A list with the order of vertices 
    to visit being initial the first and the final vertex
    """
    bestRoute = []
    visiteds = dict()
    for i in g.ids():
        visiteds[i] = False

    bestRoute.append(initial)

    vertex = initial
    while (not __everyVisited(visiteds)):
        
        visiteds[vertex] = True
        successors = g.getSuccessors(vertex)
        minimum = None
        for i in successors:
            if not visiteds[i]:
                minimum = i
        
        if minimum == None:
            break;
        
        try:
            for successor in successors:
                if ( (not visiteds[successor]) and  g.getWeight(vertex, minimum) > g.getWeight(vertex, successor)):
                    minimum = successor
        except:
            print("An error has ocurred")
        
        if not minimum in bestRoute:
            bestRoute.append(minimum)

        vertex = minimum

    bestRoute.append(initial)
    return bestRoute

def __everyVisited(visiteds):
    for v in visiteds.keys():
        if not visiteds[v]:
            return False
    return True
