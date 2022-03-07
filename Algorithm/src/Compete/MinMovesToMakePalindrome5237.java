package Compete;

public class MinMovesToMakePalindrome5237 {
    public int minMovesToMakePalindrome(String s) {
        int N = s.length();
        char[] ch = s.toCharArray();
        boolean flag = false;
        int right = N -1,count=0;
        for(int i=0;i<right;i++) {
            for(int index=right;index>=i;index--) {
                if(index==i) {
                    if(N%2==0||flag) {
                        break;
                    }
                    flag = true;
                    count = count + N/2 -i;
                } else if(ch[i]==ch[index]) {
                    for(int t=index;t<right;t++) {
                        count++;
                        char temp = ch[t];
                        ch[t] = ch[t+1];
                        ch[t+1] = temp;
                    }
                    right--;
                    break;
                }
            }
        }
        return count;
    }
}
