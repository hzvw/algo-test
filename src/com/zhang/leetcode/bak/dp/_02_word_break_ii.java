package dp;

import java.util.*;

/**
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * 返回的结果为["cats and dog", "cat sand dog"].
 *
 *
 */

public class _02_word_break_ii {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
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
        return ret;
    }

}
