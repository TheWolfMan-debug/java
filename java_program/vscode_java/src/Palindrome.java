import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string");
        str = in.nextLine();
        System.out.println("You've entered string: " + str);
        if (isPalindrome(str)) {
            System.out.println("\"" + str + "\" is a palindrome");
        } else {
            System.out.println("\"" + str + "\" is'nt a palindrome");
        }

        in.close();
    }

    private static boolean isPalindrome(String str) {

        int len = str.length();
        for(int index = 0; index < len/2; index++) {
            if(str.charAt(index) != str.charAt(len-1-index)) {
                return false;
            }
        }
        
        return true;
    }

}