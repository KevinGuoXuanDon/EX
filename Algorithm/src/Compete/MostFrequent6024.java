package Compete;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent6024 {
    /**
     * 输入：nums = [1,100,200,1,100], key = 1
     * 输出：100
     * 解释：对于 target = 100 ，在下标 1 和 4 处出现过 2 次，且都紧跟着 key 。
     * 没有其他整数在 key 后面紧跟着出现，所以我们返回 100 。
     * @param nums
     * @param key
     * @return
     */
    public int mostFrequent(int[] nums, int key) {
        int max = 0;
        int result =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==key && i+1<=nums.length-1){
                map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
