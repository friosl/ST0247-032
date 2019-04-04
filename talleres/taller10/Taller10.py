from numpy import zeros

def lcs(x, y):
    """
    Metodo que calcula la longitud de la subsecuencia mas larga en comun entre dos cadenas
    param: x cadena de caracteres
    param: y cadena de caracteres
    see: 
    <a href="https://es.wikipedia.org/wiki/Algoritmo_Knuth-Morris-Pratt">KMP</a>
	see: <a href="https://es.wikipedia.org/wiki/Algoritmo_de_b%C3%BAsqueda_de_cadenas_Boyer-Moore">Boyer Moore y sus variantes</a>
    """
    sizeX = len(x)
    sizeY = len(y)
    laTabla = zeros( (sizeX +1, sizeY +1))
    for i in range(sizeX+1):
        laTabla[i][0] = 0
    for j in range(sizeY+1):
        laTabla[0][j] = 0

    for i in range(1, sizeX+1):
        for j in range(1, sizeY+1):
            if x[i-1] == y[j-1]:
                laTabla[i][j] = laTabla[i-1][j-1] + 1
            else:
                laTabla[i][j] = max([laTabla[i][j-1], laTabla[i-1][j]])
    
    return laTabla[sizeX][sizeY]