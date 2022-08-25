package leetcode.Array.Prefix;
import java.util.*;

/**
 * [2,-2,3,0,4,-7]
 *
 * [2,-2]
 * [2,-2,3,0,4,-7]
 * [3,0,4,-7]
 * [0]
 */

public class FindZeroSet {
    long count = 0;

    public int solution(int[] arr) {
        // write your code in Java 11 (Java SE 11)
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i =1; i<arr.length;i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:prefix){
            if(i==0){
                count++;
            }
            if(map.containsKey(i)){
                count += map.get(i);
            }
            map.put(i,map.getOrDefault(i,0)+1);
        }
        System.out.println(count);
        if(count>1000000000){
            return -1;
        }
        return (int)count;
    }

    public static void main(String[] args) {
        FindZeroSet f = new FindZeroSet();
        f.solution(new int[]{0, 0, 0, 0, 0, 0});
    }
}
