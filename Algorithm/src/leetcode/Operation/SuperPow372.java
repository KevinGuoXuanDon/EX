package leetcode.Operation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your task is to calculate ab mod 1337
 * where a is a positive integer and
 * b is an extremely large positive integer given in the form of an array.
 *
 * Example 1:
 *
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 *
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * Example 3:
 *
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 */
public class SuperPow372 {
    /**
     *  a^1328 = a^1320 * a^8   =   (a^132)^10  * a^8;
     *  a^132  = a^130 * a^2    =   (a^13)^10   * a^2;
     *  .....
     *
     *  while using mod.
     *  ( a * b) % k = (a%k * b%k) %k;
     */

    private static int base = 1337;

    public int superPow(int a, int[] b){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i:b){
            deque.addLast(i);
        }
        return superPow(a, deque);
    }
    private int superPow(int a, Deque<Integer> deque){
        if(deque.isEmpty()){
            return 1;
        }
        int last = deque.removeLast();
        int part1 = myPow(a,last);
        int part2 = myPow(superPow(a,deque),10);

        return (part1*part2)%base;
    }

    public int myPow(int x, int n){
        if(n==0)
            return 1;
        x %= base;
        if(n%2==0){
            return myPow(x*x,n/2);
        }
        else{
            return (x * myPow(x,n-1))%base;
        }
    }
}
