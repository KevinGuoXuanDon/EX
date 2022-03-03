package Huawei;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for(long i = 2; i<= Math.sqrt(n); i++){
            while(n%i==0){
                System.out.print(i+" ");
                n/=i;
            }
        }
        if(n!=1){
            System.out.print(n);
        }
    }
}

