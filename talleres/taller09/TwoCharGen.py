class TwoCharGen:
    def __init__(self):
        a="abcde"
        b="cde"
        array= []
        self.genoma(self,a,b,array)
    def genoma(self, a, b,array):
        iteraciones = 0
        cad = ""
        larga=0
        aux=""
        for i in a: 
            iteraciones=0
                for j in b:
                    if a[i]==b[j]:
                        aux=aux+a[i]
                        iteraciones+=1
                        i+=1
                    else:
                        array.append(aux)
                        aux=""
                        i=i-iteraciones
        for c in range(len(array)):
            if len(arr[c])>larga:
                larga=len(arr[c])
                cad = arr[c]
        return cad
n = TwoCharGen()