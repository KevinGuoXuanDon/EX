package leetcode;
import java.util.*;
public class AllPossiblePath {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // return bfs(graph);
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> temp =new LinkedList<>();
        backtrack(graph,list,0,temp);
        return list;
    }
    public void backtrack(int[][] graph, List<List<Integer>> list, int cur, List<Integer> temp){
        temp.add(cur);
        if(cur== graph.length-1){
            //这里不能直接add temp，会是空
            list.add(new LinkedList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        for(int i:graph[cur]){
            backtrack(graph, list, i, temp);
        }
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> bfs(int[][] graph){
        List<List<Integer>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.index==graph.length-1){
                list.add(node.path);
            }
            //每一个当前通向的节点
            for(int i:graph[node.index]){
                queue.offer(new Node(i,node.path));
            }
        }
        return list;
    }
    class Node{
        int index;
        //从某路径当当前节点
        List<Integer> path;
        Node(int index){
            this.index = index;
            path = new LinkedList<>();
            path.add(index);
        }
        Node(int index, List<Integer> path){
            this.index = index;
            this.path = new LinkedList<>(path);
            this.path.add(index);
        }
    }
}
