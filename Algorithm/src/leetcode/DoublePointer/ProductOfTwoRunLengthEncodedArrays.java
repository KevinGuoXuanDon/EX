package leetcode.DoublePointer;

import java.util.*;
public class ProductOfTwoRunLengthEncodedArrays {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int idx1 = 0, idx2 = 0;
        int cnt1 = 0, num1 = 0, cnt2 = 0, num2 = 0;
        int cnt = 0, num = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (idx1 < encoded1.length || idx2 < encoded2.length) {
            if (cnt1 == 0) {
                cnt1 = encoded1[idx1][1];
                num1 = encoded1[idx1][0];
                idx1++;
            }
            if (cnt2 == 0) {
                cnt2 = encoded2[idx2][1];
                num2 = encoded2[idx2][0];
                idx2++;
            }
            int newNum = num1 * num2;
            int newCnt = Math.min(cnt1, cnt2);
            cnt1 -= newCnt;
            cnt2 -= newCnt;
            if (newNum == num) {
                cnt += newCnt;
            } else {
                if (cnt != 0) {
                    ans.add(Arrays.asList(num, cnt));
                }
                num = newNum;
                cnt = newCnt;
            }
        }
        if (cnt != 0) {
            ans.add(Arrays.asList(num, cnt));
        }
        return ans;
    }

    public List<List<Integer>> findRLEArrayByStimulate(int[][] encoded1, int[][] encoded2) {
        int[] arr1 = getArr(encoded1);
        int[] arr2 = getArr(encoded2);
        int n = arr1.length;
        int[] target = new int[n];
        for(int i=0; i<n; i++){
            target[i] = arr1[i] * arr2[i];
        }
        List<List<Integer>> res = new ArrayList<>();
        int i=0;
        while(i<n){
            int count = 1;
            while(i+1<n && target[i]==target[i+1]){
                count++;
                i++;
            }
            List<Integer> list = new ArrayList<>();
            list.add(target[i]);
            list.add(count);
            res.add(list);
            i++;
        }
        return res;
    }


    public int[] getArr(int[][] encoded){
        int len = 0;
        for(int[] nums:encoded){
            len += nums[1];
        }
        int[] res =new int[len];
        int index = 0;
        for(int[] nums:encoded){
            int value = nums[0];
            for(int i =0; i < nums[1]; i++){
                res[index] = value;
                index++;
            }
        }
        return res;
    }
}
