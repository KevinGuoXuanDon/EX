package day2LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 简单来说就是深拷贝，其他的都不用= =
 */
public class CopyRandomList35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    /**
     * 我们检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」的创建情况。
     * 如果这两个节点中的任何一个节点的新节点没有被创建，我们都立刻递归地进行创建。
     * 当我们拷贝完成，回溯到当前层时，我们即可完成当前节点的指针赋值
     * @param head
     * @return
     */

    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了29.09%的用户

}
