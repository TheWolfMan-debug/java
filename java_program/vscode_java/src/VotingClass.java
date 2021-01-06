import java.util.*;

public class VotingClass {

    public static final int N = 5;

    public static void main(String[] args) {
        int[] v = new int[N];
        enterVotes(v);
        printVotes(v);
        System.out.println("Winner is " + statistics(v));
    }

    public static void enterVotes(int[] v) {
        Scanner in = new Scanner(System.in);
        int vote;

        for (int i = 0; i < N; i++) {
            v[i] = 0;
        }

        System.out.println("Enter voter NO.:");
        do {
            vote = in.nextInt();
            if (1 <= vote && vote < N) {
                v[vote - 1]++;
            }
        } while (1 <= vote && vote <= N);
        in.close();
    }

    public static void printVotes(int[] v) {
        System.out.print("( ");
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                System.out.print(v[i] + ",");
            } else {
                System.out.print(v[i]);
            }
        }
        System.out.println(" )");
    }

    public static int statistics(int[] v) {
        int index = 0;
        for (int i = 1; i < N; i++) {
            if (v[i] > v[index]) {
                index = i;
            }
        }
        return index + 1;
    }
}