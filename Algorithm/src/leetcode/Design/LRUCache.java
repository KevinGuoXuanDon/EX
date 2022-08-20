package leetcode.Design;
import java.util.*;
public class LRUCache {
    Map<Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity){
        map = new LinkedHashMap<>(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        else if(map.size() == capacity){
            Iterator<Map.Entry<Integer,Integer>> iterator =  map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key,value);
    }
}
