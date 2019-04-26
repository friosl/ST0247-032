/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Luis Palacio et al.
 */
public class Taller12 {

    static class Pair<F, S> {

        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

    }

    public static Integer[] hillClimb(int n) {
        Integer [] tablero = new Integer[n];
        Integer [] aux = new Integer[n];
        for (int a=0; a<tablero.length; ++a){
            tablero[a] = 0;
            aux[a] = 0;
        }

        for(int i = 0; i < n; ++i){
            int ataques = reinasAtacandose(tablero);
            if (ataques == 0) return tablero;

            for (int j = 0; j < n; ++j){
                aux[i] = j;

                if(reinasAtacandose(aux) < reinasAtacandose(tablero)){
                    copy(aux,tablero);
                }
            }
        }

        imprimir(tablero);
        return tablero;
    }

    /**
     * Este metodo obtiene el numero de reinas que se atacan en el momento
     */
    public static int reinasAtacandose(Integer[] tablero) {

        int N = tablero.length, ataques = 0;
        for(int i = 0; i < N-1; ++i){
            for(int j = i+1; j < N; ++j){
                if (ataque(tablero[i], tablero[j], i, j)) ++ataques;
            }
        }
        return ataques;
    }

    private static boolean ataque(int cA, int cB, int rA, int rB){
        return rA == rB || cA == cB || Math.abs(rA - rB) == Math.abs(cA - cB); 
    }

    private static void imprimir(Integer[] tablero){
        int N = tablero.length;

        for (int i = 0; i < N; ++i)
                System.out.println("( "+i+" , "+tablero[i]+" )");
    }

    private static void copy(Integer[] tablero, Integer[] aCopy){

        for (int i = 0; i < tablero.length; ++i)
            aCopy[i] = tablero[i];
    }

}