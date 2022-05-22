package leetcode.String;

public class LargestThreeSameDigitial {
    // 一次遍历 7ms， 没有做相同数字的跳过.
    public String largestGoodInteger(String num) {
        String ans = "";
        int n = num.length();
        int i =0;
        if(n<3) return ans;
        while(i+2<n){
            char cur = num.charAt(i);
            char next = num.charAt(i+1);
            char nnext = num.charAt(i+2);
            if(cur==next && next==nnext){
                if(ans.equals(""))
                    ans = cur+""+cur+""+cur;
                else if(ans.charAt(0)<cur)
                    ans = cur+""+cur+""+cur;
                i+=2;
            }
            else i++;
        }
        return ans;
    }
    // 0ms
    public String largestGoodIntegerByInsideFun(String num){
        String[] strings = {"999","888","777","666","555","444","333","222","111","000"};
        for(String s:strings){
            if(num.contains(s))
                return s;
        }
        return "";
    }
}
