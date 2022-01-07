package day4LookingUp;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 */
public class MissingNumber53_II {
    //2ms 100%
    //38.8mb    59.14%
    public int MissingNumber53_II(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==mid){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
        System.out.println(high);

        return low;
    }

    public static void main(String[] args) {
        MissingNumber53_II m = new MissingNumber53_II();
        int[] nums=new int[]{0,1,2,3,5};
        System.out.println(m.MissingNumber53_II(nums));
    }
}
