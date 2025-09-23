package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _027_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/16 20:26
 * @Version 1.0
 */
public class _027_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] words = line.split(" ");
        int[] arr = new int[words.length];
        for(int i = 0; i<words.length; i++){
            arr[i] = Integer.parseInt(words[i]);
        }

        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }

        int N = arr.length;
        int[] res = new int[N];
        int i = 1;
        int j = 0;
        while(sum > 0){
            if(i % 7 == 0 || (i + "").contains("7")){
                sum--;
                res[j] += 1;
            }
            i++;
            j++;
            if(j == N){
                j = 0;
            }
        }

        for(int k = 0; k<res.length; k++){
            System.out.print(res[k] + " ");
        }


    }

}
