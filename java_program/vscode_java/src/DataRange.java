import java.util.*;

public class DataRange {

    public static final int ENTER_NUM = 3;
    
    public static void main(String[] args) {
        int minValue, maxValue, tempValue;

        Scanner in = new Scanner(System.in);
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;

        System.out.printf("Enter " + ENTER_NUM + " integers:");
        for (int i = 1; i <= ENTER_NUM; i++) {
            tempValue = in.nextInt();
            if (tempValue < minValue) {
                minValue = tempValue;
            }
            if (tempValue > maxValue) {
                maxValue = tempValue;
            }

            // 显示结果
            System.out.println("The Range of the Values is " + minValue + " ~ " + maxValue);
        }

        in.close();

    }
}