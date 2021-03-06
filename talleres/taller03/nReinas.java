/**
 *
 * @author sgilz
 */
public class nReinas {
    private static void imprimirTablero(int [] tablero){
        for (int i = 0; i<tablero.length; ++i)
            System.out.println("("+i+", "+tablero[i]+")");
    }

    private static boolean nReinas(int n, int[] tablero, int c){
        if (c >= n) {
            imprimirTablero(tablero);
            return true;
        } 

        for(int i=0; i<n; ++i){
            tablero[c]=i;
            if(estanSegurasHastaElI(tablero,c)){
                if(nReinas(n, tablero, c + 1)) return true;
                tablero[c]=0;
            }

        }
        return false;
    }
    public static void nReinas(int n){
        nReinas(n,new int[n],0);
    }
    private static boolean estanSegurasHastaElI(int[] tablero, int elI){
        for (int i = 0; i < elI; i++) {
            for (int j = i+1; j <= elI; j++) {
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)) return false;
                else if(tablero[i] == tablero[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        nReinas(4);
    }
}