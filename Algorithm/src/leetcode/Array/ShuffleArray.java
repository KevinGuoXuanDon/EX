package leetcode.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 打乱后，数组的所有排列应该是等可能的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * 
 *

 */
public class ShuffleArray {
    int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] shuffle = new int[nums.length];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i:nums){
            list.add(i);
        }
        int count = 0;
        while(count<shuffle.length){
            int i = (int)(Math.random()*list.size());
            int value = list.get(i);
            list.remove(i);
            shuffle[count]=value;
            count++;
        }
        return shuffle;
    }
    // 洗牌算法，类比冒泡排序思想
    public int[] shuffleFisher(){
        int[] shuffle = nums.clone();
        for(int i=0;i<nums.length;i++){
            int j = (int)(Math.random()*nums.length);
            int temp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = temp;
        }
        return shuffle;
    }
}
