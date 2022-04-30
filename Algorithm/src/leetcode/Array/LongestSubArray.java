package leetcode.Array;

import java.util.*;

/**
 * 给定一个装有数字的List，返回在连续数字中，能够按照一下规则组成子数组的最大长度：
 *  1. 子数组最多由两个元素组成
 *  2. 两个元素的大小相差不能超过1
 *
 *  例如：
 *  输入 ：[ 1, 2, 3, 4, 4, 4]
 *  输出 ： 3
 *  最长的子数组为 [3 ,4 ,4, 4]，
 */
public class LongestSubArray {
    // 思路：这题肯定可以实现线性遍历,双指针
    public int longestSubArray(List<Integer> arr){
        int n = arr.size();
        if(n<=1) return n;
        HashSet<Integer> set = new HashSet<>();
        set.add(arr.get(0));
        int maxLen = 0;
        int left = 0;
        int right = 1;
        while(right<n){
            int cur = arr.get(right);
            if(Math.abs(cur-arr.get(left))>1){
                left=right;
                right++;
                set.clear();
                set.add(arr.get(left));
            }
            else{
                if(set.size()<2){
                    set.add(cur);
                }
                if(set.contains(cur)){
                    maxLen = Math.max(right-left+1,maxLen);
                    right++;
                }
                else{
                    left = right-1;
                    set.clear();
                    set.add(arr.get(left));
                    set.add(arr.get(right));
                    right++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num==-1) break;
            list.add(num);
        }
        LongestSubArray l = new LongestSubArray();
        int n = l.longestSubArray(list);
        System.out.println(n);
    }
}
