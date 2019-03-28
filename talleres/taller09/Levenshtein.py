import numpy as np

def levenshtein(s, t):  
    m = len(s) + 1
    n = len(t) + 1
    d = np.zeros ((m, n))
    for i in range(m):
        d [i, 0] = i
    for j in range(n):
        d [0, j] = j

    for i in range(1, m):
        for j in range(1, n):
            if s[i-1] == t[j-1]:
                d [i,j] = d [i - 1, j - 1]
            else:
                d [i,j] = min(
                    d[i-1,j] + 1,
                    d[i-1,j-1] + 1,
                    d[i,j-1] + 1
                )
    print (d)
    return (d[m - 1, n - 1])