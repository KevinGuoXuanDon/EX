package StimulationTest;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeMap<Character,Integer> map = new TreeMap<>();

//        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list,(o1, o2) -> o2.getValue()-o1.getValue());
        StringBuilder sb = new StringBuilder();
        map.put('a',1);
        map.put('c',2);

        List<Integer> values = new ArrayList<>();
        values.addAll(map.values());
        Collections.sort(values,(o1, o2) -> o2-o1);
    }
}
