package Huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class MingsRandom {
    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n; i++){
            set.add(sc.nextInt());
        }
        set.stream().forEach(System.out::println);
        StringBuilder sb = new StringBuilder(sc.next());

    }
}
