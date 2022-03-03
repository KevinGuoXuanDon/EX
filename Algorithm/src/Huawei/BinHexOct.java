package Huawei;

import java.math.BigInteger;
import java.util.Scanner;

public class BinHexOct {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.replace("x","");
        BigInteger bgint = new BigInteger(s,16);
        System.out.print(bgint.intValue());
    }
}
