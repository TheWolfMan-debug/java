package animal;

public class Animal {

    private int age;
    private String name;



    public void show()
    {

    }


    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Animal()
    {

    }

//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getName() {
//        return name;
//    }

    @Override
    public String toString() {
        return "animal.Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
