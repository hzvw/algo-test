package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _002_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 1:03
 * @Version 1.0
 */
public class _002_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new int[]{x, y});
            set.add(x + " " + y);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int x1 = list.get(i)[0];
            int y1 = list.get(i)[1];
            for (int j = i+1; j < list.size(); j++) {
                int x2 = list.get(j)[0];
                int y2 = list.get(j)[1];

                int d1 = x2-x1;
                int c1 = y2-y1;

                int x3 = x2+c1;
                int y3 = y2-d1;

                int x4 = x1+c1;
                int y4 = y1-d1;
                if(set.contains(x3 + " " + y3) && set.contains(x4 + " " + y4)){
                    count++;
                }

                x3 = x2-c1;
                y3 = y2+d1;
                x4 = x1-c1;
                y4 = y1+d1;

                if(set.contains(x3 + " " + y3) && set.contains(x4 + " " + y4)){
                    count++;
                }
            }
        }
        System.out.println(count / 4);

    }

}
