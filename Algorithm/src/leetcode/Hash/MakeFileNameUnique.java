package leetcode.Hash;

import java.util.Arrays;
import java.util.HashMap;

public class MakeFileNameUnique {
    /**
     * 就是map暴力破解，map记录名字和当前排到的后缀大小，遍历map有无重复，有重复则接着往后取值直到取到了下一个无重复的正整数
     * 时间 90.22% 空间48.55%
     * @param names
     * @return
     */
    public String[] getFoldNames(String[] names){
        String[] res = new String[names.length];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<names.length; i++){
            String name = names[i];
            if(map.containsKey(name)){
                for (int j = map.get(name)+1; ; j++) {
                    String newName = name + "("+ j +")";
                    if(!map.containsKey(newName)){
                        res[i] = newName;
                        map.put(name,j);
                        map.put(newName,0);
                        break;
                    }
                }
            }
            else{
                res[i] = name;
                map.put(name,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MakeFileNameUnique m = new MakeFileNameUnique();
        String[] res = m.getFoldNames(new String[]{"gta","gta","gta(1)"});
        Arrays.stream(res).forEach(System.out::println);
    }
}
