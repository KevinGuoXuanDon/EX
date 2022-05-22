package leetcode.Array.Prefix;

public class SplitNum {
    // 竞赛出现了long哦
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        if(n<=1) return 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            if(prefix[i]>=(prefix[n-1]-prefix[i])) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10,4,-8,7}));
    }
}
