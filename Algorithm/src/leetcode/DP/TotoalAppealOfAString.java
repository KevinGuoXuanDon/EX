package leetcode.DP;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2262. 字符串的总引力
 * 字符串的 引力 定义为：字符串中 不同 字符的数量。
 *
 * 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
 * 给你一个字符串 s ，返回 其所有子字符串的总引力 。
 *
 * 子字符串 定义为：字符串中的一个连续字符序列。
 * 示例 1：
 *
 * 输入：s = "abbca"
 * 输出：28
 * 解释："abbca" 的子字符串有：
 * - 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
 * - 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
 * - 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
 * - 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
 * 引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
 *  tips:
 *  1 <= s.length <= 105
 */
public class TotoalAppealOfAString {

    /**
     * 例：abbac
     * a           : 1                 此时a第一次出现的作用范围是 1， 新增串：(a) 都是贡献串
     * ab          : 1 + 2             b第一次出现的作用范围是 2， 新增串：(ab,b) 都是贡献串
     * abb         : 1 + 2 + 1         b重复了作用范围是上次b出现位置和当前位置的差即为1 新增串：(abb, bb, b)贡献串只有b
     * abbc        : 1 + 2 + 1 + 4     c第一次出现作用范围是4 新增串：(abbc, bbc, bc, c)都是贡献串
     * abbca       : 1 + 2 + 1 + 4 + 4 a重复和上次位置差为4， 新增串: (abbca, bbca, bca, ca, a) 贡献串为(bbca,bca,ca,a)
     * 总和为28
     */

    public long appealSumByDP(String s) {
        long sum = 0;
        long ans = 0;
        int[] idx = new int[26];
        for(int i = 0; i < s.length(); i++){
            sum += i - idx[s.charAt(i) - 'a'] + 1;
            ans += sum;
            idx[s.charAt(i) - 'a'] = i + 1;
        }
        return ans;
    }

    // 尝试使用回溯和迭代失败，数据量过大超时，说明O(n^2)级别不被接纳
    public long appealSum(String s) {
        long res = 0L;
        for(int index = 0; index< s.length(); index++){
            HashSet<Character> set = new HashSet<>();
            for (int i = index; i < s.length(); i++) {
                set.add(s.charAt(i));
                res += set.size();
            }
        }
        return res;
    }
}
