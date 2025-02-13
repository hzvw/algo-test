package com.zhang.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _063_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 18:31
 * @Version 1.0
 */
public class _063_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(p(arr));

    }

    static int p(int[] arr){
        LinkedList<Integer> stack = new LinkedList<>();

        int i1 = 0;//负数逃生人数
        for(int num : arr){
            if(num == 0 ){
                return -1;
            }

            if(num > 0){
                stack.addLast(num);
            }else{
                while(true){
                    if(stack.size() == 0){
                        i1++;
                        break;
                    }else{
                        int pk = stack.removeLast() + num;
                        if(pk == 0){
                            //同归于尽
                            break;
                        }else if(pk>0){
                            //正数赢
                            stack.addLast(pk);
                            break;
                        }else{
                            //负数赢
                            //i1++;
                            num = pk;
                        }
                    }
                }
            }
        }

        return i1 + stack.size();
    }

}
