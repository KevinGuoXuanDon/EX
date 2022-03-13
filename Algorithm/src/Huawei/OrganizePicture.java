package Huawei;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizePicture {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String given =sc.nextLine();
        char[] chars = given.toCharArray();
        Arrays.sort(chars);
        System.out.print(new String(chars));
    }
}
