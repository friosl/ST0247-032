package lab02;

import java.util.ArrayList;
/**
 *
 * @author friosl, sgilz
 */
Public class lab 2 {
   
   public static void main(String [] args){
   int i=0;
   int f=0;
   
   //if(costoMinE(g,i,f)){
        System.out.println("There is a path)";
    }
    else
    {
    System.out.println("There is no path");
    }
   }
   
   public static boolean costoMinE(Digraph g, int i, int f){
        boolean visitados  [] = new boolean[g.size()];
        return costoMinEAux(g,i,f,visitados);
    }
    private static boolean costoMinEAux(Digraph g, int i, int f, boolean [] visitados){
        visitados[i]=true;
        ArrayList<Integer> hijos = g.getSuccessors(i);
        for(Integer hijo: hijos){
            if (!visitados[hijo]){
                boolean costoEuler = costoMinEAux(g,hijo,i,visitados);
                if(visitados[hijo]==visitados[0]){
                    return true;
                }
            }
        }
        return false;
    }
}
