package leetcode.Design;

public class DesignCircleDeque {

}
class MyCircularDeque {
    int front;
    int last;
    int[] arr;
    int maxSize;
    int size;
    public MyCircularDeque(int k) {
        arr = new int[k];
        front = 1;
        last = 0;
        size = 0;
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front + maxSize -1) % maxSize;
        arr[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        last = (last + maxSize + 1) % last;
        arr[last] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + maxSize +1) % maxSize;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        last = (last + maxSize -1) % maxSize;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[last];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==maxSize;
    }
}
