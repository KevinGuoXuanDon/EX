package MicroSoft;
import java.util.*;
public class ChallengeThree {
    Set<Integer> visited;
    HashMap<Integer,Integer> people= new HashMap<>();
    public int solution(int[] a, int[] b) {
        // write your code in Java 11 (Java SE 11)
        Map<Integer,List<Integer>> path = new HashMap<>();
        int n = a.length;
        for(int i=0; i<n; i++){
            List<Integer> list = path.getOrDefault(a[i], new ArrayList<>());
            list.add(b[i]);
            path.put(a[i],list);
            List<Integer> list2 = path.getOrDefault(b[i], new ArrayList<>());
            list2.add(a[i]);
            path.put(b[i],list2);
        }
        visited = new HashSet<>();
        getPeople(path,0);
        visited.clear();
        int fuel = getFuel(path,0);
        System.out.println(fuel);
        return fuel;
    }
    public int fuel(Map<Integer,List<Integer>> path, int node){
        int fuel;
        if(node==0){
            fuel = 0;
        }
        else{
            int peopleNum = people.get(node);
            if(peopleNum<=5){
                fuel = 1;
            }
            else{
                fuel = peopleNum%5==0? peopleNum/5:peopleNum/5+1;
            }
        }
        return fuel;
    }
    public int getFuel(Map<Integer,List<Integer>> path, int node){
        int fuel= fuel(path,node);

        if(visited.contains(node)){
            return  0;
        }
        visited.add(node);
        List<Integer> nextNode = path.get(node);
        for(int i:nextNode){
            fuel+= getFuel(path,i);
        }
        return fuel;
    }

    public int getPeople(Map<Integer,List<Integer>> path, int node){
        if(visited.contains(node)){
            return 0;
        }
        visited.add(node);
        int peopleNum = 1;
        List<Integer> nextNode = path.get(node);
        for(int i:nextNode){
            peopleNum+= getPeople(path,i);
        }
        people.put(node,peopleNum);
        return peopleNum;
    }

    public static void main(String[] args) {
        ChallengeThree c = new ChallengeThree();
        c.solution(new int[]{1,1,1,9,9,9,9,7,8}, new int[]{2,0,3,1,6,5,4,0,0});

        for(int i : c.people.keySet()){
            System.out.println(i +" "+ c.people.get(i));
        }
    }
}
