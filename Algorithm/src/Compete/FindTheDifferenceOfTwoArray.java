package Compete;

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 *
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 *
 *
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 */
import java.util.*;
public class FindTheDifferenceOfTwoArray {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new LinkedList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1. add(i);
        }
        for(int i : nums2){
            set2.add(i);
            if(set1.contains(i)){
                set1.remove(i);
            }
        }
        for(int i : nums1){
            if(set2.contains(i)){
                set2.remove(i);
            }
        }
        res.add(new ArrayList<Integer>(set1));
        res.add(new ArrayList<Integer>(set2));
        return res;
    }
}
