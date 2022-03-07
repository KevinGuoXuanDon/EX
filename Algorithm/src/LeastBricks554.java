import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。
 * 这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 * 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 计算每一行中有哪些点可以不用穿过砖块，加入到map中，然后从map中找出所有行中，那个点出现次数最高，说明它漏穿漏这么多行砖块
 * 那么最小穿过砖块数量就是总行数-这个点漏穿次数
 */
public class LeastBricks554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list:wall){
            int size = list.size();
            int pos = 0;
            for(int i=0;i<size-1;i++){
                pos+=list.get(i);
                map.put(pos,map.getOrDefault(pos,0)+1);
            }
        }
        int result =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            result = Math.max(result,entry.getValue());
        }
        return wall.size()-result;
    }
}
