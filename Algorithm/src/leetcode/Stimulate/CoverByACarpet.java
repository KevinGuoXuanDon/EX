package leetcode.Stimulate;

import java.util.Arrays;

public class CoverByACarpet {
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
        int max = 0;
        for(int i= 0; i<tiles.length;i++){
            int[] arr = tiles[i];
            int start = arr[0];
            int end = arr[1];
            int coverEnd = start + carpetLen-1;
            int coverLen = 0;
            if(coverEnd<end){
                coverLen += coverEnd-start+1;
                max = Math.max(max,coverLen);
                continue;
            }
            else{
                coverLen+= end-start+1;
                max = Math.max(max,coverLen);
            }
            int loop = i;
            while(loop+1<tiles.length){
                loop++;
                int[] larr = tiles[loop];
                start = larr[0];
                end = larr[1];
                if(coverEnd<start) break;
                if(coverEnd<end){
                    coverLen += coverEnd-start+1;
                    max = Math.max(max,coverLen);
                    break;
                }
                else{
                    coverLen += end-start+1;
                    max = Math.max(max,coverLen);
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        maximumWhiteTiles(new int[][]{{1,1}},1);
    }
}
