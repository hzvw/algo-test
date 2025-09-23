package com.zhang.hot100;

import java.net.PortUnreachableException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _090_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 16:54
 * @Version 1.0
 */
public class _090_ {
    public static void main(String[] args) {

        String s = ")()())";
        new _090_().longestValidParentheses(s);
    }

    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int max_len = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(cs[i] == '('){
                left ++;
            }else{
                right++;
            }
            if(left == right){
                max_len = Math.max(max_len, right * 2);
            }
            if(right > left){
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = n-1; i >= 0 ; i--) {
            if(cs[i] == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                max_len = Math.max(max_len, left * 2);
            }
            if(left > right){
                left = 0;
                right = 0;
            }
        }
        return max_len;
    }

    // 短暂放弃
    public int longestValidParentheses2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n];
        // dp[i]代表以i结尾的子串中有效子串的最大长度

        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                dp[i] = 0;
                continue;
            }

            if(i-1 >= 0 && i-dp[i-1]-2 >= 0){
                dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2];
                max_len = Math.max(max_len, dp[i]);
            }
        }
        return max_len;
    }


    public int longestValidParentheses3(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i-2>=0 ? dp[i-2]: 0) + 2;
                }else{
                    if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2] : 0);
                    }
                }
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
