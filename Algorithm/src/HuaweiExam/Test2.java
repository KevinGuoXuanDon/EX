package HuaweiExam;


import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("");
                continue;
            }
            String ans = "";
            int maxTime = 1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    int length = sub.length();
                    int time = 1;
                    int index = j;
                    while (index + length <= s.length() && sub.equals(s.substring(index, index + length))) {
                        time++;
                        index += length;
                    }
                    if (time == 1) continue;
                    if (time > maxTime) {
                        ans = sub;
                        maxTime = time;
                    } else if (time == maxTime) {
                        //机考这里没写出来，一个是因为看错问题导致重做时间不够
                        //另一个是按字典顺序第一反应没有想到用PriorityQueue，而是手动完成
                        int max = Math.max(ans.length(), sub.length());
                        System.out.println("enter " + ans + " " + sub);
                        boolean flag = false;
                        for (int m = 0; m < max; m++) {
                            if (m >= sub.length()) {
                                flag = true;
                                break;
                            }
                            if (m >= ans.length()) {
                                flag = false;
                                break;
                            }
                            if (sub.charAt(m) < ans.charAt(m)) {
                                flag = true;
                                break;
                            }
                            if (sub.charAt(m) > ans.charAt(m)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) ans = sub;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
