package leetcode.Hash;

import java.util.*;
/**
 * @author Xuandong Guo
 * @date 26/09/2022
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 *
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 */
public class CheckArrayConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces){
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int[] i: pieces){
            map.put(i[0],i);
        }
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int[] nums = map.get(arr[i]);
                for(int j =0; j< nums.length; j++){
                    if(nums[j] != arr[i]){
                        return false;
                    }
                    i++;
                }
                i--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
