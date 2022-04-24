package Compete;

import java.util.*;

public class CountPointOfRectangle {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] count = new int[points.length];

        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        //先将`y`的取值存放到一个线性表中
        //这里我是为了省去判重的步骤，直接使用treeset，后面再将值存入线性表
        Set<Integer> set = new TreeSet<>();

        //哈希表中存储具有y高度的，x的取值
        Map<Integer, List<Integer>> map = new HashMap<>();
        //循环按上面所说的要求存储
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1];
            map.putIfAbsent(y, new ArrayList<>());

            set.add(y);
            map.get(y).add(x);
        }
        //set中的值入表
        List<Integer> height = new ArrayList<>(set);

        int p = 0;

        for (int[] point : points) {
            int x = point[0], y = point[1];
            int startIdx = 0, sum = 0;
            //对于pinots中的每一个点，我们都先从先前的线性表height中遍历取得大于等于y的最小值
            //这里最多循环100次，因此直接线性查找即可
            while (startIdx < height.size() && height.get(startIdx) < y) startIdx++;

            while (startIdx < height.size()) {
                //获得以y为高度的，所有x的取值的表
                int h = height.get(startIdx);
                List<Integer> list = map.get(h);

                //二分查找符合要求的x的下标
                int q = binarySearch(list, x);
                //sum加上符合要求的个数
                sum += list.size() - q;
                //继续向后遍历
                startIdx++;
            }
            count[p] = sum;
            p++;
        }
        return count;
    }

    //这里我们的二分查找，是要找到大于等于point[0]的最小值
    int binarySearch(List<Integer> list, int x) {
        //表中的最大值都小于x，则不可能符合要求，直接返回
        if (list.get(list.size() - 1) < x) return list.size();
        //确定区间
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //小于x，不符合要求，区间左移
            if (list.get(mid) < x) {
                left = mid + 1;
            } else right = mid; //否则右移
        }
        return left;
    }
}
