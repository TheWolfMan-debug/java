import java.util.*;

public class TriangleClass {

    public static void main(String[] args) {

        double a, b, c, s, area;
     
        

        Scanner in = new Scanner(System.in);

        System.out.printf("Enter 3 edges:");
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        s = (a + b + c) / 2;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.printf("a = %2.2f,  b = %2.2f,  c = %2.2f\n", a, b, c);
        System.out.printf("area = %2.2f\n", area);

        in.close();

    }
}