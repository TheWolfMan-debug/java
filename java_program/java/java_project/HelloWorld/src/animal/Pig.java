package animal;

public class Pig extends Animal{

    public Pig(int age, String name) {
        super(age, name);
    }

    public Pig() {
    }

    @Override
    public void show() {
        System.out.println("我是一只小猪");
    }
}
