import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Demo {
    public static void main(String[] args) throws ParseException {
        // 创建Calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置年
        int year = cal.get(Calendar.YEAR);
        // 设置月
        int month = cal.get(Calendar.MONTH) + 1;
        // 设置日
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日");
        
    }

}

// /**
// * 关于继承： 向上转型与向下转型
// */

// class Animal {
// String name;
// int age;

// public static void myShow() {
// System.out.println("fjeiojwf");
// }

// public void setAge(int age) {
// this.age = age;
// }

// public void setName(String name) {
// this.name = name;
// }

// public Animal() {

// }

// public Animal(String s, int a) {
// this.name = s;
// this.age = a;
// }

// @Override
// public String toString() {
// return name + " " + age;
// }

// // public void show()
// // {

// // }

// public void work() {
// System.out.println("开始工作");
// }

// }

// /**
// * cat
// *
// */
// class Cat extends Animal {
// public Cat() {
// super();
// }

// public Cat(String name, int age) {
// super(name, age);
// }

// // @Override
// // public void show()
// // {
// // System.out.println("我是一只猫");
// // }
// public void show() {
// System.out.println("我是一只猫");
// }
// }

// class Dog extends Animal {
// public Dog() {
// super();
// }

// public Dog(String name, int age) {
// super(name, age);
// }

// // @Override
// // public void show()
// // {
// // System.out.println("我是一只狗");
// // }
// public void show() {
// System.out.println("我是一只狗");
// }
// }

// /**
// * demo
// */
// public class Demo {

// public static void main(final String[] args) {

// Animal cat = new Cat("mao", 12);
// Animal dog = new Dog("gou", 15);

// cat.work();
// dog.work();

// // Animal c = null;
// // c.myShow();

// /**
// * 使用多态时，子类默认向上转型为父类 对象可以调用子类中重写父类中的方法，不能调用子类中所含的特殊方法
// * 如果想要调用子类中的特有方法，需要手动向下转型为子类再调用
// */
// // cat.show();
// // dog.show();

// /**
// *
// */
// // Animal c = (Animal)cat;
// // c.show();
// // Animal d = (Animal)dog;
// // d.show();
// // System.out.println(c);

// // if (cat instanceof Animal) {
// // // Dog c = (Dog)cat;
// // Cat c = (Cat)cat;
// // c.show();
// // }
// // if (dog instanceof Animal) {
// // Dog d = (Dog)cat;
// // d.show();
// // }

// }
// }