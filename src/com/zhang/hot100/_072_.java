package com.zhang.hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: _072_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 3:17
 * @Version 1.0
 */
public class _072_ {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < num){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(i) == null ? 0 : map.get(i) - i;
        }
        return res;
    }
}
