package leetcode.Stimulate;

/**
 * 给你两个长度相同的整数数组target和arr。每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 *
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 *
 */
import java.util.Map;
import java.util.HashMap;
public class TwoArrayEqual {
    /**
     * 控制时间复杂度和空间复杂度都为O(n)级别，两次遍历解决
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length!=arr.length){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:target){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int j:arr){
            if(map.containsKey(j)){
                if(map.get(j)<=0) {
                    return false;
                }
                else{
                    map.put(j,map.get(j)-1);
                }
            }
            else return false;
        }
        return true;
    }
}
