package MicroSoft;

import java.util.*;

//297. 二叉树的序列化与反序列化
//      以层序遍历 非递归的方式实现，时间复杂度和空间复杂度都为O(n)
//      但是leetcode的数据非常不好看， 24ms, 27.56%
//                                  43.9MB  7.98%
//      空间使用大能理解，比较用到了两次队列，加上String[]和List，中间的存储都挺花内存x
public class Codec {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){ val =x;}
    }
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val+",");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left!=null){
                queue.offer(node.left);
                sb.append(left.val+",");
            }
            else{
                sb.append("null,");
            }
            if(right!=null){
                queue.offer(node.right);
                sb.append(right.val+",");
            }
            else{
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        //这下似乎内存开辟有点大啊..
        String[] s = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(s));
        return  getTreee(dataList);
    }
    public TreeNode getTreee(List<String> dataList){
        if(dataList.get(0).equals("null")){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!dataList.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left;
                TreeNode right;
                if(dataList.isEmpty()){
                    node.left=null;
                    break;
                }
                if(dataList.get(0).equals("null")){
                    left = null;
                    node.left=null;
                }
                else{
                    left = new TreeNode(Integer.valueOf(dataList.get(0)));
                    node.left=left;
                    queue.add(left);
                }
                dataList.remove(0);
                if(dataList.isEmpty()){
                    node.right=null;
                    break;
                }
                if(dataList.get(0).equals("null")){
                    right = null;
                    node.right=null;
                }
                else{
                    right = new TreeNode(Integer.valueOf(dataList.get(0)));
                    node.right=right;
                    queue.add(right);
                }
                dataList.remove(0);
            }
        }
        return root;
    }

    public String serializeDFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return getString(root,sb).toString();
    }
    public StringBuilder getString(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return sb;
        }
        sb.append(root.val+",");
        sb=getString(root.left,sb);
        sb=getString(root.right,sb);
        return sb;
    }

    /**
     * 递归方法完成，时间空间复杂度都是O(n)级别，16ms 53.84%
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserializeDFS(String data) {
        String[] s = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(s));
        return getTree(list);
    }
    public TreeNode getTree(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=getTree(list);
        root.right=getTree(list);
        return root;
    }
}
