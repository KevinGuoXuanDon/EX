package leetcode;

import java.util.Arrays;
import java.util.Stack;
import redis.clients.jedis.Jedis;
public class TrappingRainWater {

//    public int trapBy(int[] height){
//        Stack<Integer> stack = new Stack<>();
//
//    }





    //N平方级别，一层一层处理，暴力破解。会超时，重新考虑使用单调栈、双指针或者动态规划
    public int trap(int[] height){
        int result=0;
        while(Arrays.stream(height).max().getAsInt()!=0){
            result+=forEachLayer(height);
            for (int i = 0; i < height.length; i++) {
                if(height[i]>0){
                    height[i]--;
                }
            }
        }
        return result;
    }
    public int forEachLayer(int[] height){
        int count=0;
        int left= 0;
        int right =height.length-1;
        while(height[left]<=0) left++;
        while(height[right]<=0) right--;
        while(left<right){
            int i = height[left];
            if(i==0){
                count++;
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
//        TrappingRainWater t = new TrappingRainWater();
//        int count = t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        System.out.println(count);
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
