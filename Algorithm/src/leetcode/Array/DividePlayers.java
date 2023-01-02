package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xd_guo
 */
public class DividePlayers {
    /**
     * 每个人有自己的技能点，两人一组，每组的技能点和需要相通。
     * 返回最后总值，总值为每组的技能点乘积和
     *
     *  时间复杂度O(n)
     */
    public long dividePlayers(int[] skill) {
        int groupNum = skill.length / 2;
        int skillOfGroup = Arrays.stream(skill).sum()/groupNum;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        long res = 0;
        for(int i:skill){
            int target = skillOfGroup - i;
            if(map.containsKey(target) && map.get(target)>0){
                count++;
                res += target * i;
                map.put(target,map.get(target)-1);
                continue;
            }
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(count == groupNum){
            return res;
        }
        return -1;
    }
}
