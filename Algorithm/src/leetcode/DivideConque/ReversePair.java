package leetcode.DivideConque;

/**
 * 逆序对的题目可以先考虑归并排序.
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class ReversePair {
    // 本题很容易想到暴力破解的方法，但是时间复杂度为平方级别，无法通过全部案例.
    // 解：归并排序统计逆序. 三个步骤:
    // 1. 把数组分解为左右两半，持续的分解直到小数组的长度为1。
    // 2. 解决：排序分解出来的子序列。
    // 3. 合并已经排序的子序列.在合并是顺便统计逆序对数量. https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
    int count = 0;

    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    public void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            // divide
            int mid = left + (right - left) / 2;
            // sort left part
            sort(nums, left, mid, temp);
            // sort right part
            sort(nums, mid + 1, right, temp);
            // merge
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // 左半部分指针
        int i = left;
        // 右半部分指针
        int j = mid + 1;
        // 结果数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                t++;
                i++;
            } else {
                count += (mid - i + 1); //这一步说明左边当前数字以及后面的数字都会大于此时右边这个数字，右边这个数字贡献有m-i+1个逆序对
                temp[t] = nums[j];
                t++;
                j++;
            }
        }
        //如果右边遍历完了，左边还没遍历完
        while (i <= mid)
            temp[t++] = nums[i++];
        //如果左边遍历完了，右边还没
        while (j <= right)
            temp[t++] = nums[j++];
        //把当前数组复制回原数组
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

}
