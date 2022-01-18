package day13DoublePointer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange21 {
    //2ms 75.71%
    //45.8MB 95.67%
    public int[] exchange(int[] nums) {
        if(nums.length==0) return nums;
        int even =0;
        int odd= nums.length-1;
        while(even<odd){
            if(nums[even]%2==0) {
                if (nums[odd] % 2 != 1) odd--;
                else{
                    int temp=nums[even];
                    nums[even] = nums[odd];
                    nums[odd] = temp;
                }
            }
            else even++;
        }
        return nums;
    }

    //1ms 100%
    //45.8MB 96.86%
    //相当于我的代码的简化版，因为我没有在while循环里再写循环了，本质都是设立两端指针，一个往前一个往后走，找到奇偶交换。
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange21 e = new Exchange21();
        int[] nums = {1,2,3,4};
        nums = e.exchange(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
