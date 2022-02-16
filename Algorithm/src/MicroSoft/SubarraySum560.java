package MicroSoft;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySum560 {

    //第一次尝试用滑动窗口解决，解决失败。如果出现负数运算规则就完全相反。如[-1,-1,-2]， k=2
    //并且如果出现[1,1,1] k=1，滑动窗口也不太好解决。
    //并且最致命的问题是，滑动窗口要求的是有序的啊，这里使用的自数组肯定是无序的，怎么可以排序用滑动窗口= =
    public int subarraySum(int[] nums, int k){
        int count=0;
        Arrays.sort(nums);
        int left=0, right=1, sum=nums[left]+nums[right];
        while(left<right){
            if(sum==k){
                count++;
                right++;
                sum+=nums[right];
            }
            else if(sum<k){
                right++;
                sum+=nums[right];
            }
            else if(sum>k){
                sum-=nums[left];
                left++;
            }
        }
        sum=0;
        for(int i=left; i<=right; i++){
            sum+=i;
        }
        return sum==k ?  count+1:count;
    }
    //枚举解决，
    public int subArraySumByEnum(int[] nums, int k){
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum =0;
            //以当前值为结尾，往前看是否有符合的，这一步可以用hashmap优化，如下
            for (int j = i; j >=0; j--) {
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
    public int subArraySumByHashMap(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for (int i:nums){
            sum+=i;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum560 s = new SubarraySum560();
        s.subArraySumByHashMap(new int[]{3, 4, 7, 2, -3, 1, 4,2},-2);
    }
}
