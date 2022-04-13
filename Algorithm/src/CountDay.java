import java.util.Calendar;
import java.util.Scanner;

public class CountDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // n表示年份
            int n = Integer.parseInt(sc.nextLine());
            if(n<0){
                System.out.println("Error input with: "+n);
                continue;
            }
            // 目标是周日，所以targetWeek = 7
            int targetWeek = 7;
            int count = 0;
            Calendar calendar = Calendar.getInstance();
            // 用i模拟年份
            for(int i =1990;i<=1990+n;i++){
                // 用j来模拟月份
                for(int j=0;j<12;j++){
                   // 设置日期为18号
                   calendar.set(i,j,18);
                   int curWeek = calendar.get(Calendar.DAY_OF_WEEK);
                   if(curWeek==targetWeek){
                       count++;
                   }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
