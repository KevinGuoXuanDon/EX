package leetcode.Tree;
// 字典树
// 主要功能有:insert：以树形结构模拟出一个单词，每个节点储存一个字符，以isWord判断是否有以当前字符结尾的单词
// search 查看一个单词在字典树中是否存在
// startsWith： 查看是否有以某几个字符为前缀prefix的单词
public class Trie {
    private Trie[] nodes;
    private boolean isWord;
    public Trie() {
        nodes = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {
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
    }

    public boolean search(String word) {
        Trie trie = this;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(trie.nodes[index]==null){
                return false;
            }
            else{
                trie = trie.nodes[index];
            }
        }
        return trie!=null && trie.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for(int i = 0; i<prefix.length();i++){
            char c = prefix.charAt(i);
            int index = c-'a';
            if(trie.nodes[index]==null){
                return false;
            }
            else{
                trie = trie.nodes[index];
            }
        }
        return trie!=null;
    }
    public Trie getTrie(String prefix){
        Trie trie = this;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            int index = c-'a';
            if(trie.nodes[index]==null)
                return null;
            trie = trie.nodes[index];
        }
        return trie;
    }

    public boolean searchRePackage(String word) {
        Trie trie = getTrie(word);
        return trie!=null && trie.isWord;
    }

    public boolean startsWithRePackage(String prefix) {
        Trie trie = getTrie(prefix);
        return trie!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */