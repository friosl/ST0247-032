from sys import maxsize

def shortest(graph, initial, final):
    minimum = [maxsize]
    visiteds = dict()
    shortestAux(graph, initial, final, minimum, visiteds )
    return minimum[0]

def shortestAux(graph, actual, final, minimum, visiteds):
    sucessors = graph.getSuccessors(actual)
    visiteds[actual] = True
    
    if actual == final:
        return 0
    elif len(sucessors) == 0:
        infinite = maxsize
        return infinite
    else:
        for sucessor in sucessors:
            if sucessor == actual or sucessor in visiteds:
                continue
            elif (reachable(graph, sucessor,final)):
                minAux = minimum[0]
                minimum[0] = min([minAux, graph.getWeight(actual, sucessor) + shortestAux(graph, sucessor, final, minimum, visiteds)])
                del visiteds[sucessor]            
    return minimum[0]

def reachable(graph, actual, final):
    sucessors = graph.getSuccessors(actual)
    if (actual == final) or (final in sucessors):
        return True
    
    it_s = False
    for sucessor in sucessors:
        it_s = reachable(graph, sucessor, final)
        if it_s:
            return True
    return False

