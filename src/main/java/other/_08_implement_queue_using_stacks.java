package other;

import java.util.Stack;

public class _08_implement_queue_using_stacks {

    static class MyQueue {

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        public MyQueue() {


        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            int ret = s2.pop();
            while(!s2.empty()){
                s1.push(s2.pop());
            }
            return ret;
        }

        public int peek() {
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            int ret = s2.peek();
            while(!s2.empty()){
                s1.push(s2.pop());
            }
            return ret;
        }

        public boolean empty() {
            return s1.empty();
        }
    }
}
