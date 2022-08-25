package leetcode.Stimulate;

/**
 * 删除一个5得到最大值
 */
public class RemoveFive {
    public int remove(int n){
        int res = 0;
        StringBuilder sb;
        boolean flag = true;
        if(n>0){
            sb = new StringBuilder(n+"");
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='5'){
                    if(i+1<sb.length() && sb.charAt(i)<sb.charAt(i+1)){
                        sb.deleteCharAt(i);
                        flag = false;
                        break;
                    }
                    else if(i==sb.length()-1 && sb.charAt(i)=='5'){
                        sb.deleteCharAt(i);
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                sb.deleteCharAt(sb.lastIndexOf("5"));
            }
            res = Integer.valueOf(sb.toString());
        }
        else{
            n = -n;
            sb = new StringBuilder(n+"");
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='5'){
                    if(i+1<sb.length() && sb.charAt(i)>sb.charAt(i+1)){
                        sb.deleteCharAt(i);
                        flag = false;
                        break;
                    }
                    else if(i==sb.length()-1 && sb.charAt(i)=='5'){
                        sb.deleteCharAt(i);
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                sb.deleteCharAt(sb.lastIndexOf("5"));
            }
            res = Integer.valueOf(sb.toString()) * -1;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveFive r = new RemoveFive();
        System.out.println(r.remove(-5859));
    }
}
