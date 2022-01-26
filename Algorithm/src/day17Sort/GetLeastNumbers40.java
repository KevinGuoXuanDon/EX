package day17Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetLeastNumbers40 {
    //7ms
    public int[] getLeastNumbers(int[] arr ,int k){
        if(arr.length==0 || k<=0 || k>=arr.length) return new int[0];
        int[] result = new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            result[i]=arr[i];
        }
        return Arrays.copyOf(arr, k);

        //或者简单使用内置函数 6ms 73%
//        if(arr.length==0 || k<=0) return new int[0];
//        Arrays.sort(arr);
//        return Arrays.copyOf(arr, k);
    }

    //用最大根的栈进行操作。PriorityQueue这个栈在定义了比较方法后，在offer和poll时会动态的对存储的元素进行排序。
    //16ms 26.45%  按理说时间复杂度为O(nlogk)，应该要小于内置排序方法O(nlogn)的
    public int[] geLeastNumberByStack(int[] arr, int k){
        if(arr.length==0 || k<=0 || k>= arr.length) return new int[0];
        int[] result = new int[k];
        PriorityQueue<Integer> stack = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < k; i++) {
            stack.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(stack.peek()>arr[i]){
                stack.poll();
                stack.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i]=stack.poll();
        }
        return result;
    }

    //以下是快速排序(优化后)
    //2ms 97.05%
    public int[] getLeastNumbersByQuickSort(int[] arr, int k) {
        if(arr.length==0 || k<=0 ) return new int[0];
        if(k>= arr.length) return arr;
        return quickSort(arr,k,0,arr.length-1);
    }
    public int[] quickSort(int[] arr, int k, int l, int r){
        int i=l, j=r;
        while(i<j){
            while(i<j && arr[j]>=arr[l]) j--;
            while(i<j && arr[i]<=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        if(i>k) return quickSort(arr,k,l,i-1);
        if(i<k) return quickSort(arr,k,i+1,r);
        return Arrays.copyOf(arr,k);
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
