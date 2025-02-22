package com.zhang.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: _086_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 1:55
 * @Version 1.0
 */
public class _086_ {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }

        // 求排列
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if(set.contains(str) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
