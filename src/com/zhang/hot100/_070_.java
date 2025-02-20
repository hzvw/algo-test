package com.zhang.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * ClassName: _070_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 1:01
 * @Version 1.0
 */
public class _070_ {
    class MinStack {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        public MinStack() {
        }

        public void push(int val) {
            s1.push(val);
            s2.push(s2.isEmpty() ? val : Math.min(s2.peek(), val));
        }

        public void pop() {
            s1.pop();
            s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }
}
