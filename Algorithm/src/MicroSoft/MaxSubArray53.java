package MicroSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxSubArray53 {
    int[] result;
    public int maxSubAarray(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int pre = 0, max = nums[0];
        for (int i : nums) {
            if(i>=pre+i){
                pre=i;
                arrayList.removeAll(arrayList);
                arrayList.add(i);
            }
            else{
                pre=pre+i;
                arrayList.add(i);
            }
            if(pre>=max){
                max=pre;
                System.out.println();
                result=arrayList.stream().mapToInt(Integer::valueOf).toArray();
            }
        }
        Arrays.stream(result).forEach(System.out::println);
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        maxSubArray53.maxSubAarray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
