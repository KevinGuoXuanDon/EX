package Compete;

import java.util.*;

public class GraphGetAncestors5300 {
    /**
     * BFS,对于每一个元素去寻找直达的父节点，加入队列，在根据这些父节点去寻找其祖宗节点，直到遍历完queue长度为0
     * 这题很容易超时
     * 采用HashSet来装每个节点的祖先，需要151ms，采用TreeSet需要262ms
     * 采用list直接超时
     * @param n
     * @param edges
     * @return
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int[] i:edges) {
            map.get(i[1]).add(i[0]);
        }
        List<List<Integer>> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            //这里用list添加居然会超时，改成直接用set操作
            // List<Integer>  temp= new LinkedList<>();
            // 超时： 下面的set.add换成 temp.add
            // 并且这里HashSet要比TreeSet快100ms，因为添加元素不需要一直左旋，直接在最后Stream里计算
            queue.add(i);
            while(!queue.isEmpty()){
                int index = queue.poll();
                if(index!=i) set.add(index);
                for(int parent:map.get(index)){
                    if(!set.contains(parent))
                    queue.offer(parent);
                }
            }
            list.add(set.stream().sorted().toList());
        }
        return list;
    }
    //以下是DFS的， 76ms 86.55%
    private boolean[] marked;
    private class Disgraph{
        int V;  //顶点数
        int E;  //边数
        Queue<Integer>[] adj;//邻接表
        public Disgraph(int v){
            V=v;
            E=0;
            for(int i=0;i<v;i++){
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int v, int w){
            //从v到w的边
            adj[v].add(w);
            E++;
        }
        // 返回节点的邻接表
        public Queue<Integer> getAdj(int v){
            return adj[v];
        }

    }
    public List<List<Integer>> getAncestorByDFS(int n, int[][] edges){
        //反向建表，然后一路搜索到最后的子节点。问题成了回溯
        Disgraph rG = new Disgraph(n);
        for (int i = 0; i < edges.length; i++) {
            //反向填入
            rG.addEdge(edges[i][1],edges[i][0]);
        }
        List<List<Integer>> result = new ArrayList<>();
        //每一个都进行深度递归
        for (int i = 0; i < n; i++) {
            marked = new boolean[n];
            List<Integer> subList = new LinkedList<>();
            dfs(subList,rG,i);
            Collections.sort(subList);
            result.add(subList);
        }
        return result;
    }
    public void dfs(List<Integer> sublist, Disgraph G, int curV){
        //标记当前节点访问过了
        marked[curV] = true;
        //去除当前节点的所有子节点进行访问添加，注意子节点必须之前递归时没有访问过
        for(int next:G.adj[curV]){
            if(!marked[next]){
                sublist.add(next);
                dfs(sublist,G,next);
            }
        }
    }
}
