package leetcode;

import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * ages[y] <= 0.5 * ages[x] + 7
 * ages[y] > ages[x]
 * ages[y] > 100 && ages[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 */
public class FriendsOfAppropriateAges {
    /**
     * 三个限制条件的总结：对于每个用户x在寻找好友时，对于其他年龄小的用户不考虑（条件2和条件3）；
     * 考虑的区间在：（ 0.5* ages[x]+7,ages[x]] ,  当age[x]<15时，无法满足条件
     * 实现思路：排序+双指针。
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int result =0 , left = 0 ,right = 0;
        for(int x:ages){
            if(x<15){
                continue;
            }
            while(ages[left]<0.5*ages[x]+7){
                left++;
            }
            while(right+1<n && ages[right+1]<ages[x]){
                right++;
            }
            result += right - left;
        }
        return result;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges f = new FriendsOfAppropriateAges();
        f.numFriendRequests(new int[]{16,16});
    }
}
