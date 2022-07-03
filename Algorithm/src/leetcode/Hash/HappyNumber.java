package leetcode.Hash;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class HappyNumber {
    //Hash
    public boolean isHappy(int n){
        if(n==1){
            return true;
        }
        HashSet<Integer> set = new HashSet();
        set.add(n);
        while(n!=1){
            int sum = 0;
            while(n!=0){
                int re = n%10;
                n /=10;
                sum+= re * re;
            }
            n = sum;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            if(sum==1){
                return true;
            }
        }
        return false;
    }


    // 暴力解答打咩
    public boolean isHappyForce(int n) {
        if(n==1) return true;
        int count = 50;
        while(n!=1){
            int sum = 0;
            while(n!=0){
                int re = n%10;
                n /=10;
                sum+= re * re;
            }
            count --;
            n = sum;
            if(sum==1){
                return true;
            }
            if(count==0){
                return false;
            }
        }
        return false;
    }
}
