package Huawei;
import java.util.*;
public class ProblemRecord {
    /**
     * 处理：
     * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。
     *          对相同的错误记录只记录一条，但是错误计数增加。
     *          最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。
     *          也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
     * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
     *
     * 输入：
     * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
     * E:\je\rzuwnjvnuz 633
     * C:\km\tgjwpb\gy\atl 637
     * F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
     * E:\ns\mfwj\wqkoki\eez 648
     * D:\cfmwafhhgeyawnool 649
     * E:\czt\opwip\osnll\c 637
     * G:\nt\f 633
     * F:\fop\ywzqaop 631
     * F:\yay\jc\ywzqaop 631
     * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
     *
     * 输出：
     * rzuwnjvnuz 633 1
     * atl 637 1
     * rwyfvzsopsuiqjnr 647 1
     * eez 648 1
     * fmwafhhgeyawnool 649 1
     * c 637 1
     * f 633 1
     * ywzqaop 631 2
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //因为要要获取最后几条记录，需要用LinkedHashMap.普通的hashmap散列排布，实现需要再加一个list.
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String a = sc.nextLine();
            //获取\之后的文件名
            String[] strings = a.split("\\\\");
            String s = strings[strings.length-1];
            //处理文件名
            String[] string = s.split(" ");
            s = s.substring(Math.max(string[0].length()-16,0));
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(map.size()-count<=8){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
            count++;
        }
    }

}
