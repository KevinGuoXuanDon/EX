package StimulationTest;

import java.util.*;
public class HighestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        String[] strs = sc.nextLine().split(" ");
        int[] scores = new int[n];
        for (int i = 0; i < strs.length; i++) {
            scores[i] = Integer.valueOf(strs[i]);
        }
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("U")) {
                int index = Integer.valueOf(line[1])-1;
                int newScore = Integer.valueOf(line[2]);
                scores[index] = newScore;
            } else if (line[0].equals("Q")) {
                int start = Integer.valueOf(line[1]) - 1;
                int end = Integer.valueOf(line[2]) - 1;
                start = Math.min(start,end);
                end = Math.max(start,end);
                int max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    max = Math.max(max, scores[i]);
                }
                System.out.println(max);
            }
        }
    }

}
