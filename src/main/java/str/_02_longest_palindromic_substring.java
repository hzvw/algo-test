package str;


import org.junit.Test;

/**
 * 找出给出的字符串S中最长的回文子串。假设S的最大长度为1000，并且只存在唯一解。
 *
 *
 */
public class _02_longest_palindromic_substring {
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return "";
        }
        if(s.length() <= 2){
            return s;
        }

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<s.length(); i++){
            int count = 0;
            int left = i;
            int right = i;
            while(left >= 0 && right <= s.length() - 1){
                if(s.charAt(left) == s.charAt(right)){
                    if(left == right){
                        count = 1;
                    }else{
                        count += 2;
                    }
                    left--;
                    right ++;
                }else{
                    break;
                }
            }
            if(count > max){
                max = count;
                start = left+1;
                end = right-1;
            }
        }

        for(int i = 0;i<s.length()-1; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(ch1 == ch2){
                int count = 0;
                int left = i;
                int right = i+1;
                while(left >= 0 && right <= s.length() - 1){
                    if(s.charAt(left) == s.charAt(right)){
                        count += 2;
                        left--;
                        right ++;
                    }else{
                        break;
                    }
                }
                if(count > max){
                    max = count;
                    start = left+1;
                    end = right-1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    @Test
    public void testLongestPalindrome(){

        String s = "ccc";
        System.out.println(new _02_longest_palindromic_substring().longestPalindrome(s));
    }


}
