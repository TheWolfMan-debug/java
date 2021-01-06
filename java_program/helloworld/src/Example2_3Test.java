import javax.swing.*;

public class Example2_3Test {
    public static void main(final String[] args) {
        final String name = JOptionPane.showInputDialog("What is your name?");
        final String input = JOptionPane.showInputDialog("How old are you?");
        final int age = Integer.parseInt(input);
        System.out.println("Hello," + name + ".Next year,you'll be " + (age + 1) + ".");
        System.exit(0);

    }

}