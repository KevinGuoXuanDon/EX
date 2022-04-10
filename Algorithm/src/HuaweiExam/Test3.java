package HuaweiExam;
import java.util.*;
public class Test3 {
    static int ans ;
    static boolean[] used;
    static int[] arr;

    public static int caculate(int[] nums, int k) {
        ans = Integer.MAX_VALUE;
        used = new boolean[nums.length];
        arr = new int[k];
        dfs(nums,0,k-1,k,used,arr);
        return ans;
    }
    public static void dfs(int[] nums,int selectedNum,int curBucket,int k,boolean[] used, int[] arr) {
        // 所有篮子都装好了，那么开始比较最大值
        if (curBucket == -1) {
            int max = 0;
            for (int count : arr) {
                max = Math.max(max, count);
            }

            // 如果本次递归能够找到更小的最大值，进行更新
            ans = Math.min(ans, max);
            return;
        }
        // 如果当前篮子已经找完了，找下一个(总共n个数字，k组，一组则最多n/k个)
        if (selectedNum == nums.length / k) {
            dfs(nums, 0, curBucket - 1, k, used, arr);
        }

        for (int i = 0; i < nums.length; i++) {
            //使用过的元素就不能再使用了
            if (used[i])
                continue;
            //添加元素nums[i]
            arr[curBucket] += nums[i];
            used[i] = true;
            dfs(nums, selectedNum + 1, curBucket, k, used, arr);
            //回溯
            arr[curBucket] -= nums[i];
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = Integer.valueOf(sc.nextLine());
            String[] strings = sc.nextLine().split(" ");
            int[] nums = new int[m];
            for(int i =0; i<m;i++){
                nums[i] = Integer.valueOf(strings[i]);
            }
            int k = Integer.valueOf(sc.nextLine());
            if(k!=0 && m%k==0)
                System.out.println(caculate(nums, k));
            else
                System.out.println("0");
        }
    }
}
