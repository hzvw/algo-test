package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _067_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 21:43
 * @Version 1.0
 */
public class _067_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        try{
            System.out.println(p(str));
        }catch(Exception e){
            System.out.println("invalid IP");
        }
    }

    static long p(String str) throws Exception{
        String[] words = str.split("#");
        if(words.length < 4){
            throw new Exception();
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(words[i]);
            if(nums[i] != 0 && words[i].startsWith("0")){
                throw new Exception();
            }

        }
        if(nums[0]<1 || nums[0] > 128 || nums[1] < 0 || nums[1] > 255|| nums[2] < 0 || nums[2] > 255|| nums[3] < 0 || nums[3] > 255){
            throw new Exception();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {

            String tmp = Integer.toHexString(nums[i]);
            if(tmp.length() < 2){
                tmp = "0" + tmp;
            }
            sb.append(tmp);
        }
        return Long.parseLong(sb.toString(), 16);
    }

}
