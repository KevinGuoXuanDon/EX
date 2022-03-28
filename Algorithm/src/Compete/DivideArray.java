package Compete;

import java.util.Arrays;
//简单题，没啥好写的
public class DivideArray {
    // 1 1 1 1 2
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int flag = 0;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                flag++;
            }else{
                if(flag%2==0) return false;
                flag =0;
            }
        }
        return true;
    }
}
