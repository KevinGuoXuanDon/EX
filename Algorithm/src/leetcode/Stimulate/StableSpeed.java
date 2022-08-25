package leetcode.Stimulate;

/**
 * 稳定数字的个数
 */
public class StableSpeed {
    public int solution(int[] arr) {
        // write your code in Java 11 (Java SE 11)
        if(arr.length<=2){
            return 0;
        }
        int n = arr.length;
        int left = 0, right = 1;
        int res = 0;
        boolean flag =false;
        boolean spec = true;
        while(left!=n-2){
            if(right!=n-1){
                right ++;
            }
            if(arr[right]-arr[right-1]== arr[right-1]-arr[right-2]){
                if(right==n-1){
                    res++;
                    while(left<=right-2){
                        left++;
                        res += right - left - 1;
                    }
                    break;
                }
                else if(right<n-1){
                    res++;
                    flag = true;
                    continue;
                }
            }
            else{
                left++;
                if(flag){
                    while(left<=right-2){
                        res += right - left -2;
                        left++;
                    }
                }
                else{
                    left = right-1;
                }
                flag = false;
            }
        }
        if(res>1000000000){
            return -1;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        StableSpeed s = new StableSpeed();
        s.solution(new int[]{-2,5,7,5,3,1,3,4,6,8});
    }
}
