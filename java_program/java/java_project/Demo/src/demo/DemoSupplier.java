package demo;

import java.util.function.Supplier;

public class DemoSupplier {

    private static String getString(Supplier<String> function)
    {
        return function.get();
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        System.out.println(getString(()->a+b));
    }


}
