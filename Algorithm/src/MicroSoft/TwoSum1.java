package MicroSoft;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        for (int i=0; i<nums.length; i++) {
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{i,hashtable.get(target-nums[i])};
            }
            hashtable.put(nums[i],i);
        }
        return null;
    }
}
