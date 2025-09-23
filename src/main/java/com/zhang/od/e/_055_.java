package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: _055_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 12:29
 * @Version 1.0
 */
public class _055_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(arr, (a,b)-> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < n; i++) {
            int[] range = arr[i];

            while(true){
                if(stack.isEmpty()){
                    stack.push(range);
                    break;
                }
                int[] top = stack.peek();
                int s0 = top[0];
                int e0 = top[1];

                int s1 = range[0];
                int e1 = range[1];

                // 没有交集
                if(e1<=s1 || e0 <= s1){
                    stack.push(range);
                    break;
                }else if(s1<=s0 && e0<=e1){
                    stack.pop();
                }else if(s0 <= s1 && e1 <= e0){
                    // do nothing
                    break;
                }else if(s1 < s0 && e1 < e0){

                    //stack.push(new int[]{s1,s0});
                    break;
                }else{
                    stack.push(new int[]{e0,e1});
                    break;
                }
            }
        }

        System.out.println(stack.size());

    }

}
