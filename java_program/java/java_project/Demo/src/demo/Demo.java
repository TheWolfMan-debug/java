package demo;

import java.io.*;

@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();

}

@FunctionalInterface
interface MessageBuilder {
    String builderMessage();
}

public class Demo {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        log(2,()->{
            System.out.println("lambda执行！！！");
            return  a+b+c;
        });
    }

    private static void log(int i, MessageBuilder builder) {
        if(i==1)
        {
            System.out.println(builder.builderMessage());
        }

    }

    private static void test(int ...array) {
        for (int i:array)
        {
            System.out.println(i);
        }
    }

    public static void doSomething(MyFunctionalInterface inter) {
        inter.myMethod();
    }
}


//public class Demo {
//
//    public static void main(String[] args) {
//
//        // 声明变量
//        FileWriter fw = null;
//        try {
//            //创建流对象
//            fw = new FileWriter("demo/fw.txt");
//            // 写出数据
//            fw.write("黑马程序员"); //黑马程序员
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fw != null) {
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//        //创建流对象
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter("Demo\\src\\fw.txt");
//            // 写出数据
//            fw.write("黑马程序员"); //黑马程序员
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

//        // 声明变量
//        FileWriter fw = null;
//        try {
//            //创建流对象
//            fw = new FileWriter("Demo\\src\\fw.txt");
//            // 写出数据
//            fw.write("黑马程序员"); //黑马程序员
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fw != null) {
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//}


//    public static void main(String[] args) throws IOException {
//        // 使用文件名称创建流对象
//        FileOutputStream fos = new FileOutputStream("Demo\\src\\fos.txt",true);
//
//        for (int i = 0; i < 5; i++) {
//            // 字符串转换为字节数组
//            byte[] b = "hello,world\r\n".getBytes();
//            // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
//            fos.write(b,0,b.length);
//        }
//
//        // 关闭资源
//        fos.close();
//    }


//    public static void main(String[] args) {
//
//
////        File f = new File("E:\\java_project\\Demo\\src\\Content.txt");
//        File f = new File("Demo\\src\\Content.txt");
//
//        System.out.println(f.getAbsoluteFile());
//        System.out.println(f.canExecute());
//        System.out.println(f.getPath());
//        System.out.println(f.length());
//        System.out.println(f.exists());
//
//
//    }

//}
//
//        invokeCook(()-> System.out.println("吃饭了"));
//
//
//    }
//
//    public static void invokeCook(Cook cook)
//    {
//        cook.makeFood();
//    }
//}
//
//interface Cook
//{
//    void makeFood();
//}
//


//
//    // 模拟数据库中已存在账号
//    private static String[] names = {"bill","hill","jill"};
//
//    public static void main(String[] args) {
//
//
//
//        //调用方法
//        // 可能出现异常的代码
//        if(checkUsername("hill"))
//        {
//            System.out.println("注册成功");//如果没有异常就是注册成功
//        }
//        else {
//            System.out.println("注册失败");
//        }
//    }
//
//    //判断当前注册账号是否存在
//    //因为是编译期异常，又想调用者去处理 所以声明该异常
//    public static boolean checkUsername(String uname){
//        for (String name : names) {
//            if(name.equals(uname)){//如果名字在这里面 就抛出登陆异常
//                try {
//                    throw new RegisterException("亲"+name+"已经被注册了！");
//                } catch (RegisterException e) {
//                    e.printStackTrace();
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
//
//// 业务逻辑异常
//class RegisterException extends Exception {
//    /**
//     * 空参构造
//     */
//    public RegisterException() {
//    }
//
//    /**
//     *
//     * @param message 表示异常提示
//     */
//    public RegisterException(String message) {
//        super(message);
//    }
//}


//        try {
//            read("a.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 如果定义功能时有问题发生需要报告给调用者。可以通过在方法上使用throws关键字进行声明
//    public static void read(String path) throws FileNotFoundException {
//        if (!path.equals("a.txt")) {//如果不是 a.txt这个文件
//            // 我假设  如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常  throw
//            throw new FileNotFoundException("文件不存在");
//        }
//    }
//}
//


//        //创建一个数组
//        int[] arr = {2,4,52,2};
//        //根据索引找对应的元素
//        int index = 4;
//        int element = getElement(arr, index);
//
//        System.out.println(element);
//        System.out.println("over");
//    }
//    /*
//     * 根据 索引找到数组中对应的元素
//     */
//    public static int getElement(int[] arr,int index){
//        //判断  索引是否越界
//        if(index<0 || index>arr.length-1){
//             /*
//             判断条件如果满足，当执行完throw抛出异常对象后，方法已经无法继续运算。
//             这时就会结束当前方法的执行，并将异常告知给调用者。这时就需要通过异常来解决。
//              */
////            throw new ArrayIndexOutOfBoundsException("哥们，角标越界了~~~");
//            throw new ArrayIndexOutOfBoundsException("哥们，角标越界了~~~");
//        }
//        return arr[index];
//    }
//}


//        /*
//         * 1组装54张扑克牌
//         */
//        // 1.1 创建Map集合存储
//        HashMap<Integer, String> pokerMap = new HashMap<>();
//        // 1.2 创建 花色集合 与 数字集合
//        ArrayList<String> colors = new ArrayList<>();
//        ArrayList<String> numbers = new ArrayList<>();
//
//        // 1.3 存储 花色 与数字
//        Collections.addAll(colors, "♦", "♣", "♥", "♠");
//        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
//        // 设置 存储编号变量
//        int count = 1;
//        pokerMap.put(count++, "大王");
//        pokerMap.put(count++, "小王");
//        // 1.4 创建牌 存储到map集合中
//        for (String number : numbers) {
//            for (String color : colors) {
//                String card = color + number;
//                pokerMap.put(count++, card);
//            }
//        }
//        /*
//         * 2 将54张牌顺序打乱
//         */
//        // 取出编号 集合
//        Set<Integer> numberSet = pokerMap.keySet();
//        // 因为要将编号打乱顺序 所以 应该先进行转换到 list集合中
//        ArrayList<Integer> numberList = new ArrayList<>(numberSet);
//
//        // 打乱顺序
//        Collections.shuffle(numberList);
//
//        // 3 完成三个玩家交替摸牌，每人17张牌，最后三张留作底牌
//        // 3.1 发牌的编号
//        // 创建三个玩家编号集合 和一个 底牌编号集合
//        ArrayList<Integer> noP1 = new ArrayList<>();
//        ArrayList<Integer> noP2 = new ArrayList<>();
//        ArrayList<Integer> noP3 = new ArrayList<>();
//        ArrayList<Integer> diPi = new ArrayList<>();
//
//        // 3.2发牌的编号
//        for (int i = 0; i < numberList.size(); i++) {
//            // 获取该编号
//            Integer no = numberList.get(i);
//            // 发牌
//            // 留出底牌
//            if (i >= 51) {
//                diPi.add(no);
//            } else {
//                if (i % 3 == 0) {
//                    noP1.add(no);
//                } else if (i % 3 == 1) {
//                    noP2.add(no);
//                } else {
//                    noP3.add(no);
//                }
//            }
//        }
//
//        // 4 查看三人各自手中的牌（按照牌的大小排序）、底牌
//        // 4.1 对手中编号进行排序
//        Collections.sort(noP1);
//        Collections.sort(noP2);
//        Collections.sort(noP3);
//        Collections.sort(diPi);
//
//        // 4.2 进行牌面的转换
//        // 创建三个玩家牌面集合 以及底牌牌面集合
//        ArrayList<String> player1 = new ArrayList<>();
//        ArrayList<String> player2 = new ArrayList<>();
//        ArrayList<String> player3 = new ArrayList<>();
//        ArrayList<String> diPai = new ArrayList<>();
//
//        // 4.3转换
//        for (Integer i : noP1) {
//            // 4.4 根据编号找到 牌面 pokerMap
//            String card = pokerMap.get(i);
//            // 添加到对应的 牌面集合中
//            player1.add(card);
//        }
//
//        for (Integer i : noP2) {
//            String card = pokerMap.get(i);
//            player2.add(card);
//        }
//        for (Integer i : noP3) {
//            String card = pokerMap.get(i);
//            player3.add(card);
//        }
//        for (Integer i : diPi) {
//            String card = pokerMap.get(i);
//            diPai.add(card);
//        }
//
//        //4.5 查看
//        System.out.println("令狐冲："+player1);
//        System.out.println("石破天："+player2);
//        System.out.println("鸠摩智："+player3);
//        System.out.println("底牌："+diPai);


//        // 创建Map集合对象
//        HashMap<String, String> map = new HashMap<>();
//        // 添加元素到集合
//        map.put("胡歌", "霍建华");
//        map.put("郭德纲", "于谦");
//        map.put("薛之谦", "大张伟");
//
//        // 获取 所有的 entry对象  entrySet
//        Set<Map.Entry<String, String>> entrySet = map.entrySet();
//
//        // 遍历得到每一个entry对象
//        for (Map.Entry<String, String> entry : entrySet) {
//            // 解析
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + "的CP是:" + value);
//        }

//    }
//
//}


