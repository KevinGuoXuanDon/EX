package Compete;
import java.util.*;
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        // 1 2  1 2 3 4
        if(nums.length==1) return 0;
        HashMap<Integer,Integer> odd = new HashMap<>();
        HashMap<Integer,Integer> even = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(i%2!=0){
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }
            else{
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }
        }
        int result=nums.length;
        int[][] oddMaxAndSub = getMax(odd);
        int[][] evenMaxAndSub = getMax(even);
        if(oddMaxAndSub[0][0] !=evenMaxAndSub[0][0]){
            result-=oddMaxAndSub[0][1];
            result-=evenMaxAndSub[0][1];
        }
        else{
            result-=Math.max(oddMaxAndSub[0][1]+evenMaxAndSub[1][1],oddMaxAndSub[1][1]+evenMaxAndSub[0][1]);
        }
        return result;
    }
    int[][] getMax(HashMap<Integer,Integer> map) {
        int[][] maxAndSubMax = new int[2][2];
        //对于每个数字
        for(Integer key:map.keySet()) {
            //获取当前数字key的val
            int val = map.get(key);
            //找到个数数量前两个的数字进行数组存储 保存他们的 key 与 val || res[0][0] 是最多数量数字的key res[0][0] 是最多数量数字的val
            if(val>maxAndSubMax[0][1]) {
                maxAndSubMax[1][0] = maxAndSubMax[0][0];
                maxAndSubMax[1][1] = maxAndSubMax[0][1];
                maxAndSubMax[0][0] = key;
                maxAndSubMax[0][1] = val;
            } else if(val>maxAndSubMax[1][1]){//数量次多的key 与 val
                maxAndSubMax[1][0] = key;
                maxAndSubMax[1][1] = val;
            }
        }
        return maxAndSubMax;
    }

    public static void main(String[] args) {
        MinimumOperations m = new MinimumOperations();
        m.minimumOperations(new int[]{1,2,2,2,2});
    }
}
