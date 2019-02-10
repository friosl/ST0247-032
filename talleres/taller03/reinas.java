/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3remastered;
import java.util.Scanner;
/**
 *
 * @author felip, sgilz
 */
public class Taller3remastered {
public static int contador=0;
    private static void imprimirTablero(int [] tablero){
        for (int i = 0; i<tablero.length; ++i)
            System.out.println("("+i+", "+tablero[i]+")");
                }
    private static boolean nReinas(int n, int[] tablero, int c){
        if (c >= n) {
            imprimirTablero(tablero);
            return true;
        }
        else if(false && contador <=3){
            contador=contador++;
            if (contador==4) contador = 0;
            tablero[c-1]=contador;
           
        }else {
            for(int i=0; i<n; ++i){
                if(estanSegurasHastaElI(tablero,c)){
                    tablero[c]=i;
                    if(nReinas(n, tablero, c + 1)) return true;
                }
            }
            if (false){
                            nReinas(n,tablero,c-1);
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
                System.out.println("Evaluo: " +"("+i+tablero[i] +")"+"("+j+tablero[j] +")" );
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)) return false;
                else if(tablero[i] == tablero[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        //nReinas(4);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de reinas");
        int n = sc.nextInt();
        nReinas(n);
        //int[] p = {1,3,0,2};
        //estanSegurasHastaElI(p,3);
    }
}
