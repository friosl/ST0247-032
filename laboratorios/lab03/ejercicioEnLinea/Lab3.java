/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author friosl
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int n=0;
        int m=0;
        
        String arr[]= new String[2];
        do{
        Scanner sc = new Scanner(System.in);
        String nm= sc.nextLine();
        System.out.println("Digite el número de vértices n y  el número de arcos m");
        arr = nm.split(" ");
        Digraph g= new DigraphAM(Integer.parseInt(arr[0]));
        pedirNM(n,m,g);
        
        } while(Integer.parseInt(arr[0])<2||Integer.parseInt(arr[0])>105||Integer.parseInt(arr[1])<0||Integer.parseInt(arr[1])>105);
    }
    public static void pedirNM(int v, int a, Digraph g){
        System.out.println("Ponga los vértices y por último su peso");
        int ultv=0;
        for(int i=0; i<a;i++){
            System.out.println("Arcos en: "+i);
            Scanner sc = new Scanner(System.in);
            String arc = sc.nextLine();
            String av[]=new String[3];
            av = arc.split(" ");
            if(Integer.parseInt(av[0])<1||Integer.parseInt(av[1])<1||Integer.parseInt(av[0])>v||Integer.parseInt(av[1])>v){
                System.out.println("Error");
                i--;
            }
            else{
            g.addArc(Integer.parseInt(av[0]), Integer.parseInt(av[1]), Integer.parseInt(av[2]));
            ultv=Integer.parseInt(av[1]);
            }
        }
        obtenerCaminoE(g,ultv);
        
    }
    
    public static void obtenerCaminoE(Digraph g,int ultv){
        int visitados [] = new int[g.size()];
        int inicial=1;
        ArrayList<Integer> caminobueno = new ArrayList<>();
        caminobueno.add(inicial);
        ArrayList<Integer> entra = new ArrayList<>();
                
        System.out.println(obtenerCamino(g,ultv,inicial,visitados,caminobueno,entra));
        System.out.print(visitados[ultv]);
    }
    
    private static ArrayList obtenerCamino(Digraph g,int ultv,int inicial, int []visitados, ArrayList<Integer> caminobueno, ArrayList<Integer> entra){
        ArrayList<Integer> hijos = g.getSuccessors(inicial);
        if (inicial==ultv){
           entra = new ArrayList<>(caminobueno); 
        }
        /*Para guiarme sobre este ciclo, me basé en el repositorio de:
        https://github.com/msuribec/ST0247-032/blob/master/laboratorios/lab03/ejercicioEnLinea/ShortestPathRecovery.java
        Me faltaba la condición de cuando el camino fuera mayor y el remover cuando entrara.
        */
        for(Integer hijo: hijos){
        int w = g.getWeight(inicial,hijo)+visitados[inicial];
                if(visitados[hijo]>w){
                visitados[hijo]=w;
                caminobueno.add(hijo);
                entra=obtenerCamino(g,ultv,hijo,visitados,caminobueno,entra);
                caminobueno.remove(hijo);
                }
        }
        return entra;
        
    }
}
    
    //Luego: para n y m cantidad de arcos (según el problema) volver a separarlas líneas que entren para saber cuales tienen arco y cual es su peso.
    
