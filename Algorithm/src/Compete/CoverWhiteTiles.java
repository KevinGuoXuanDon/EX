package Compete;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 6023. 用地毯覆盖后的最少白色砖块 显示英文描述
 * 通过的用户数684
 * 尝试过的用户数1399
 * 用户总通过次数793
 * 用户总提交次数3908
 * 题目难度Hard
 * 给你一个下标从 0 开始的 二进制 字符串 floor ，它表示地板上砖块的颜色。
 *
 * floor[i] = '0' 表示地板上第 i 块砖块的颜色是 黑色 。
 * floor[i] = '1' 表示地板上第 i 块砖块的颜色是 白色 。
 * 同时给你 numCarpets 和 carpetLen 。你有 numCarpets 条 黑色 的地毯，每一条 黑色 的地毯长度都为 carpetLen 块砖块。请你使用这些地毯去覆盖砖块，使得未被覆盖的剩余 白色 砖块的数目 最小 。地毯相互之间可以覆盖。
 *
 * 请你返回没被覆盖的白色砖块的 最少 数目。
 */
public class CoverWhiteTiles {
    //试图贪心算法，失败了.无法解决下面两种输入，因为贪心铺地毯时默认是不重叠的，只能通过dp解决
    //"0101111"
    //2
    //3
    //"1111010"
    //2
    //3
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        StringBuilder sb = new StringBuilder(floor);
        if(numCarpets*carpetLen>floor.length()) return 0;
        for(int i=0;i<numCarpets;i++){
            TreeMap<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());
            int j=0;
            while(j<sb.length()){
                char temp = sb.charAt(j);
                if(temp=='0'){
                    j++;
                }
                else{
                    int count=0;
                    while (j<sb.length() && sb.charAt(j)=='1'){
                        count++;
                        j++;
                    }
                    map.put(count,j-1);
                }
            }
            if(!map.isEmpty()){
                int len = map.firstKey();
                int end = map.get(map.firstKey());
                int start = carpetLen>len? end-len:end-carpetLen;
                sb=sb.replace(start+1,(end+1),"");
            }
        }
        int ans=0;
        for (char c:sb.toString().toCharArray()) {
            if(c=='1') ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CoverWhiteTiles c = new CoverWhiteTiles();
        c.minimumWhiteTiles("01101",2,1);
    }
}
