package Huawei;
import java.util.*;

/**
 * 选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 得到加密方式后输入明文，转换为密文。
 * 如: key = 如TRAILBLAZERS, 明文: abc
 * 输出tra
 */
public class StringEncryption {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine().toLowerCase();
        String target = sc.nextLine();
        //不能用Hashset，会乱序，换成linkedhashset
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        char[] chars = key.toCharArray();
        for (char c:chars) {
            set.add(c);
        }
        int k =0;
        while(set.size()<26){
            set.add((char) ('a'+k));
            k++;
        }
        ArrayList<Character> list = new ArrayList<>(set);
        HashMap<Character,Character> map = new HashMap<>();
        int j=0;
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i,list.get(j));
            j++;
        }
        for (char c:target.toCharArray()) {
            System.out.print(map.get(c));
        }

    }
}
