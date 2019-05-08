public class HeldKarp {

    public static void main(String [] args){
      Digraph g = new Digraph(5);
      System.out.println(heldKarp(g);
    }

    public static int heldKarp(Digraph g) {
        int tam = g.size();
        int[][] Matrix = new int[tam][(int) Math.pow(2, size - 1)];
        for (int i = 0; i < tam; ++i) {
            Matrix[i][0] = g.getWeight(0, i);
        }
        for (int j=1; j<(int)Math.pow(2, tam - 1);++j) {
            for (int i=1; i < tam; ++i) {
                if (i == j) {
                    Matrix[i][j]=0;
                } else {
                    int last = (j-1)-i;
                    if (j > tam && last > 0 && last < tam) {
                        Matrix[i][j] = 0;
                        Matrix[last][j] = 0;
                    } else 
                    {
                        if (j < tam) {
                            Matrix[i][j] = Matrix[j][0] + g.getWeight(j, i);
                    } else
                    {
                            int tempValue=j-i;
                            int tempValue2=j-tempValue-1;
                            Matrix[i][j] = Math.min(Matrix[tempValue][tempValue2]+g.getWeight(tempValue,i),Matrix[tempValue2][tempValue]+g.getWeight(tempValue2,i));
                        }
                    }
                }
            }
        }
        return Matrix[0][(int) Math.pow(2, tam - 1)];
    }
}
