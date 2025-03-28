package com.zhang.review;

/**
 * ClassName: _0318_
 * Package: com.zhang.review
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/18 11:01
 * @Version 1.0
 */
public class _0318_ {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "989.001";
        System.out.println(m1(s1, s2));
    }

    static String m1(String s1, String s2){
        if(s1 == null || "".equals(s1)){
            return s2;
        }
        int num = 0;// 记录最大小数位数
        int index1 = -1;
        int num1 = 0;
        if(s1.contains(".")){
            index1 = s1.indexOf(".");
            num1 = s1.length() - index1 - 1;
        }

        int index2 = -1;
        int num2 = 0;
        if(s2.contains(".")){
            index2 = s2.indexOf(".");
            num2 = s2.length() - index2-1;
        }

        num = Math.max(num1, num2);
        if(num != 0){
            if(num > num1){
                for (int i = 0; i < num - num1; i++) {
                    s1 += "0";
                }
            }else{
                for (int i = 0; i < num - num2; i++) {
                    s2 += "0";
                }
            }
        }

        s1 = s1.replace(".", "");
        s2 = s2.replace(".", "");
        //
        StringBuilder sb = new StringBuilder();
        int i = s1.length()-1;
        int j = s2.length()-1;

        int last = 0;
        while (i >= 0 && j >= 0){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            int tmp = c1 - '0' + c2 - '0' + last;
            last = tmp >= 10 ? 1 : 0;
            tmp = tmp % 10;
            sb.append(tmp);
            i--;
            j--;
        }

        if(i != 0){
            while (i >= 0){
                char c = s1.charAt(i);
                int tmp = c - '0' + last;
                last = tmp >= 10 ? 1 : 0;
                tmp = tmp % 10;
                sb.append(tmp);
                i--;
            }
        }else{
            while (j >= 0){
                char c = s2.charAt(j);
                int tmp = c - '0' + last;
                last = tmp >= 10 ? 1 : 0;
                tmp = tmp % 10;
                sb.append(tmp);
                j--;
            }
        }

        if(last != 0){
            sb.append(last);
        }

        sb.reverse();
        StringBuilder sb2 = new StringBuilder();
        for (int k = 0; k < sb.length()- num; k++) {
            sb2.append(sb.charAt(k));
        }
        sb2.append(".");
        for (int k = 0; k < num; k++) {
            sb2.append(sb.charAt(sb.length()- num + k));
        }
        return sb2.toString();
    }

}
