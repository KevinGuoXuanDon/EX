package leetcode;

import java.util.*;
public class CountNumberofNiceSubarrays {
    //滑动窗口
    // (1)  1  2  1  (1)
    public int numberOfSubarraysByDoublePointer(int[] nums, int k){
        int left = 0, right = 0, odd =0, result =0;
        while(right<nums.length){
            //右窗口先移动，每次遇到奇数记录下来，直到奇数数量满足了k，此时就进行一次计算.
            if((nums[right]&1)==1){
                odd++;
            }
            //此时right会停在奇数右边
            right++;
            while(odd==k){
                //需要找到滑动窗口左右两端的偶数来进行计算。比如 2 1 2 2 1 2 2, k =2, 结果是 2 * 3 = 6
                //记录当前右端点位置用于计算
                int tempRight = right;
                //偶数的话右端点接着往右遍历，直到找到下一个奇数或者出界
                while(right<nums.length && (nums[right]&1)==0){
                    right++;
                }
                int rightEvenNumber = right - tempRight;
                int leftEventNumber =0;
                while((nums[left]%1)==0){
                    left++;
                    leftEventNumber++;
                }
                //左边偶数+1 乘以 右边偶数+1 来获得排列组合的结果
                result += (leftEventNumber+1) * (rightEvenNumber+1);
                //计算完了。此时让左端点离开这tempright的位置，计算下一轮
                left++;
                //记得让奇数个数减1
                odd--;
            }
        }
        return result;
    }

    //前缀和，估计我写不出= =
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] % 2 == 0 ? 0 : 1;
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumberofNiceSubarrays c = new CountNumberofNiceSubarrays();
        c.numberOfSubarrays(new int[]{2,2,1,2,2},1);
    }
}



