package str;

import org.junit.Test;

import java.util.*;

/**
 * 求某字符串的最长不重复子串的长度
 *
 *
 */
public class _01_longest_substring_without_repeating_characters {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        int i = 0;
        int j = 0;
        int ret = Integer.MIN_VALUE;
        int count = 0;
        while(j < length){
            Character ch = s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch, j);
                count++;
            }else{
                int index = map.get(ch);
                for(int k = i; k<=index; k++){
                    map.remove(s.charAt(k));
                }
                i = index+1;

                map.put(ch, j);
                count = j - i + 1;
            }
            if(count > ret){
                ret = count;
            }
            j++;
        }

        return ret;
    }

    @Test
    public void testSolution(){
        String s = "wlrb" +
                "bmqbhcdarzowk" +
                "kyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

        String str = "qpxrjxkitzyxacbhhkicqc";

        String str2 = "qopubjguxhxdipfzwswybgfylqvjzhar";
        int ret = new _01_longest_substring_without_repeating_characters()
                .lengthOfLongestSubstring(str2);
        System.out.println("ret = " + ret);
        //System.out.println("s.length = " + s.length());
    }
}
