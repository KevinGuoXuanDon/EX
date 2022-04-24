package Compete;

import java.util.*;

/**
 * 多个数组求交集
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
 * 按 升序排列 返回一个数组，数组中的每个元素在 nums所有数组 中都出现过。
 * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出：[3,4]
 */
public class IntersectionOfArrays {
    // 思想：添加第一个数组的所有元素，和后面的比对：当第一数组的某元素没有在后面的数组中出现时，把它删除
    // 5ms 100%, 但是没有利用好"不同"这个关键题设，看解法2
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeSet<Integer> container = new TreeSet<>();
        if(nums.length==0) return res;
        for(int i:nums[0]){
            container.add(i);
        }
        for(int i=1;i<nums.length;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int in:nums[i]){
                set.add(in);
            }
            // 注意这里需要用迭代器来处理集合类的删除，否则会并发修改异常
            Iterator iter = container.iterator();
            while(iter.hasNext())
                if(!set.contains(iter.next())){
                    iter.remove();
                }
            }

        res.addAll(container);
        return res;
    }
    // 4ms 100%
    public List<Integer> intersectionByHashMap(int[][] nums){
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length==0) return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int[] arr:nums){
            for(int i: arr){
                // 把所有元素装入map，统计出现次数
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        // 某个数字的出现次数和数组长度一样时，说明每个子数组都出现了它
        for(int i:map.keySet()){
            if(map.get(i)==n){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}
