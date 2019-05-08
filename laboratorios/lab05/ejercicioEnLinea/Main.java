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
    Matrix=new int [Inix][Iniy];
    posKar(Inix,Iniy);
    

    //int cant=Integer.ParseInt;

  }
  public static void posKar(int lengthx,int lengthy){
    Scanner mundo = new Scanner(System.in);
    String kar=mundo.nextLine();
    String Pos[]=kar.split(" ");
    int posx= Integer.parseInt(Pos[0]);
    int posy= Integer.parseInt(Pos[1]);
    Matrix[posx][posy]=1;
    int trash= mundo.nextInt();
    desechos(trash,posx,posy,lengthx,lengthy);
  }

  public static void desechos(int x,int posx, int posy,int lengthx, int lengthy){
    for(int i=0; i< x; ++i){
      System.out.println("Ponga el lugar del desecho");
      Scanner sc = new Scanner(System.in);
      String trash = sc.nextLine();
      String des[]= trash.split(" ");
      int p1= Integer.parseInt(des[0]);
      int p2= Integer.parseInt(des[1]);
      Matrix[p1][p2]=2;
    }
    System.out.println(recoger(posx,posy,lengthx,lengthy));
  }
  public static int sum=0;
  public static int recoger(int p1,int p2,int x,int y){
    int last
    for (int i=0;i<x;++i){
      for(int j=1; j<y;++j){
        if(Matrix[i][j]==2){
          Matrix[i][j]=1;
          sum+=Math.abs(p1-i)+Math.abs(p2-j);
          p1=i;
          p2=j
        }
        else if (last<p1-j) {
          last=p1+p2;
          sum-=last;
        }
      }
    }
    return sum;
  }
}

