/**
 * TeacherAcoountTest
 */

public class TeacherAccountTest
{
    public static void main(String[] args){
        TeacherAccount staffaccount = new TeacherAccount();
        SchoolBank com = new SchoolBank(staffaccount);
        Teacher sta = new Teacher(staffaccount);
        Thread t1 = new Thread(com);
        Thread t2 = new Thread(sta);
        t1.start();
        t2.start();
    }
}
 
 
class TeacherAccount {

    private int[] month = new int[12];
    private int num = 0;

    public synchronized void deposit(int mon) {
        num++;
        month[num] = mon;
        this.notify();
        // notifyAll();
    }

    public synchronized int withdraw() {
        while (num == 0) {
            try {
                this.wait();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        num--;
        return month[num + 1];
    }

}

class SchoolBank implements Runnable {
    TeacherAccount account;

    public SchoolBank(TeacherAccount s) {
        account = s;
    }

    public void run() {
        for (int i = 1; i < 7; i++) {
            account.deposit(i);
            System.out.println("学校 发放：" + i + "月份的工资");
            try {
                // Thread.sleep((long) Math.random() * 10);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}

class Teacher implements Runnable {
    TeacherAccount account;

    public Teacher(TeacherAccount s) {
        account = s;
    }
    public void run() {
        int temp;
        for(int i=1;i<12;i++)
        {
            temp = account.withdraw();
            System.out.println("教师 提取：" +temp+"月份的工资");
            try {
                // Thread.sleep((long) (Math.random()*10));
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}

