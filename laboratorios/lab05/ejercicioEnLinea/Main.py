//Lo de repl
import java.util.Scanner;
class Main {
  public static int Matrix[][];
  public static void main(String[] args) {
    Scanner numsc= new Scanner(System.in);
    int num1= numsc.nextInt();
    for(int i=0; i<num1;++i){
    mundo();
    }
  }
  public static void mundo(){    
    Scanner mundo = new Scanner(System.in);
    String tam=mundo.nextLine();
    String Part[]= tam.split(" ");
    int Inix=Integer.parseInt(Part[0]);
    int Iniy=Integer.parseInt(Part[1]);
    Matrix=new Int [Inix][Iniy];
    posKar();
    int trash= mundo.nextInt();
    desechos(trash);

    int cant=Integer.ParseInt;

  }
  public static void posKar(){
    Scanner mundo = new Scanner(System.in);
    String kar=mundo.nextLine();
    String Pos[]=kar.split(" ");
    int posx= Integer.parseInt(Pos[0]);
    int posy= Integer.parseInt(Pos[1]);
  }

  public static void desechos(int x){
    for (int i=0;i<x;++i){
      for(int j=1; j<x;++i){
        Matrix[i][j]=0;
      }
    }
  }
}
