package Compete;

import java.util.Arrays;

public class HandOutCandy {
    // 记录一下出的bug：首先通过stream流计算得到的sum是int类型，数据太大比较时会出问题
    // 因为题目中的数据很容易出现超过int类型，必须转long
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int i:candies) sum+=i;
        if(sum<k) return 0;
        if(sum==k) return 1;
        Arrays.sort(candies);
        long left =1;
        long right = sum;
        long ans =0;
        while(left<=right){
            long mid = (right-left)/2 + left;
            if(getCount(candies,k,mid)){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return (int)ans;
    }
    public boolean getCount(int[] candies, long k, long mid){
        long count=0;
        for(int i=candies.length-1;i>=0;i--){
            if(candies[i]<mid) break;
            count += candies[i]/mid;
        }
        if(count>=k) {
            return true;
        }
        else{
            return false;
        }
    }
}
