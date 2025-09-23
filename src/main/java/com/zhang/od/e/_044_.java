package com.zhang.od.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _044_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/2 23:30
 * @Version 1.0
 */
public class _044_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputs = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] outputs = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(int ele : inputs){
            queue.addLast(ele);
            while (i < outputs.length && !queue.isEmpty()){
                if(outputs[i] == queue.getFirst()){
                    queue.removeFirst();
                    i++;
                    sb.append("L");
                }else if(outputs[i] == queue.getLast()){
                    queue.removeLast();
                    i++;
                    sb.append("R");
                }else{
                    break;
                }
            }
        }
        if(i == outputs.length){
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }

    }
}
