package day16Sort;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 */
public class MinNumber45 {
    //快速排序
    //4ms 97.2%
    public String minNumber(int[] nums){
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i]=String.valueOf(nums[i]);
        }
        quickSort(list,0,list.length-1);
        StringBuilder result = new StringBuilder();
        for (String s:list) {
            result.append(s);
        }
        return result.toString();
    }

    private void quickSort(String[] list, int l, int r) {
        if (l>=r) return;
        int i =l, j = r;
        //取l为当前哨兵
        String temp=list[i];
        while(i<j){
            //从左往右，找到第一个比哨兵大的节点
            while(i<j && (list[i]+list[l]).compareTo(list[l]+list[i])<=0) i++;
            //从右往左，找到第一个比哨兵小的节点
            while(i<j && (list[j]+list[l]).compareTo(list[l]+list[j])>=0) j--;
            temp = list[i];
            list[i]=list[j];
            list[j] = temp;
        }
        list[i]=list[l];
        list[l]=temp;
        quickSort(list,l,i-1);
        quickSort(list,i+1,r);
    }

    //内置方法Arrays.sort(list, (x,y)->(x=y).compareTo(y+x));
    //后面一长串是排序规则,并且这个方法有点慢
    public String minNumber2(int[] nums) {
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(list,(x,y)->(x+y).compareTo(y+x));
        StringBuilder result = new StringBuilder();
        for (String s:list) {
            result.append(s);
        }
        return result.toString();
    }
}
