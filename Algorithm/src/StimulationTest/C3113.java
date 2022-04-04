package StimulationTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class C3113 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            System.out.println(arithmetic(sc.nextLine()));
        }
    }
    public static String arithmetic(String s){
        String[] strs = s.split(" ");
        Deque<String> nums = new ArrayDeque<>();
        for(int i=0; i< strs.length; i++){
            String str = strs[i];
            if(Character.isDigit(str.charAt(0))){
                int index =0;
                int num=0;
                while(index<str.length() && Character.isDigit(str.charAt(0))){
                    num = num*10 + str.charAt(index)-'0';
                    index++;
                    if(index<str.length() && !Character.isDigit(str.charAt(index))) return "0";
                }
                while(nums.size()>0){
                    String opre = nums.pop();
                    if(!opre.equals("+") && !opre.equals("-")) return "0";
                    else if(opre.equals("+")){
                        int pre = Integer.valueOf(nums.pop());
                        num += pre;
                    }
                    else{
                        int pre = Integer.valueOf(nums.pop());
                        num -= pre;
                    }
                }
                nums.push(num+"");
            }
            else{
                if(nums.peek().equals("+")|| nums.peek().equals("-") || nums.size()==0) return "0";
                if(str.equals("+")||str.equals("-")) nums.push(str);
                else return "0";
            }
        }
        return nums.pop();
    }
}
