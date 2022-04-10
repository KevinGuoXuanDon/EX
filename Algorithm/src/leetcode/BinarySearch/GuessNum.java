package leetcode.BinarySearch;

/**
 *  猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 */
public class GuessNum {
    private static int k = 6;
    public int guess(int num){
        if(num==k) return 0;
        else if(num>k) return -1;
        else return 1;
    }
    public int guessNumber(int n) {
        return binarySearch(1,n);
    }
    public int binarySearch(int left, int right){
        int mid = left+(right-left)/2;
        while(left<right){
            int res = guess(mid);
            if(res==0) {
                return mid;
            }
            else if(res==1){
                left = mid+1;
                return binarySearch(left,right);
            }
            else{
                right = mid;
                return binarySearch(left,right);
            }
        }
        return mid;
    }
}
