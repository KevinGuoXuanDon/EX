package leetcode.Stimulate;

import java.util.*;

public class PrimeNumberBetweenAB {
    public List<Integer> prime(int a, int b) {
        List<Integer> res = new ArrayList<>();
        for (int i = a; i < b; i++) {
            boolean flag = true;
            for (int k = 2; k <= i / 2; k++) {
                if (i % k == 0) {
                    flag = false;
                }
            }
            if (flag) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        PrimeNumberBetweenAB p = new PrimeNumberBetweenAB();
        List<Integer> res = p.prime(2, 10);
        res.stream().forEach(System.out::println);
    }
}
