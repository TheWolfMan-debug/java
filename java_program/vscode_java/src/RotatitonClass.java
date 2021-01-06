public class RotatitonClass {

    public static final int N = 9;

    public static void main(String[] args) {
        int[][] m = new int[N][N];
        rotating(m, N);
        printSqrareMatrix(m, N);

    }

    public static void rotating(int[][] m, int num) {
        int k = 1;
        for (int i = 0; i < num / 2; i++) {
            for (int j = i; j < num - i; j++) {
                m[i][j] = k++;

            }
            for (int j = i + 1; j < num - i; j++) {
                m[j][num - i - 1] = k++;
            }
            for (int j = num - i - 2; j >= i; j--) {
                m[num - i - 1][j] = k++;
            }
            for (int j = num - i - 2; j > i; j--) {
                m[j][i] = k++;
            }
        }
    }

    public static void printSqrareMatrix(int[][] m, int num) {
        System.out.println();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();

        }
    }

}