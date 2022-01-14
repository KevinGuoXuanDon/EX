package day10DynamicProgramming;

public class TranslateNum46 {
    //类比于斐波那契数列，但是多了一个条件，如果两个数字拼接后的值在0-25之间，动态转移方程为f(n)=f(n-1)+f(n-2)
    //否则为f(n) = f(n-1)
    //0ms 100%
    //35MB 88%
    public int translateNum(int num){
        String s = String.valueOf(num);
        int length = s.length();
        if(length==1) return 1;
        int[] dp = new int[length];
        dp[0]=1;
        if(s.charAt(0) == '1' || (s.charAt(0)=='2'&&s.charAt(1)<='5'))
            dp[1] = 2;
        else dp[1] = 1;
        for (int i = 2; i < length; i++) {
            if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2'&&s.charAt(i)<='5')){
                dp[i] = dp[i-1]+dp[i-2];
            }
            else dp[i] = dp[i-1];
        }
        return dp[length-1];
    }

    //类比斐波那契数列，那么其实可以对上述代码进行优化
    //0ms 100%
    //35.3MB 37.4%
    public int translateNum1(int num){
        String s = String.valueOf(num);
        int length = s.length();
        int num1=0,num2=0,sum=1;//num1代表f(n-2),num2代表f(n-1),sum代表指向到当前数字时对应的解法
        //因为for循环从i从0开始执行n次，所以对应一开始的f(0)=1,sum就是1, num2=f(-1)=0; num1=f(-2)=0
        for (int i = 0; i < length; i++) {
            //开始往后递推,先移动俩指针
            num1=num2;
            num2=sum;
            //此时开始计算i位置的最大翻译数量，首先无论如何都可以先加f(n-1)
            sum=0;
            sum+=num2;
            //如果两个数字取出来在0-25之间，说明此时还可以加上f(n-2),即f(n)=f(n-1)+f(n-2),否则f(n)=f(n-1)
            if(i==0) continue;//只有一个数字就不要判断了
            String s1= s.substring(i-1,i+1);//substring()的区间得注意左闭右开,所以是(i-1,i+1)
            if(s1.compareTo("25")<=0 && s1.compareTo("10")>=0){
                sum+=num1;
            }
        }
        return sum;
    }

    //这样看来好像也没啥优化啊= =
    //反而多消耗了0.3的内存？？？
}
