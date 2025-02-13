package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _075_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/20 23:33
 * @Version 1.0
 */
public class _075_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[50];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for(int i = 3; i<50; i++){
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % 26;
        }

        for(int i = 0; i<n; i++){
            String str = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);

                char c1 = (char) (((c-'a') + arr[j]) % 26 + 'a');
                sb.append(c1);
            }
            System.out.println(sb.toString());
        }


    }

}
