package com.zhang.od.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _056_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 15:31
 * @Version 1.0
 */
public class _056_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//每个芯片的容量
        int n = sc.nextInt();//芯片数量
        String str = sc.next();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'A'){
                list.add(1);
            }else if(c == 'B'){
                list.add(2);
            }else{
                list.add(8);
            }
        }

        int[] arr = new int[n];
        Arrays.fill(arr, m);

        for (Integer ele : list) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] >= ele){
                    arr[i] -= ele;
                    break;
                }
            }
        }
        for (int content : arr) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m-content; i++) {
                sb.append("1");
            }
            for (int i = 0; i < content; i++) {
                sb.append("0");
            }
            System.out.println(sb.toString());
        }


    }
}
