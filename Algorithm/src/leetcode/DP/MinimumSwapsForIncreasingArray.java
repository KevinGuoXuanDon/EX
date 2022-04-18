package leetcode.DP;

/**
 * 801. 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。
 * 在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 *
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4]
 * 你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 *
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]
 * 注意：
 * 用例保证可以实现操作。
 * 示例 1:
 *
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 */
public class MinimumSwapsForIncreasingArray {
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i=1; i<nums1.length;i++){
            if(nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
                if(nums1[i]>nums2[i-1] && nums2[i]>nums1[i-1]){
                    int min = Math.min(dp[i-1][0],dp[i-1][1]);
                    dp[i][0] = min;
                    dp[i][1] = min + 1;
                }
                else{
                    //不是交叉升序,上一次没换这一次就不能换
                    dp[i][0] = dp[i-1][0];
                    // 上一次换了这次就也要换
                    dp[i][1] = dp[i-1][1]+1;
                }
            }
            else{
                // 如果当前不满足升序，前一次换了这次不换，前一次不换这次就换
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0]+1;
            }
        }
        return Math.min(dp[nums1.length-1][0],dp[nums1.length-1][1]);
    }
}
