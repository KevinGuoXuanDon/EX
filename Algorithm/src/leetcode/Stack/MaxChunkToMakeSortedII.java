package leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 示例1:
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 */
public class MaxChunkToMakeSortedII {
    /**
     * 有点像找规律的题目
     * 每次添加元素时只需要考虑，我当前元素添加会不会影响前面的快
     * 如果用一个stack来存储每个块的最大值，则有两种情况
     * 1 4 5
     * 以1 4 为第一个块
     * 如果我当前元素大于/等于前一个块的最大值，那么说明是升序的，我当前元素可以自成一块
     * 如果小于 1 4 3
     * 则我当前元素加入上一个块。
     * 3 4  5 4
     * 如果有两个块， 我新元素为 3,那么说明我当前元素要和前面的块都联合，知道找到最大值小于等于我这个元素
     * 那么此时形成一个块，并且最大元素为上一个最大值 5
     */
    public int maxChunkToSorted(int[] arr){
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<arr.length;i++){
            if(stack.isEmpty() || arr[i]>= stack.peek()){
                stack.push(arr[i]);
            }
            else{
                int lastMax = stack.pop();
                while(!stack.isEmpty() && stack.peek()>arr[i]){
                    stack.pop();
                }
                stack.push(lastMax);
            }
        }
        return stack.size();
    }
}
