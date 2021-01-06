import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        // for (int i = 0; i < 3; i++) {
        // System.out.println("hello,world");
        // }

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;

        System.out.println(max);

        sc.close();

        
    }
}