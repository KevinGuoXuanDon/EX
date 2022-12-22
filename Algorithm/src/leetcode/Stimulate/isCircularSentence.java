package leetcode.Stimulate;

/**
 * @author xd_guo
 */
public class isCircularSentence {
    /**
     * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
     * 每个单词的结尾和下个单词的开头字符相同，且末尾单词和首个单词相同，则返回TRUE
     */
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        for(int i = 0; i<n; i++){
            if(sentence.charAt(i) == ' '){
                if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                    return false;
                }
            }
        }
        if(sentence.charAt(0) != sentence.charAt(n-1)){
            return false;
        }
        return true;
    }
}
