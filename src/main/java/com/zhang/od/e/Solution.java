package com.zhang.od.e;

import java.util.Arrays;
 
class Solution {
  public int findTheLongestSubstring(String s) {
    // "前缀子串"中各个元音的奇偶状态
    // 00000
    // aeiou
    // 元音字母和二进制位的对应关系如上，如果二进制位值位0，代表对应元音字符数量有偶数个，如果二进制位值为1，代表对应元音字符数量有奇数个
    // 初始未遍历时，没有子串，此时各个元音的数量都为0，即偶数个，因此所有二进制位值位0
    int status = 0b00000;
 
    // map记录某个状态的最早出现位置
    // 压缩状态用五位二进制数表示，因此最多有32种状态
    int[] map = new int[32]; // -2是一个不可能的位置
    Arrays.fill(map, -2);
 
    // 00000 状态对应的十进制数为0，最早出现位置是-1，即未遍历，没有子串时
    map[0] = -1;
 
    // 记录最长的符合要求的子串长度
    int maxLen = 0;
 
    for (int i = 0; i < s.length(); i++) {
      // 如果遍历的字符s[i]是元音字母，则变更对应二进制位的奇偶性
      switch (s.charAt(i)) {
        case 'a':
          status ^= 0b10000;
          break;
        case 'e':
          status ^= 0b01000;
          break;
        case 'i':
          status ^= 0b00100;
          break;
        case 'o':
          status ^= 0b00010;
          break;
        case 'u':
          status ^= 0b00001;
          break;
      }
 
      // 如果对应状态的最早出现位置为-2，表示没有出现过对应状态，否则map[status]即status状态最早出现的位置
      if (map[status] != -2) {
        // 当前位置 i 的状态为status，而最早出现status状态的位置是 map[status]，两个位置同奇偶性，因此他们形成的范围内子串是符合要求的
        maxLen = Math.max(maxLen, i - map[status]);
      } else {
        // 如果对应状态之前未出现过，则当前位置 i 就是该状态的最早出现位置
        map[status] = i;
      }
    }
 
    return maxLen;
  }
}