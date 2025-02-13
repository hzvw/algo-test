package str;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
 * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
 * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
 * ()(()
 *
 *
 */
public class _04_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        for(int i = 0; i<s.length()-1; i++){
            int j = i+1;
            while(j < s.length()){
                if(check(s, i, j, stack)){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                    }
                }
                j++;
                stack.clear();
            }
        }
        //System.out.println(max);
        return max;
    }

    boolean check(String s, int index, int j, Stack<Character> stack){
        if(s.charAt(index) == ')' || s.charAt(j) == '(' || s.length() % 2 != 0){
            return false;
        }

        for(int i = index; i<=j; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.size() > 0){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void testSolution(){
        _04_longest_valid_parentheses obj = new _04_longest_valid_parentheses();

        obj.longestValidParentheses("(()()");
        obj.longestValidParentheses("(()))");
        obj.longestValidParentheses("()())");
        obj.longestValidParentheses("()(()");
    }


}
