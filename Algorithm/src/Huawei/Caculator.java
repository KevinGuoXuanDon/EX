package Huawei;

import java.util.*;
public class Caculator {
    // 使用 map 维护一个运算符优先级（其中加减法优先级相同，乘法有着更高的优先级）
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
    }};

    public int solve (String s) {
        // write code here
        s.replaceAll(" ","");
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        char[] cs = s.toCharArray();
        int n =cs.length;
        for(int i=0; i<n; i++){
            char c = cs[i];
            if(c=='('){
                ops.add(c);
            }
            else if(c==')'){
                //开始计算，直到遇到左边的括号
                while(!ops.isEmpty()){
                    if(ops.peek()=='('){
                        ops.pop();
                        break;
                    }
                    else{
                        cal(nums,ops);
                    }
                }
            }
            //如果是数字和运算符
            else{
                //处理连续数字，比如12
                if(Character.isDigit(c)){
                    int num = 0;
                    int j = i;
                    while(j<n && Character.isDigit(cs[j])){
                        num = num*10 + (cs[j++]-'0');
                    }
                    nums.add(num);
                    i = j-1;
                }
                //如果是运算符
                else{
                    //添加保护0减少边界判断
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.add(0);
                    }
                    //新操作要入栈，如果新操作的运算登记没有栈内操作高，先把栈内能算的算了，否则直接入栈
                    while(!ops.isEmpty() && ops.peek()!='('){
                        char opsPre = ops.peek();
                        if(map.get(opsPre)>=map.get(c)){
                            cal(nums,ops);
                        }
                        else{
                            break;
                        }
                    }
                    ops.add(c);
                }
            }

        }
        //遍历完所有元素后，大多数括号计算都已经计算完了，把剩下的计算解决
        while(!ops.isEmpty() && ops.peek()!='(') cal(nums,ops);
        return nums.peek();
    }

    private void cal(Stack<Integer> nums, Stack<Character> ops) {
        if(nums.isEmpty() || nums.size()<2 || ops.isEmpty()) return;
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        nums.add(ans);
    }
}