import java.util.*;

public class MaxDivisorMinMultiple {

    public static void main(final String[] args) {

        final Scanner in = new Scanner(System.in);
        int m, n;

        System.out.println(("Enter m,n;"));
        m = in.nextInt();
        n = in.nextInt();

        System.out.println(m + "," + n + " max common divisor is " + maxCommonDivisor(m, n));
        System.out.println(m + "," + n + " min common multiple is " + minCommonMultiple(m, n));

        in.close();
    }

    public static int maxCommonDivisor(final int m, final int n) {
        int commonDivisor;
        if (m < n) {
            commonDivisor = m;
        } else {
            commonDivisor = n;
        }
        while (m % commonDivisor != 0 || n % commonDivisor != 0) {
            commonDivisor--;

        }
        return commonDivisor;
    }

    public static int minCommonMultiple(final int m, final int n) {
        int commonMutiple;
        if (m > n) {
            commonMutiple = m;
        } else {
            commonMutiple = n;
        }
        while (commonMutiple % m != 0 || commonMutiple % n != 0) {
            commonMutiple++;

        }
        return commonMutiple;
    }

}