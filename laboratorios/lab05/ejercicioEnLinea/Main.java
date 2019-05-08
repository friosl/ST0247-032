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
    

    //int cant=Integer.ParseInt;

  }
  public static void posKar(){
    Scanner mundo = new Scanner(System.in);
    String kar=mundo.nextLine();
    String Pos[]=kar.split(" ");
    int posx= Integer.parseInt(Pos[0]);
    int posy= Integer.parseInt(Pos[1]);
    Matrix[posx][posy]=1;
    int trash= mundo.nextInt();
    desechos(trash,posx,posy);
  }

  public static void desechos(int x,int posx, int posy){
    for(int i=0; i< x; +i){
      System.out.println("Ponga el lugar del desecho");
      Scanner trash = new Scanner(System.in);
      String des[]= trash.split(" ");
      int p1= Integer.parseInt(des[0]);
      int p2= Integer.parseInt(des[1]);
      Matrix[p1][p2]=2;
    }
    System.out.println(recoger(posx,posy));
  }
  public int sum=0;
  public static int recoger(int p1,int p2){
    for (int i=0;i<p1;++i){
      for(int j=1; j<p2;++i){
        if(Matrix[i][j]=2){
          Matrix[i][j]=1;
          sum=Math.Abs(p1-i)+Math.Abs(p2-j);
        }
      }
    }
    return sum;
  }

