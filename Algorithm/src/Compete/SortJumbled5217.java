package Compete;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortJumbled5217 {
    //算法复杂度o(n*m)，n为nums长度，m为中间单个数字长
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] result = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 1;
            int temp = nums[i];
            while (temp != 0) {
                int b = temp % 10;
                sum = mapping[b] * count + sum;
                count *= 10;
                temp /= 10;
            }
            result[i][0] = sum;
            result[i][1] = nums[i];
        }
        //这题主要卡在做完转换后的排序，没有想到用二维数组保存
        // 然后直接lambda表达式对转换后的位置进行排序，再把nums引射出来
        //自己手写了个冒泡排序交换，n平方复杂度直接超时。
        Arrays.sort(result,((o1, o2) -> o1[0]-o2[0]));
        for (int i = 0; i < nums.length; i++) nums[i] = result[i][1];
        return nums;
    }

    public int[] sortJumbled2(int[] map, int[] nums) {
        int[][] a = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
            for (int j = 0; j < sb.length(); j++) {
                sb.setCharAt(j, (char) (map[sb.charAt(j) - '0'] + '0'));
            }
            a[i][0] = Integer.parseInt(sb.toString());
            a[i][1] = nums[i];
        }
        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < nums.length; i++) nums[i] = a[i][1];
        return nums;
    }

}
