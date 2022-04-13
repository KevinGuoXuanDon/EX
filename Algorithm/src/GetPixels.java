/**
 * 需求：
 * 给定一个像素值列表，现在有一个算法，需要对每个像素，找出其右侧第一个比该像素值大的像素点，进行某种计算。
 * 如果后面没有比该像素大的像素值，则直接使用当前的像素值。
 *
 * 输入:
 * 给定一个列表 pixels = [73, 74, 75, 71, 69, 72, 76, 73]
 * 输出：，
 * 输出应该是 [74, 75, 76, 72, 72, 76, 76, 73]
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
public class GetPixels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 获取输入数组
            String[] input = sc.nextLine().split(" ");
            // 生成对应的int array
            int[] pixels = new int[input.length];
            for(int i=0;i<input.length;i++){
                pixels[i] = Integer.valueOf(input[i]);
            }
            // 答案数组
            int[] res = new int[pixels.length];
            // 用栈进行存储
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(0);
            int index = 1;
            // 优化结构
            while(index<pixels.length){
                if(!deque.isEmpty() && pixels[index]>pixels[deque.peek()]){
                    res[deque.pop()] = pixels[index];
                }
                else{
                    deque.push(index);
                    index++;
                }
            }
            // 最后可能栈内有元素残留，需要添加到res中
            while(!deque.isEmpty()){
                int num = deque.pop();
                res[num] = pixels[num];
            }
            Arrays.stream(res).forEach(System.out::print);
        }
    }
}
