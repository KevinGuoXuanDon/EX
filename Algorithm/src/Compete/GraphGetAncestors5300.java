package Compete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GraphGetAncestors5300 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> hashMap =  new HashMap<>();
        for (int[] i:edges) {
            if (hashMap.containsKey(i[1])){
                hashMap.get(i[1]).add(i[0]);
                if(hashMap.get(i[0])!=null){
                    for(int temp: hashMap.get(i[0])){
                        hashMap.get(i[1]).add(temp);
                    }
                }
            }
            else{
                hashMap.put(i[1],new ArrayList<>());
                hashMap.get(i[1]).add(i[0]);
                if(hashMap.get(i[0])!=null){
                    for(int temp: hashMap.get(i[0])){
                        hashMap.get(i[1]).add(temp);
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(hashMap.get(i)==null) list.add(new ArrayList<>());
            else{
                Collections.sort(hashMap.get(i));
                list.add(hashMap.get(i));
            }
        }
        return list;
    }
}
