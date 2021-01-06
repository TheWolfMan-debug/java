import java.util.*;

public class AddressClass {

    public static void main(String[] args) {
        
        Scanner in =new Scanner(System.in);

        System.out.printf("Enter your name:");
        String name = in.nextLine();

        System.out.printf("Enter your telephone number:");
        String tel= in.nextLine();

        System.out.printf("Enter your telephone address:");
        String address=in.nextLine();

        System.out.printf("Enter your post number:");
        String post = in.nextLine();

        System.out.println("Name: " + name);
        System.out.println("Tel: " + tel);
        System.out.println("Addr: " + address);
        System.out.println("Post: " + post);

        in.close();
        
    }

	public static double pi() {
	    double result, item;
	    int denominator, sign;
	    result = 0;
	    denominator = 1;
	    sign = 1;
	    do {
	        item = (double) sign / denominator;
	        result += item;
	        sign = -sign;
	        denominator += 2;
	    } while (Math.abs((double) sign / denominator) >= 1e-6);
	    return result;
	}
    
}