package leetcode.Greedy;

/**
 * @author Xuandong Guo
 * @date 09/12/2022
 */
import java.util.Arrays;
import java.util.HashMap;

public class EqualSumArrayWithMinOpe {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int diff = 0;
        if(sum1>sum2){
            diff = sum1-sum2;
        }
        else{
            int[] temp = nums1.clone();
            nums1 = nums2;
            nums2 = temp;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums1){
            map.put(i-1,map.getOrDefault(i-1,0)+1);
        }
        for(int i:nums2){
            map.put(6-i,map.getOrDefault(6-i,0)+1);
        }
        int curMax = 5;
        int ope = 0;
        while(diff>0 && curMax>0){
            if(!map.containsKey(curMax) || map.get(curMax)==0){
                curMax--;
            }
            else{
                while(diff>0 && map.get(curMax)>0){
                    ope++;
                    if(curMax>diff){
                        diff = 0;
                        return ope;
                    }
                    else{
                        map.put(curMax,map.get(curMax)-1);
                        diff -=curMax;
                    }
                }
            }
        }
        return diff==0? ope:-1;
    }
}
