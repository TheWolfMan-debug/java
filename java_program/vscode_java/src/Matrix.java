public class Matrix {
    public static final int M1 = 5;
    public static final int N1 = 4;
    public static final int M2 = 4;
    public static final int N2 = 6;

    public static void main(String[] args) {
        int[][] a = new int[M1][N1];
        int[][] b = new int[M2][N2];

        enterMatrix(a, M1, N1);
        enterMatrix(b, M2, N2);
        enterMatrix(a, M1, N1);
        enterMatrix(b, M2, N2);

        if (true) {
            int[][] c = new int[M1][N2];
            MUlMatrix(a, M1, N1, b, M2, N2, c);
            printMatrix(c, M1, N2);
        }

    }

    public static void enterMatrix(int[][] m, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = (int) Math.round(Math.random() * 10);
            }
        }
    }

    public static void printMatrix(int[][] m, int row, int col) {
        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void MUlMatrix(int[][] a, int row1, int col1, int[][] b, int row2, int col2, int[][] c) {
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                c[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

}