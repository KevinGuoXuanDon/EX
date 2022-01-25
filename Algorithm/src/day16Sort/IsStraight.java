package day16Sort;

import java.util.Arrays;

public class IsStraight {
    //0ms 100%
    public boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0) {
                count++;
                continue;
            }
            else if(nums[i]==nums[i+1]) return false;
            else if(1!=nums[i+1]-nums[i]){
                if(count<nums[i+1]-nums[i]-1) return false;
                else{
                    count-=nums[i+1]-nums[i]-1;
                    continue;
                }
            }
        }
        return true;
    }
    //简化后
    //0ms 100%
    public boolean isStraight2(int[] nums){
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < 4; i++) {
            if(nums[i]==0) count++;
            else if(nums[i]==nums[i+1]) return false;
        }
        return nums[4]-nums[count]<5;
    }
}
