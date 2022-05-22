package leetcode.DP;

import java.util.HashMap;

public class SubStringWithLargestVariance {
    // 暴力肯定解不了，估计要用dp，因为s.length<= 10^4
    HashMap<Character,Integer> map = new HashMap<>();
    int max = 0;
    public int largestVariance(String s) {
        recur(s,0);
        return max;
    }
    public void recur(String s, int i) {
        if (!map.isEmpty()) {
            int ans = map.values().stream().mapToInt(Integer::valueOf).max().getAsInt() - map.values().stream().mapToInt(Integer::valueOf).min().getAsInt();

            max = Math.max(ans, max);
        }
        for (int j = i; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            recur(s, j + 1);
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
            if (map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
        }
    }
}
