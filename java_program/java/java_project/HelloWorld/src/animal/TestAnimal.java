package animal;

import java.util.ArrayList;

public class TestAnimal {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(10);

        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0) {
                animals.add(new Cat(i, "小猫" + i));
            }
            if (i % 3 == 1) {
                animals.add(new Dog(i, "小狗" + i));
            }
            if (i % 3 == 2) {
                animals.add(new Pig(i, "小猪" + i));
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.show();
        }
        print();


    }

    private static void print() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }


}
