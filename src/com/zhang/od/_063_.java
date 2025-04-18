package com.zhang.od;

import java.beans.BeanDescriptor;
import java.util.Arrays;
import java.util.Deque;
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

        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(p(arr));

    }

    static int p(int[] nums){
        int negative = 0;
        Deque<Integer> st = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if(ele == 0){
                return -1;
            }

            if(ele > 0){
                st.push(ele);
            }else{
                while(true){
                    if(st.size() == 0){
                        negative++;
                        break;
                    }else{
                        int pk = st.pop() + ele;
                        if(pk < 0){
                            ele = pk;
                        }else if(pk == 0){
                            break;
                        }else{
                            st.push(pk);
                            break;
                        }

                    }
                }
            }

        }


        return st.size() + negative;
    }

}
