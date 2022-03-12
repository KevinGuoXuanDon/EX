package Huawei;
import java.util.*;
public class Chorus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        //左边递增子序列长度
        int[] left= new int[n];
        //右边递减子序列长度
        int[] right = new int[n];
        //每一个数字
        for (int i = 0; i < n; i++) {
            left[i]=1;
            //他之前的数字
            for (int j = 0; j < i; j++) {
                //如果之前的数字有比他小的，考虑加进来
                if(arr[i]>arr[j]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }
        //每一个数字
        for (int i = n-1; i >=0 ; i--) {
            //默认这一个数字长度为1
            right[i]=1;
            //他之后的数字
            for (int j = n-1; j >i ; j--) {
                //找到之后的数字比他小，考虑加进来
                if(arr[i]>arr[j]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            //计算每一个位置做最高点时，左边的递增序列和后边递减序列长度只和，就是合唱团长度(重复计算当前节点，需要-1)
            result[i] = left[i]+right[i]-1;
        }
        //总长度减掉最大长度就是答案
        int ans = n-Arrays.stream(result).max().getAsInt();
        System.out.println(ans);
    }
}
