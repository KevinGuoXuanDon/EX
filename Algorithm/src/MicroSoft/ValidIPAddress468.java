package MicroSoft;

import com.sun.jdi.Value;

import java.util.Arrays;

public class ValidIPAddress468 {
    public String validIPAddress(String queryIP) {

        //如果是IPV4格式
        if(queryIP.contains(".")){
            String[] s=queryIP.split("\\.",-1);
            if(queryIP.chars().filter((ch)-> ch=='.').count()!=3) return "Neither";
            for (String item:s) {
                if(item.length()<=0||(item.length()>1 && item.charAt(0)=='0')) return "Neither";
                try {
                    int i = Integer.parseInt(item);
                    if (i > 255 || i < 0) return "Neither";
                }catch (NumberFormatException e){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        //limit -1很重要，一次测试用例死在这里，不加下面的item得不到值
        //limit=-1：表示不过滤空串。如 “a,b,c,,”.split(","-1)返回空串，默认limit=0，不返回空串
        else if(queryIP.contains(":")){
            String[] s=queryIP.split(":",-1);
            String hexdigits = "0123456789abcdefABCDEF";
            if(queryIP.chars().filter((ch)-> ch==':').count()!=7) return "Neither";
            for (String item:s) {
                if(item.length()<=0 || item.length()>4) return "Neither";
                for (char ch:item.toCharArray()) {
                    if(hexdigits.indexOf(ch)==-1) return "Neither";
                }
            }
            return "IPv6";
        }
        else{
            return "Neither";
        }
    }

    public static void main(String[] args) {
        ValidIPAddress468 v = new ValidIPAddress468();
        String b =v.validIPAddress("172.16.254.1");
        System.out.println(b);

    }
}
