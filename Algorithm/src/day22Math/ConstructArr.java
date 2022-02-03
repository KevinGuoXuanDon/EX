package day22Math;

/**
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 所有数字自身，乘以其他任何数字，储存到新的数组中
 * result[0] = 1                    *1*a[1]...*a[4]*a[5]
 * result[1] = 1*a[0]               *1*a[2]...*a[4]*a[5]
 * result[2] = 1*a[0]*a[1]          *1*a[3]*a[4]*a[5]
 * result[3] = 1*a[0]*a[1]...*a[2]  *1*a[4]*a[5]
 * result[4] = 1*a[0]*a[1]...*a[3]  *1*a[5]
 */
//倒三角乘法时间复杂度为o(n)
public class ConstructArr {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
