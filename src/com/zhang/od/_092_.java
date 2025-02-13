package com.zhang.od;

import java.util.*;

/**
 * ClassName: _092_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 20:38
 * @Version 1.0
 */
public class _092_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<m; i++){
            buffer.add(sc.nextInt());
        }
        buffer.sort((a,b) -> b-a);

        int sum = 0;
        for(int i = 0; i<m; i++){
            sum += buffer.get(i);
        }

        int i = m;
        for(;i >= 1;i--){
            if(sum % i != 0){
                continue;
            }
            int sub = sum / i;
            if(buffer.get(0) > sub){
                continue;
            }

            int[] buckets = new int[i];
            if(canPartition(sub, buffer, 0, buckets)){
                System.out.println(sub);
                return;
            }
        }
    }

    static boolean canPartition(int sub, List<Integer> buffer, int j , int[] buckets){
        if(j == buffer.size()){
            return true;
        }
        int last = buckets[0];
        int select = buffer.get(j);
        for(int k = 0; k<buckets.length; k++){
            if(k > 0 && buckets[k] == last){
                continue;
            }
            if(buckets[k] + select <= sub){
                buckets[k] += select;
                if(canPartition(sub, buffer, j+1, buckets)){
                    return true;
                }
                buckets[k] -= select;
            }
            last = buckets[k];
        }
        return false;
    }




}
