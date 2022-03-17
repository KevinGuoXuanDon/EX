package Compete;

import java.util.LinkedList;
import java.util.List;

public class FindAllKDistantIndicesinanArray {
    int length;

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // 使用双指针免去了set去重
        // [fast - k, fast + k]
        List<Integer> res = new LinkedList<>();
        length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] == key) {
                slow = Math.max(slow, fast - k); // 区间开始
                int end = Math.min(fast + k, length - 1); // 区间结束
                // 将“合法”区间的下标加入 res 数组
                while (slow <= end) {
                    res.add(slow++);
                }
            }
        }
        return res;
    }


}
