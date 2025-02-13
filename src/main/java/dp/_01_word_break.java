package dp;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict
 * 中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 *
 *
 */
public class _01_word_break {
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i = 1; i<=length; i++){
            for(int j = i-1; j>=0; j--){
                if(dp[j]){
                    String str = s.substring(j, i);
                    if(dict.contains(str)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[length];
    }

    @Test
    public void testWordBreak(){

        // "aaaaaaa",["aaaa","aa"]
        String s = "aaaaaaa";
        Set<String> set = new HashSet<String>();
        set.add("aaaa");
        set.add("aa");

        _01_word_break obj = new _01_word_break();
        obj.wordBreak(s, set);
    }

}
