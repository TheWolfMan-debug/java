import java.util.Random;

public class TestScore {


    public static final int NUM = 30;
    
    public static void main(String[] args) {

        ScoreClass[] score = new ScoreClass[NUM];
        enterScore(score);
        printScore(score);
        System.out.println("------------");
        sort(score);
        printScore(score);        
    }

    private static void sort(ScoreClass[] score) {
        int index;
        for(int i = 0; i <score.length - 1; i++)
        {
            index =i;
            for(int j = i+1; j < score.length; j++)
            {
                if(score[j].getScore() > score[index].getScore())
                {
                    index = j;
                }
                if(index != i)
                {
                    ScoreClass s = score[i];
                    score[i] = score[index];
                    score[index] = s;
                }
            }
        }
    }

    private static void printScore(ScoreClass[] score) {

        for(int i = 0; i<score.length; i++) {
            System.out.println(score[i]);
        }
    }

    private static void enterScore(ScoreClass[] score) {
        for(int i = 0; i <score.length; i++) {
            score[i] = new ScoreClass(1000+i,(int)(new Random().nextInt(100)));
        }
    }

    
}