package Compete;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cells-in-a-range-on-an-excel-sheet/
 * 找出所有满足r1 <= x <= r2 且 c1 <= y <= c2 的单元格，
 * 并以列表形式返回。单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
 *
 * 输入：s = "K1:L2"
 * 输出：["K1","K2","L1","L2"]
 *
 * 输入：s = "A1:F1"
 * 输出：["A1","B1","C1","D1","E1","F1"]
 */
public class Excel {
    //没什么好说的，直接枚举，没啥意思
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        int a2 = s.charAt(1)-'0';
        char a1 = s.charAt(0);
        int b2 = s.charAt(4)-'0';
        char b1 = s.charAt(3);
        for (char i = a1; i <= b1; i= (char)(i+1)) {
            for (int j = a2; j <= b2; j++) {
                list.add(""+i+j);
            }
        }
        return list;
    }
}
