package com.zhang.od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 * ClassName: _043_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 1:55
 * @Version 1.0
 */
public class _043_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            buffer.add(Integer.parseInt(words[i]));
        }
        List<Integer> buffer2 = new ArrayList<>();
        for(int i : buffer){
            buffer2.add(i);
        }

        double avg = my_avg(buffer);
        int k = 0;
        for(int i = -127; i<=128; i++){
            for(int j = 0; j<buffer2.size(); j++){
                buffer2.set(j,p(i + buffer2.get(j)));
            }
            if(Math.abs(my_avg(buffer2)-128) < Math.abs(avg-128)){
                avg = my_avg(buffer2);
                k = i;
            }
            Collections.copy(buffer2, buffer);
        }
        System.out.println(k);

    }

    static double my_avg(List<Integer> buffer){
        double sum = 0.0;
        for(int i = 0; i<buffer.size(); i++){
            sum += buffer.get(i);
        }
        return sum / buffer.size();
    }

    static int p(int i){
        if(i < 0){
            return 0;
        }
        if(i > 255){
            return 255;
        }
        return i;
    }

}
