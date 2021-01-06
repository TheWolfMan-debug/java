import java.util.*;

public class Menology {

    public static final int FIRST_DAY = 4;
    public static final int YEAR = 2009;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month;

        System.out.print("Enter month:");
        month = in.nextInt();

        printMenology(YEAR, month);

        in.close();

    }

    public static int getDays(int year, int month) {
        int days;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                days = 31;
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                days = 30;
                break;
            }
            case 2: {
                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            }

            default:
                days = -1;
                break;
        }
        return days;
    }

    public static int getStartPosition(int year,int month)
    {
        int allDays,firstDay;
        allDays=0;
        for(int i=1;i<month;i++)
        {
            allDays+=getDays(year,i);
        }
        firstDay=(allDays+FIRST_DAY)%7;
        return firstDay;
    }

    public static void printHead()
    {
        System.out.println("  SUN  MON  TUE  WED  THU  FRI  SAT");
    }

    public static void printMenology(int year,int month)
    {
        int allDays,firstDay,day;
        allDays=getDays(year, month);
        firstDay=getStartPosition(year, month);
        printHead();
        for(int i=0;i<firstDay;i++)
        {
            System.out.print("     ");
        }
        day=firstDay;
        for(int i=1;i<=allDays;i++)
        {
            System.out.printf("%5d",i);
            day=(day+1)%7;
            if(day==0)
            {
                System.out.println();
            }
        }
        System.out.println();
    }

}