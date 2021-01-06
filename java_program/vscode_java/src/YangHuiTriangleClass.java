public class YangHuiTriangleClass {

    public static final int N = 10;

    public static void main(String[] args) {

        

        int[][] data = new int[N][];
        for (int i = 0; i < N; i++) {
            data[i] = new int[i + 1];
        }
        data[0][0] = 1;

        for (int i = 0; i < N; i++) {
            data[i][0] = 1;
            for (int j = 1; j < i; j++) {
                data[i][j] = data[i - 1][j - 1] + data[i - 1][j];
            }
            data[i][i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", data[i][j]);
            }
            System.out.println();
        }

        // MyInter mi = new MyInter();

        // mi.setN(3);
        // System.out.println(mi.getN());

    }

}


// class MyInter {

//     private int n;

//     public void setN(int n) {
//         this.n = n;
//     }

//     public int getN() {
//         return this.n;
//     }

// }