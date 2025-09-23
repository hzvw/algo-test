package com.zhang.hot100;

import java.util.HashMap;

/**
 * ClassName: _096_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 20:04
 * @Version 1.0
 */
public class _096_ {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
