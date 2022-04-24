package Compete;

/**
 * 给你一个下标从 0diff开始的二维整数数组diffflowersdiff，其中diffflowers[i] = [starti, endi]diff表示第diffidiff朵花的 花期diff从diffstartidiff到diffendidiff（都 包含）。同时给你一个下标从 0diff开始大小为 ndiff的整数数组diffpersonsdiff，persons[i]diff是第diffidiff个人来看花的时间。
 *
 * 请你返回一个大小为 ndiff的整数数组diffanswerdiff，其中diffanswer[i]是第diffidiff个人到达时在花期内花的diff数目diff。
 *
 * diff
 *
 * 示例 1：
 *
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], persons = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 */
import java.util.*;
public class FlowerInFullBloom {
    // 思路：差分数组。但是数据量最大为1e9，需要用HashMap而不是arr
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        // 差分+排序优化
        int n = persons.length;
        int[] res = new int[n];
        // 构建离散化差分映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }
        // 提取有变化的时刻并排序
        List<Integer> times = new ArrayList<>(map.keySet());
        times.sort(Comparator.comparingInt(a -> a));
        // 这里返回的结果要还要保证persons原来的顺序,因此建立索引与数据映射
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = i;
            p[i][1] = persons[i];
        }
        // 按照p[1]升序排列.也就是越早来的人排在越前面,同时保留索引信息
        Arrays.sort(p, Comparator.comparingInt(a -> a[1]));
        // t表示花数目有变化的时刻,sum表示差分在当前处的累计值
        int t = 0, sum = 0;
        for (int[] pair : p) {
            // 寻找在person[i]之前的变化量,从而实现局部求解当前person拥有花的数目
            while (t < times.size() && times.get(t) <= pair[1]) {
                // 累加进结果
                sum += map.get(times.get(t++));
            }
            // 在对应的person处写入当前sum
            res[pair[0]] = sum;
        }
        return res;
    }
}
