package com.zhang.leetcode.bak;

/**
 * ClassName: _415_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/7 20:12
 * @Version 1.0
 */
public class _415_ {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;

        int last = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0  && j >= 0){
            int sum = num1.charAt(i) + num2.charAt(j) - '0' - '0' + last;
            last = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            sb.append(sum + "");
            i--;
            j--;
        }

        if(i >= 0){
            while (i >= 0){
                int sum = num1.charAt(i)  - '0' + last;
                last = sum >= 10 ? 1 : 0;
                sum = sum % 10;

                sb.append(sum + "");
                i--;
            }
        }else{
            while (j >= 0){
                int sum = num2.charAt(j)  - '0' + last;
                last = sum >= 10 ? 1 : 0;
                sum = sum % 10;

                sb.append(sum + "");
                j--;
            }
        }
        if(last != 0){
            sb.append(last);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new _415_().addStrings("11","123");


    }
}
