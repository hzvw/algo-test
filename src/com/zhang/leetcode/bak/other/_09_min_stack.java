package other;

import java.util.*;

public class _09_min_stack {

    class MinStack {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        public MinStack() {

        }

        public void push(int val) {
            s1.push(val);
            if(s2.empty()){
                s2.push(val);
            }else{
                int min = s2.peek();
                if(val < min){
                    s2.push(val);
                }else{
                    s2.push(min);
                }
            }
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
