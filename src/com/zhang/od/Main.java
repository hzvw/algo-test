package com.zhang.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(nums));
    }

    public static int getResult(int[] nums) {
        // 负数逃生的总人数
        int negative = 0;

        // 正数缓冲栈，注意该栈只缓存正数
        LinkedList<Integer> positive = new LinkedList<>();

        // 正序遍历nums，遍历出来的num，相当于从左边逃生
        for (int num : nums) {
            // 输入异常时输出-1
            if (num == 0) return -1;

            if (num > 0) {
                // 如果左边逃出来的是正数，则缓冲到栈中
                positive.addLast(num);
            } else {
                // 如果左边逃出来的是负数
                while (true) {
                    if (positive.size() == 0) {
                        // 如果栈为空，即没有正数，此时左边逃出来的负数直接逃生成功
                        negative++;
                        break;
                    }

                    // 如果栈不为空，则栈中有缓冲的正数，此时负数需要和栈顶正数进行pk
                    int pk = num + positive.removeLast();

                    if (pk > 0) {
                        // 如果pk结果大于0，则负数逃生失败，栈顶的正数减少战斗力
                        positive.addLast(pk);
                        break;
                    } else if (pk < 0) {
                        // 如果pk结果小于0，则负数pk成功，此时需要继续和新栈顶正数pk，即进入下一轮
                        num = pk;
                    } else {
                        // 如果pk结果为0，则同归于尽
                        break;
                    }
                }
            }
        }

        // 最终逃生成功的人数：negative即负数逃生成功个数，positive.size()即正数逃生成功个数
        return negative + positive.size();
    }
}