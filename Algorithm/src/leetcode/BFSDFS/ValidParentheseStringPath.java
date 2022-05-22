package leetcode.BFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * 一个括号字符串是一个 非空且只包含'('和')'的字符串。如果下面任意条件为真，那么这个括号字符串就是合法的。
 * <p>
 * 字符串是()。
 * 字符串可以表示为AB（A连接B），A 和B都是合法括号序列。
 * 字符串可以表示为(A)，其中A是合法括号序列。
 * 给你一个m x n的括号网格图矩阵grid。网格图中一个合法括号路径是满足以下所有条件的一条路径：
 * <p>
 * 路径开始于左上角格子(0, 0)。
 * 路径结束于右下角格子(m - 1, n - 1)。
 * 路径每次只会向 下或者向 右移动。
 * 路径经过的格子组成的括号字符串是合法的。
 * 如果网格图中存在一条 合法括号路径，请返回true，否则返回false。
 */
public class ValidParentheseStringPath {
    Deque<Character> deque = new ArrayDeque<>();
    HashSet<String> memo = new HashSet<>();

    // 记忆化搜索+dfs
    // 注意的是需要记忆的东西包括位置和当前左括号个数
    // 一个优化：其实左括号不需要用栈来存储，在添加删除上会多很多冗余时间，用常数记录就好
    public boolean hasValidPath(char[][] grid) {
        if (grid.length < 0) return false;
        int m = grid.length;
        ;
        int n = grid[0].length;
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') return false;
        return dfs(grid, 0, 0);
    }

    public boolean dfs(char[][] grid, int x, int y) {
        if (x >= grid.length)
            return false;
        if (y >= grid[0].length)
            return false;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            if (deque.size() == 1) {
                return true;
            }
        }
        if (memo.contains(x + " " + y + "" + deque.size())) return false;
        memo.add(x + " " + y + deque.size());
        if (grid[x][y] == '(') {
            deque.push('(');
            if (dfs(grid, x, y + 1)) return true;
            if (dfs(grid, x + 1, y)) return true;
            deque.pop();
        }
        if (grid[x][y] == ')') {
            if (deque.isEmpty()) return false;
            else {
                deque.poll();
                if (dfs(grid, x + 1, y)) return true;
                if (dfs(grid, x, y + 1)) return true;
                deque.push('(');
            }
        }
        return false;
    }
}
