package leetcode.Array;

import java.util.Arrays;

public class HeightCheck {
    public int heightCheck(int[] heights){
        int[] arr = heights.clone();
        Arrays.sort(arr);
        int count= 0;
        for(int i =0; i<arr.length;i++){
            if(arr[i]==heights[i]) count++;
        }
        return heights.length-count;
    }
}
