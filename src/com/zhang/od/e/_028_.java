package com.zhang.od.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _028_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 1:36
 * @Version 1.0
 */
public class _028_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt() + sc.nextInt();
            list.add(t);
        }
        list.sort((a,b)->a-b);

        int count = 1;
        int pre = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) - list.get(pre) >= sp){
                count++;
                pre = i;
            }
        }
        System.out.println(count);

    }

}
