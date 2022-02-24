package MicroSoft;

public class NumDecodings {
    public int numDecodings(String s){
        char[] c = s.toCharArray();
        if(c[0]-'0'==0) return 0;
        int end = s.length();
        int start =0;
        int f2=1,f1=1,sum = 1;
        for (int i = start+1; i < end; i++) {
            sum=0;
            if(c[i]-'0'<=9 && c[i]-'0'>=1){
                sum+=f1;
            }
            int b =(c[i - 1] - '0') * 10 + (c[i] - '0');
            if(b>=10 && b<=26){
                sum += f2;
            }
            f2 = f1;
            f1= sum;
        }
        return sum;
    }
}
