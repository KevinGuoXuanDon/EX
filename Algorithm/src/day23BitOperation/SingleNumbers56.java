package day23BitOperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 */
public class SingleNumbers56 {
    //12ms 6.68%
    //直接hashmap暴力求解，但是有一说一这个方法属实慢，数据一大就要死(尽管时间复杂度为O(n))，空间复杂度也不满足
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] result = new int[2];
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()==1){
                if(result[0]==0) result[0] = entry.getKey();
                else result[1] = entry.getKey();
            }
        }
        return result;
    }
    //如果不考虑时间复杂度要求，使用排序也可以做,Arrays.sort（）时间复杂度nlogn,空间复杂度倒是满足了
    //这方法还没写完
    public int[] singleNumbersBy(int[] nums){
        Arrays.sort(nums);
        int[] result = new int[2];
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]!=nums[i+1]){
                if(result[0]!=0){
                    result[1]=nums[i];
                }
                else result[0]=nums[i];
            }
        }
        return result;
    }

    //比特运算
    public int[] singleNumberByBitOperation(int[] nums){
        int n=0;
        for (int i:nums) {
            n ^=i;
        }
        int m =1;
        while((n&m)==0){
            m<<=1;
        }
        int x=0,y=0;
        for(int i:nums){
            if((i & m)!=0) x^=i;
            else y^=i;
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        System.out.println(2^1);
        System.out.println(2&1);

    }
}
