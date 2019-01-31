/**
 *
 * @author gzsan
 */
public class Taller2 {

    public static void conjuntoPotencia(String cadena){
        conjuntoPotenciaAux("",cadena);
    }


    private static void conjuntoPotenciaAux(String loqueyallevo, String loquemefalta){
        if (loquemefalta.isEmpty()) 
              System.out.println(loqueyallevo);
        else{
              conjuntoPotenciaAux(loqueyallevo,loquemefalta.substring(1));

              conjuntoPotenciaAux(loqueyallevo+loquemefalta.charAt(0),loquemefalta.substring(1));
        }
    }
    
    public static void permutaciones(String c){
        permutacionesAux("",c);
    }
    
    private static void permutacionesAux(String loquellevo,String loquemefalta){
        if(loquemefalta.isEmpty()){
            System.out.println(loquellevo);
        }
        else{
            for(int i=0;i<loquemefalta.length();++i){
                permutacionesAux(loquellevo+loquemefalta.charAt(i), 
                        loquemefalta.substring(0,i)+loquemefalta.substring(i+1));
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        permutaciones("ABC");
        System.out.println();
        //conjuntoPotencia("ABC");
    }
    
}