package Huawei;
import java.util.*;
public class ValidPassword {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.length()<=8 || !formValid(s) || containsRepeat(s)){
                System.out.println("NG");
            }
            else{
                System.out.println("OK");
            }
        }
    }
    public static boolean formValid(String s){
        int countDigital = 0;
        int countCapital = 0;
        int countLowerCase = 0;
        int countOther = 0;

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                countDigital=1;
            }
            if(!Character.isLetterOrDigit(c)){
                countOther=1;
            }
            if(Character.isLowerCase(c)){
                countLowerCase=1;
            }
            if(Character.isUpperCase(c)){
                countCapital=1;
            }
        }
        return countDigital+countCapital+countLowerCase+countOther>=3;
    }
    public static boolean containsRepeat(String s){
        for (int i = 0; i < s.length()-2; i++) {
            String sub = s.substring(i,i+3);
            int count=0;
            for (int j = 0; j < s.length()-2; j++) {
                if(s.substring(j,j+3).equals(sub)){
                    count++;
                }
            }
            if(count>1) return true;
        }
        return false;
    }
}
