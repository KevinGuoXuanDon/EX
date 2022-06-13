package Compete;

import java.util.Arrays;

/**
 * 给你两个正整数数组spells 和potions，长度分别为n 和m，
 * 其中spells[i]表示第i个咒语的能量强度，potions[j]表示第j瓶药水的能量强度。
 * 同时给你一个整数success。一个咒语和药水的能量强度 相乘 如果大于等于success，那么它们视为一对成功的组合。
 * 请你返回一个长度为 n的整数数组pairs，其中pairs[i]是能跟第 i个咒语成功组合的 药水数目。
 * 示例 1：
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 */
public class SuccessfullPairs {
    // 脑子里下意识的第一反应是直接暴力，时间复杂度n平方级别超时
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        int index = 0;
        for(int i:spells){
            int count = 0;
            for(int j:potions){
                if((long)i*(long)j>=success){
                    count++;
                }
            }
            res[index] = count;
            index++;
        }
        return res;
    }
    // 二分查找，对potions进行排序，小的如果能够success就不需要再往后遍历，说明只需要找到临界点的potion
    public int[] successfulPairsByBinarySearch(int[] spells, int[] postions, long success){
        int n = spells.length;
        int m = postions.length;
        int[] res = new int[spells.length];
        Arrays.sort(postions);
        for(int i = 0;i<n;i++){
            res[i] = m-binarySearch(spells[i],postions,success);
        }
        return res;
    }

    public int binarySearch(int spell, int[] potions, long success){
        if((long)spell * (long) potions[potions.length-1]<success) return potions.length;
        int l =0, r= potions.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if((long)potions[mid]*(long)spell>=success){
                r  = mid;
            }
            else{
                l = mid +1;
            }
        }
        return r;
    }
}
