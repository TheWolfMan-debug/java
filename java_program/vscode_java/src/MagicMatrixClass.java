public class MagicMatrixClass {
    public static final int N = 5;
    
    public static void main(String[] args) {

        int m[][] = new int[N][N];
        int i,j,number;

        i = 0;
        j = N/2;
        m[i][j] = 1;
        for(number = 0; number<=N*N;number++) {
            if(m[(i-1+N)%N][(j+1)%N]==0)
            {
                i = (i-1+N)%N;
                j = (j+1)%N;
            }
            else
            {
                i = (i+1)%N;
            }
            m[i][j] = number;
        }

        for(i = 0; i<N; i++){
            for(j = 0; j<N; j++)
            {
                System.out.printf("%8d",m[i][j]);
            }
            System.out.println();
        }
    }
    
}