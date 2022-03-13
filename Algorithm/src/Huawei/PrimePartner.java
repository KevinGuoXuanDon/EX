package Huawei;
import java.util.*;
//素数伴侣
//给一些数字，两两相加可能可以成为素数，返回能够素数的最大对数。
//比如 1 3 4 6, 1+6=5，5为素数，第一对伴侣为(1,4)。 同理7为数组，第二对伴侣为 (3,4). 返回2
public class PrimePartner {
    //用到了匈牙利算法.核心思想是先到先得，能让就让。
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            for(int i=0;i<n;i++){
                int temp = sc.nextInt();
                if(temp%2==1){
                    odd.add(temp);
                }
                else{
                    even.add(temp);
                }
            }
            //标记偶数伴侣的奇数下标
            int[] mathcedEven = new int[even.size()];
            //最终计算
            int count=0;
            for(int i=0;i<odd.size();i++){
                //注意这里，对于每个奇数，flag都是新建的
                boolean[] flag = new boolean[even.size()];
                //如果匹配上了，count增加
                if(find(odd.get(i),mathcedEven,even,flag)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    //举个例子 1 3 4 6
    //首先, 1进入循环，找到4后直接返回true. matchedEven{ 1, 0}
    //接着，3进入循环，也是先找到4，发现已经占用(matchedEven[0]=1)，那么此时重新调用方法，看看1能不能找到其他伴侣，
    //此时flag[0]已经标记true，所以1直接找下标为1的偶数(6).发现1和6也能成为，那么修改mathcedEven[1]=1
    //返回3的执行。因为1成功找到新伴侣，find（）一长串返回true，3修改偶数下标为自己，返回true. matchedEven[0]=3
    public static boolean find(int x, int[] matchedEven, List<Integer> even, boolean[] flag){
        //每一个奇数都会依次调用这个方法来寻找偶数伴侣
        for(int i=0; i<even.size(); i++){
            //如果当前这个偶数没有被访问，并且能组合为素数
            if(!flag[i] && isPrime(x+even.get(i))){
                //标记访问
                flag[i] = true;
                //进入访问之后需要进行伴侣标记。如果还没有伴侣，则和x组成伴侣，标记它的值为x，返回true
                //如果有奇数伴侣(不为x)，并且这个奇数能够找到其他伴侣find（）那一长串，那就把伴侣让给别人,自己和x组队,然后返回true.
                if(matchedEven[i]==0 || find(matchedEven[i],matchedEven,even,flag)){
                    matchedEven[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
    //是否为素数
    public static boolean isPrime(int x){
        if(x==1) return false;
        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
}
