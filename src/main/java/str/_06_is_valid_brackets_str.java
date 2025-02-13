package str;

import java.util.*;

public class _06_is_valid_brackets_str {
    // 是否是合法的括号序列
    public static boolean isValid(String s){
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{', '}');
        map.put('[',']');

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<s.length(); i++){
            Character c = s.charAt(i);

            if(map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.size() == 0){
                    return false;
                }
                Character t = stack.pop();
                if(c != map.get(t)){
                    return false;
                }
            }
        }
        if(stack.size() != 0){
            return false;
        }
        return true;
    }

}
