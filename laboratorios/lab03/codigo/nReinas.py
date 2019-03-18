import numpy as np
from math import fabs

def imprimirTablero(tablero):
    for i in range(len(tablero)):
        print("(",i,", ",tablero[i],")")

def __nReinas(n, tablero, c):
    if c >= n:
        imprimirTablero(tablero)
        return True

    for i in range(n):
        tablero[c] = i
        if __estanSegurasHastaElI(tablero,c):
            if __nReinas(n, tablero, c+1):
                return True
            tablero[c] = 0
    return False

def nReinas(n):
    __nReinas(n, list(np.zeros(n, dtype=np.int)) ,0)

def __estanSegurasHastaElI(tablero, elI):
    for i in range(elI):
        for j in range(i+1,elI+1):
            if fabs(tablero[i] - tablero[j]) == fabs(i-j):
                return False
            elif tablero[i] == tablero[j]:
                return False
    return True
