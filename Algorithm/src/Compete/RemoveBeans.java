package Compete;

import java.util.*;

public class RemoveBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long count=0;
        int n= beans.length;
        int min=Integer.MAX_VALUE;
        int last = beans[n-1];
        for (int i = 0; i < n; i++) {
            if(2*beans[i]<last){
                count+=beans[i];
                beans[i]=0;
            }
            else{
                min=Math.min(min,beans[i]);
            }
        }
        for (int i:beans) {
            if(i==0) continue;
            else{
                count+=i-min;
            }
        }
        return count;
    }
}
