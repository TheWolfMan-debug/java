package animal;

public class Cat extends Animal{


    @Override
    public void show()
    {
        System.out.println("我是一只小猫");
    }

    public Cat(int age, String name) {
        super(age,name);
    }

    public Cat() {
    }
}
