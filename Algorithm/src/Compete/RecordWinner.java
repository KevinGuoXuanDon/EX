package Compete;
import java.util.*;

/**
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 * 示例 1：
 *
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 */
public class RecordWinner {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> loserMap = new HashMap<>(matches.length,0.75f);
        for(int i=0; i<matches.length; i++){
            int loserId = matches[i][1];
            loserMap.put(loserId,loserMap.getOrDefault(loserId,0)+1);
        }
        Set<Integer> winnerList = new HashSet<>();
        List<Integer> loseOneList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry :loserMap.entrySet()){
            int value = entry.getValue();
            if(value==1){
                loseOneList.add(entry.getKey());
            }
        }
        for(int i=0; i<matches.length; i++){
            int winnerId = matches[i][0];
            if(!loserMap.containsKey(winnerId)){
                winnerList.add(winnerId);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(winnerList.stream().sorted().toList());
        Collections.sort(loseOneList);
        res.add(loseOneList);
        return res;
    }
}
