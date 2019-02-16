/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;
import java.util.ArrayList;
/**
 *
 * @author felip, sgilz
 */
public class Taller4 {
    //Punto3
    
    public static int Euler(Digraph g, int i, int f) {
        return costoMinE(g,i,f);
        
    }
    public static int costoMinE(Digraph g, int i, int f){
        boolean visitados  [] = new boolean[g.size()];
        return costoMinEAux(g,i,f,visitados);
    }
    private static int costoMinEAux(Digraph g, int i, int f, boolean [] visitados){
        visitados[i]=true;
        for(int a=0;i<visitados.length;a++){
            if(visitados[a]==false){
                break;
            }
            else{
                return tot += g.getWeight(i,f);}
        }
        ArrayList<Integer> hijos = g.getSuccessors(i);
        for(Integer hijo: hijos){
            if (!visitados[hijo]){
                int costoEuler = costoMinEAux(g,hijo,i,visitados);
                if(visitados[hijo]==visitados[0]){
                    return tot;
                }
            }
        }
        return tot;
    }
    
    //Punto 2
    
    public static  int costoMin(Digraph g, int o, int d){
        boolean visitados [] = new boolean[g.size()];
        return costoMinAux(g, o, d, visitados);
    }
    public static int tot=0;
    private static int costoMinAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d){
           return tot;}
        else {
            ArrayList<Integer> hijos = g.getSuccessors(o);      
            int costoMinimo = Integer.MAX_VALUE;
            for (Integer hijo: hijos){
                if (!visitados[hijo]){
                    int costoCamino = costoMinAux(g, hijo, d, visitados);
                    return tot = g.getWeight(o, d)+costoCamino;}
            }      
        } 
        //Si no hay un camino hasta allá, retornar 0
        return 0;
    }
    
    //Punto 1
    public static  boolean hayCamino(Digraph g, int o, int d){
       boolean visitados[] = new boolean[g.size()];    
       return hayCaminoAux(g, o, d, visitados);
    }

    private static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d)
           return true;
        else {
           ArrayList<Integer> hijos = g.getSuccessors(o);          
              for (Integer hijo: hijos){
                if (!visitados[hijo] && hayCaminoAux(g, hijo, d, visitados))
                   return true;
              return false;
             }      
        }
    return true;
    }
    
     public static void main(String []args){
       //Casos de prueba
     }
}
