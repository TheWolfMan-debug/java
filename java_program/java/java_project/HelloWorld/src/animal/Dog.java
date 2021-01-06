package animal;

public class Dog extends Animal{


    @Override
    public void show()
    {
        System.out.println("我是一只小狗");
    }

    public Dog() {
    }

    public Dog(int age, String name) {
        super(age,name);
    }




}
