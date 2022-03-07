import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        //方法是单调栈没错，不应该引入这么多数据结构的
        //就是如果遇到向左的进行判断，栈需要非空，且上一个向右则发生碰撞，用while一直判断能否消除
        //其他情况，都不会发生碰撞，直接加入stack
        //情况没有分好直接出现逻辑错误= =，应该先把情况分一分，看看能否合并，不然有太多重叠情况了
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            boolean flag =true;
            while(!stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                //如果相等，两个一起击穿，不用加当前值
                if(stack.peek()+asteroids[i]==0){
                    stack.pop();
                    flag=false;
                    break;
                }
                else if(stack.peek()+asteroids[i]<0){
                    stack.pop();
                    //一直清到左边没有往右走的行星了，就会跳出当前while，执行下面的push
                }
                //如果相撞时当前行星小，直接撞碎不用添加
                else{
                    flag = false;
                    break;
                }
            }
            //出了刚刚两种情况，其他情况都需要添加当前行星
            if(flag){
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            result[i]=stack.pop();
        }
        return result;
    }
}
