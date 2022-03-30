package Huawei;

/**
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括 0
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 输出：
 * 5
 * 说明：
 * 可以表示出0，1，2，3，4五种重量。
 */
import java.util.*;
public class WeightIndication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] nums =new int[n];
        for(int i=0;i<n;i++){
            weight[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=0;i<n; i++){
            ArrayList<Integer> list = new ArrayList<>(set);
            for(int j=0;j<=nums[i];j++){
                for(int k=0;k<list.size();k++){
                    set.add(list.get(k)+weight[i]*j);
                }
            }
        }
        System.out.println(set.size());
    }
}
