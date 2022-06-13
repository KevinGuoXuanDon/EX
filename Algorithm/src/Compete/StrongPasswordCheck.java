package Compete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPasswordCheck {
    public boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if(len < 8) return false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean digit = false;
        boolean special = false;
        String regEx = "!@#$%^&*()-+";
        for(int i = 0; i< password.length(); i++){
            char cur = password.charAt(i);
            char next = ' ';
            if(i+1<password.length()) {
                next = password.charAt(i + 1);
            }
            if(Character.isUpperCase(cur)){
                upperCase = true;
            }
            if(Character.isLowerCase(cur)){
                lowerCase = true;
            }
            if(Character.isDigit(cur)){
                digit = true;
            }
            if(regEx.contains(cur+"")){
                special = true;
            }
            if(cur == next){
                return false;

            }
        }
        if(lowerCase && upperCase && digit && special) return true;
        return false;
    }

    public static void main(String[] args) {
        StrongPasswordCheck s = new StrongPasswordCheck();
        System.out.println(s.strongPasswordCheckerII("-Aa1a1a1"));
    }
}
