public class IsPrime {

    public static void main(String[] args) throws Exception {
        int value;
        boolean result;

        value = 101;
        result = isPrime(value);
        if (result == true) {
            System.out.println(value + " is a prime.");
        } else {
            System.out.println(value + " isn't a prime.");
        }

    }

    public static boolean isPrime(int value) {
        long m = Math.round(Math.sqrt(value));
        if (value == 2) {
            return true;
        }
        for (int i = 2; i <= m; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}
