import java.util.*;

public class EquationClass {

    public static void main(String[] args) {
        double a, b, c, disc;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 3 coefficient (a,b,c):");
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        disc = Math.pow(b, 2) - 4 * a * c;
        if (disc < 0) {
            System.out.println(("There isn't real root."));

            in.close();
            return;
        }
        if (disc == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("x = " + x);

            in.close();
            return;
        }
        double x1, x2;
        x1 = (-b + Math.sqrt(disc)) / (2 * a);
        x2 = (-b - Math.sqrt(disc)) / (2 * a);
        System.out.println(("x1 =" + x1));
        System.out.println("x2 = " + x2);

        in.close();

    }

}