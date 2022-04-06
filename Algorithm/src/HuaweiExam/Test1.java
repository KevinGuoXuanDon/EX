package HuaweiExam;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String tf = sc.nextLine();
            int day =0;
            if(tf.equals("true")) day=366;
            else day =365;
            String[] strs = sc.nextLine().split(" ");
            int[] arr = new int[strs.length];
            for(int i=0;i<strs.length;i++){
                arr[i] = Integer.valueOf(strs[i]);
            }
            Arrays.sort(arr);
            int sign =0;
            int weekSign =0;
            int monthSign = 0;
            int score = 0;
            int breakDay = 0;
            for(int i=1; i<=day;i++){
                if(breakDay<arr.length && i==arr[breakDay]){
                    breakDay++;
                    sign =0;
                    weekSign=0;
                    monthSign=0;
                    continue;
                }
                else{
                    sign++;
                    weekSign++;
                    monthSign++;
                    if(sign==1) score+=2;
                    else if(sign==2) score+=4;
                    else score+=8;
                    if(weekSign==7){
                        score+=20;
                        weekSign=0;
                    }
                    if(monthSign==30){
                        score+=100;
                        monthSign=0;
                    }
                }
            }
            System.out.println(score);
        }
    }
}
