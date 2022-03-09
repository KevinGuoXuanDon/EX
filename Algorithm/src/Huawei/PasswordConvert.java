package Huawei;
import java.util.*;
public class PasswordConvert{
    private static Map<String,String> map = new HashMap<>();
    //静态初始化、加载map容器
    static{
        map.put("1","1");
        map.put("abc","2");
        map.put("def","3");
        map.put("ghi","4");
        map.put("jkl","5");
        map.put("mno","6");
        map.put("pqrs","7");
        map.put("tuv","8");
        map.put("wxyz","9");
        map.put("0","0");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(char c :s.toCharArray()){
                if(Character.isDigit(c)){
                    sb.append(c);
                }
                else if(c>='A'&&c<='Y'){
                    c = (char)(c+32+1);
                    sb.append(c);
                }
                else if(c=='Z'){
                    sb.append('a');
                }
                else if(c>='a' && c<='z'){
                    Set<String> keys = map.keySet();
                    for(String k:keys){
                        if(k.contains(c+"")){
                            sb.append(map.get(k));
                        }
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}