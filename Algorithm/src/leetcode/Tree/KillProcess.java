package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith process and ppid[i] is the ID of the ith process's parent process.
 *
 * Each process has only one parent process but may have multiple children processes. Only one process has ppid[i] = 0, which means this process has no parent process (the root of the tree).
 *
 * When a process is killed, all of its children processes will also be killed.
 *
 * Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed. You may return the answer in any order.
 *
 * 
 *
 * Example 1:
 *
 *
 * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
 * Output: [5,10]
 * Explanation:The processes colored in red are the processes that should be killed.
 */
public class KillProcess {
    // DFS
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> parentChildren = new HashMap<>();
        for(int i = 0; i<pid.size(); i++){
            int value = pid.get(i);
            int parent = ppid.get(i);
            List<Integer> list = parentChildren.getOrDefault(parent, new ArrayList<Integer>());
            list.add(value);
            parentChildren.put(parent,list);
        }

        return kill(parentChildren,kill);
    }

    public List<Integer> kill(HashMap<Integer,List<Integer>> map, int kill){
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        if(map.containsKey(kill)){
            for(int i:map.get(kill)){
                res.addAll(kill(map,i));
            }
        }
        return res;
    }
}
