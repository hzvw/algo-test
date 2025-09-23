package com.zhang.od.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentParser {
    static int maxDepth = 1;
    static List<List<String>> levels = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 初始化 levels
        for (int i = 0; i < 1000000; i++) {
            levels.add(new ArrayList<>());
        }

        // 解析输入
        String[] tokens = input.split(",");
        parseComments(tokens, 0, 1);

        // 输出最大深度
        System.out.println(maxDepth);
        for (int i = 1; i <= maxDepth; i++) {
            System.out.println(String.join(" ", levels.get(i)));
        }
    }

    // 递归解析评论
    public static int parseComments(String[] tokens, int index, int depth) {
        if (index >= tokens.length) return index;

        String comment = tokens[index];
        int replies = Integer.parseInt(tokens[index + 1]);

        levels.get(depth).add(comment);
        maxDepth = Math.max(maxDepth, depth);

        int nextIndex = index + 2;
        for (int i = 0; i < replies; i++) {
            nextIndex = parseComments(tokens, nextIndex, depth + 1);
        }

        return nextIndex;
    }
}

