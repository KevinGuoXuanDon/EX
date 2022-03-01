package MicroSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals){
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            int lastIndex = merged.size()-1;
            if(merged.isEmpty() || merged.get(lastIndex)[1]<curLeft){
                merged.add(new int[]{curLeft,curRight});
            }
            else{
                //修改上一个的右端元素
                merged.get(lastIndex)[1] = Math.max(merged.get(lastIndex)[1],curRight);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
