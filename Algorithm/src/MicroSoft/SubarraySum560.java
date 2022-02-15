package MicroSoft;

import java.util.Arrays;

public class SubarraySum560 {

    //第一次尝试用滑动窗口解决，解决失败。如果出现负数运算规则就完全相反。如[-1,-1,-2]， k=2
    //并且如果出现[1,1,1] k=1，滑动窗口也不太好解决。
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
}
