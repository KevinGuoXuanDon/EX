package leetcode.BFSDFS;

/**
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，返回所有二维网格上的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *输入：board = [["o","a","a","n"],
 *              ["e","t","a","e"],
 *              ["i","h","k","r"],
 *              ["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * board内都是小写字母
 * 解题方法：很容易想到DFS搜索，DFS搜索时和单词进行比对，如果还是某个单词的前缀上那么接着搜索，否则剪枝，那么需要用到字典树
 *          DFS+TRIE
 */
import java.util.*;
public class WordSearch {
    Set<String> set = new HashSet<>();
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words){
        Trie trie = new Trie();
        for(String s:words){
            trie.insert(s);
        }
        for(int i=0;i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                dfs(board,trie,i,j);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, Trie trie, int i, int j) {
        char cur = board[i][j];
        int index = cur-'a';
        if(cur=='.' || trie.nodes[index]==null) {
            return;
        }
        trie = trie.nodes[index];
        if(trie.isWord){
            set.add(trie.word);
        }
        board[i][j] = '.';
        //往其他四个方向拓展
        for (int[] dir : dirs) {
            int i2 = i + dir[0], j2 = j + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, trie, i2, j2);
            }
        }
        board[i][j] = cur;
    }

    class Trie{
        Trie[] nodes;
        boolean isWord;
        String word;
        public Trie(){
            nodes = new Trie[26];
            isWord = false;
            word = "";
        }
        public void insert(String word){
            Trie trie = this;
            for(int i=0; i<word.length();i++){
                char c = word.charAt(i);
                int index = c-'a';
                if(trie.nodes[index]==null){
                    trie.nodes[index] = new Trie();
                }
                trie = trie.nodes[index];
            }
            trie.isWord = true;
            trie.word = word;
        }
    }
}
