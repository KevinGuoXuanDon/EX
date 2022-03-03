package Huawei;
import java.util.Scanner;
public class SeperateString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int countForAddZero = 8-sb.length()%8;
        //如果为0或者为8则不需要进入循环了,否则每次循环都需要添加一个0
        while(countForAddZero % 8 !=0){
            countForAddZero--;
            sb.append("0");
        }
        String result = sb.toString();
        while(result.length()>0){
            System.out.println(result.substring(0,8));
            result = result.substring(8);
        }
    }
}
