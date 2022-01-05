package day4LookingUp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class FindRepeatNumber03 {
    //使用Hash的contains方法，7ms 37.37%； 47.4mb，25。54%
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int i: nums) {
            if(dic.contains(i)) return i;
            dic.add(i);
        }
        return -1;
    }
    //通过排序实现
    //2ms 64.81%
    //46.1mb 62.23%
    public int findRepeatNumberBySort(int[] nums){
        Arrays.sort(nums);
        System.out.print(nums.toString());
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;
    }
    //原地交换实现（我没想到的方法）
    //0ms 100%
    //46.3mb,  51.74%
    public int findRepeatNumberBySwap(int[] nums){
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i) {
                i+=1;
                continue;
            }
            // 由于nums[i] != i, 下面if成立则出现重复。
            if (nums[i] == nums[nums[i]])
                return nums[i];
            // 按照nums[i] = i占位。
            int t = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = t;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 0, 0, 1};
        FindRepeatNumber03 f = new FindRepeatNumber03();
        System.out.println(f.findRepeatNumberBySwap(nums));
        for(int j=0;j<nums.length;j++){
            System.out.print(nums[j]);
        }
    }
}
