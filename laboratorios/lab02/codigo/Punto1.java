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
   int tot=0;
   int[] a= new int [g.size()];
     /* for(int h=0; h < g.size();h++){
              a[h]= costoMinE(g,i,f,tot);
               tot=0;
                }
             else{
              System.out.println("There is no path");
              tot=0;
                 }
    }*/
      for (int b=0; b < a.size(); b++){
         if(a[b]<a[b+1]){
            tot= a[b];
         }
      }
   }
   
   public static int costoMinE(Digraph g, int i, int f,int tot){
        boolean visitados  [] = new boolean[g.size()];
        return costoMinEAux(g,i,f,visitados,tot);
    }
    private static int costoMinEAux(Digraph g, int i, int f, boolean [] visitados,int tot){
        visitados[i]=true;
        ArrayList<Integer> hijos = g.getSuccessors(i);
        for(Integer hijo: hijos){
            if (!visitados[hijo]){
                boolean costoEuler = costoMinEAux(g,hijo,i,visitados);
                if(visitados[hijo]==visitados[0]){
                    return tot += g.getWeight(i,f);
                }
            }
        }
        return 100000000;
    }
}
