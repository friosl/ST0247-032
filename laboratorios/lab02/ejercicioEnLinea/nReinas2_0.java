import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class nReinas2_0 {
    public static void readFile(String name){
        String line;
        ArrayList<Pair<Integer,Integer>> rests = new ArrayList<>();

        try{
            FileReader file = new FileReader(name);
            BufferedReader buffer = new BufferedReader(file);
            line = buffer.readLine();
            //number of queens on the board
            int n = Integer.parseInt(line);
            while(n  != 0){
                line = buffer.readLine();
                while(line.charAt(0) =='.' ||  line.charAt(0) =='*') {
                    for(int i = 0; i< n; ++i){ 
                        for(int j = 0; j < n; ++j)
                            if(line.charAt(j) == '*')
                                rests.add(Pair.makePair(i,j));
                        line = buffer.readLine();
                    }
                }
                System.out.println("Número de sols para " + n +" reinas: ");
                nReinas(n, rests);
                n = Integer.parseInt(line);
            }

        file.close();
        buffer.close();

        } catch (IOException e){
            System.out.println("There was a problem to read: " +name);
        }
        


    }
    private static void imprimirTablero(int [] tablero){
        for (int i = 0; i<tablero.length; ++i)
            System.out.println("("+i+", "+tablero[i]+")");
    }

    public static void nReinas(int n, ArrayList<Pair<Integer,Integer>> rests){
        Integer[] sols = {0};
        nReinas(n,new int[n],0,sols, rests);
        System.out.println(sols[0]);
    }

    private static void nReinas(int n, int[] tablero, int c, Integer[] sols, ArrayList<Pair<Integer,Integer>> rests){
        if (c >= n) {
            //imprimirTablero(tablero);
            sols[0]++;
        } else{
            for(int i=0; i<n; ++i){
                tablero[c]=i;
                if(estanSegurasHastaElI(tablero,c,rests)){
                    nReinas(n, tablero, c + 1, sols, rests);
                    tablero[c]=0;
                }

            }
        }
    }
    
    private static boolean estanSegurasHastaElI(int[] board, int elI, ArrayList<Pair<Integer,Integer>> rests){
        for (int i = 0; i < elI; i++) {
            //looks for a hole in the list of restrictions
            for (Pair<Integer,Integer> a : rests)
                if ( (int)a.first == board[elI])
                    if ((int)a.second == elI)
                        return false;

            for (int j = i+1; j <= elI; j++) {
                if (Math.abs(board[i] - board[j]) == Math.abs(i-j)) return false;
                else if(board[i] == board[j]) return false;
            }
        }
        return true;
    }
}