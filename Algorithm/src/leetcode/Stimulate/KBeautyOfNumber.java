package leetcode.Stimulate;

public class KBeautyOfNumber {
    public static int divisorSubstrings(int num, int k) {
        StringBuilder sb = new StringBuilder(num+"");
        int res = 0;
        for(int i=0; i<=sb.length()-k; i++){
            String s = sb.substring(i,i+k);
            long l = Long.valueOf(s);
            if(l==0) continue;
            if(num%l==0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
    }
}
