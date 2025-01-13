package com.zhang.hot100;

import java.util.Stack;

/**
 * ClassName: _739_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/9 0:21
 * @Version 1.0
 */
public class _739_ {
    public static void main(String[] args) {



    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i<temperatures.length; i++){
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }




}
