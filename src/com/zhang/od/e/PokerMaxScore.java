package com.zhang.od.e;

import java.util.*;

public class PokerMaxScore {
    static int[] count = new int[14];  // 统计每张牌的出现次数 (1~13)
    static Map<String, Integer> memo = new HashMap<>(); // 记忆化搜索

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        // 牌面转换：'0' -> 10, 'J' -> 11, 'Q' -> 12, 'K' -> 13
        for (char c : input.toCharArray()) {
            int num = (c == '0') ? 10 : (c == 'J') ? 11 : (c == 'Q') ? 12 : (c == 'K') ? 13 : (c - '0');
            count[num]++;
        }
        
        // 计算最大得分
        System.out.println(dfs());
    }

    static int dfs() {
        // 转换当前牌面状态为字符串，用于记忆化搜索
        String key = Arrays.toString(count);
        if (memo.containsKey(key)) return memo.get(key);

        int maxScore = 0;  // 记录最大得分
        
        // 1. **单张**
        for (int i = 1; i <= 13; i++) {
            if (count[i] > 0) {
                count[i]--;
                maxScore = Math.max(maxScore, i + dfs());
                count[i]++;
            }
        }
        
        // 2. **对子、三张**
        for (int i = 1; i <= 13; i++) {
            if (count[i] >= 2) {  // 对子
                count[i] -= 2;
                maxScore = Math.max(maxScore, (i * 2) * 2 + dfs());
                count[i] += 2;
            }
            if (count[i] >= 3) {  // 三张
                count[i] -= 3;
                maxScore = Math.max(maxScore, (i * 3) * 2 + dfs());
                count[i] += 3;
            }
        }

        // 3. **四张炸弹**
        for (int i = 1; i <= 13; i++) {
            if (count[i] == 4) {
                count[i] -= 4;
                maxScore = Math.max(maxScore, (i * 4) * 3 + dfs());
                count[i] += 4;
            }
        }

        // 4. **顺子 (五张)**
        for (int i = 1; i <= 9; i++) {  // 只能从 1-9 开始
            if (count[i] > 0 && count[i + 1] > 0 && count[i + 2] > 0 && count[i + 3] > 0 && count[i + 4] > 0) {
                for (int j = i; j < i + 5; j++) count[j]--;
                maxScore = Math.max(maxScore, (i + (i + 1) + (i + 2) + (i + 3) + (i + 4)) * 2 + dfs());
                for (int j = i; j < i + 5; j++) count[j]++;  // 还原
            }
        }

        memo.put(key, maxScore);
        return maxScore;
    }
}
