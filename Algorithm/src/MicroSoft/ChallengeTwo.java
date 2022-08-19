package MicroSoft;

import java.util.Comparator;
import java.util.TreeMap;

public class ChallengeTwo {
    public String solution(String s) {
        // write your code in Java 11 (Java SE 11)
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (char c : s.toCharArray()) {
            int value = c - '0';
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int singleMax = 0;
        for (int i : map.keySet()) {
            if (map.get(i) >= 2) {
                int count = map.get(i) / 2;
                for (int j = 0; j < count; j++) {
                    sb.append(i);
                }
                if (map.get(i) % 2 != 0) {
                    singleMax = Math.max(singleMax, i);
                }
            } else {
                singleMax = Math.max(singleMax, i);
            }
        }
        String res = sb.toString() + singleMax + sb.reverse().toString();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        ChallengeTwo c = new ChallengeTwo();
        c.solution("09091122");
    }
}
