package Compete;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/replace-non-coprime-numbers-in-array/
 * 给你一个整数数组 nums 。请你对数组执行下述操作：
 *
 * 从 nums 中找出 任意 两个 相邻 的 非互质 数。
 * 如果不存在这样的数，终止 这一过程。
 * 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
 * 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
 *
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 *
 * 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
 */
public class ReplaceNonCoprimes6019 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==0) return list;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            int max=0,min=0,GCD=0;
            if(!stack.isEmpty()){
                 max = Math.max(nums[i],stack.peek());
                 min = Math.min(nums[i],stack.peek());
                 GCD=getGCD(min,max);
            }
            //如果满足当前的和上一个数字为非互质数
            while(!stack.isEmpty() && GCD>1){
                flag = false;
                //弹出上一个
                stack.pop();
                //这个括号很重要，否则无法通过. int 类型下，97561*97561/97561 != 97561
                int LCM = min*(max/GCD);
                if(!stack.isEmpty() ){
                    max = Math.max(LCM,stack.peek());
                    min = Math.min(LCM,stack.peek());
                    GCD=getGCD(min,max);
                    if(GCD<=1){
                        stack.push(LCM);
                        break;
                    }
                }else{
                    stack.push(LCM);
                    break;
                }
            }
            //不会发生非互质，则简单添加
            if(flag) stack.push(nums[i]);
        }
        for(int i:stack){
            list.add(i);
        }
        return list;
    }
    public int getGCD(int a, int b){
        if(a==0) return b;
        else return getGCD(b%a,a);
    }

    public static void main(String[] args) {
        ReplaceNonCoprimes6019 r = new ReplaceNonCoprimes6019();
        //r.replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561});
        r.replaceNonCoprimes(new int[]{848112460,21644184});

    }
}
