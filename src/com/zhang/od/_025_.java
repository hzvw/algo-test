package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _025_
 * Package: com.zhang.od
 * Description:判断一组不等式是否满足约束并输出最大差
 *
 * @Author Harizon
 * @Create 2025/1/16 19:36
 * @Version 1.0
 */
public class _025_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.split(";");
        double[] a1 = new double[5];
        double[] a2 = new double[5];
        double[] a3 = new double[5];

        //int[] x = new int[5];
        double[] x = new double[5];
        double[] b = new double[3];
        String[] bk = new String[3];

        String[] a1s = words[0].split(",");
        for(int i = 0; i<5; i++){
            a1[i] = Double.parseDouble(a1s[i]);
        }
        String[] a2s = words[1].split(",");
        for(int i = 0; i<5; i++){
            a2[i] = Double.parseDouble(a2s[i]);
        }
        String[] a3s = words[2].split(",");
        for(int i = 0; i<5; i++){
            a3[i] = Double.parseDouble(a3s[i]);
        }
        String[] xs = words[3].split(",");
        for(int i = 0; i<5; i++){
            //x[i] = Integer.parseInt(xs[i]);
            x[i] = Double.parseDouble(xs[i]);
        }
        String[] bs = words[4].split(",");
        for(int i = 0; i<3; i++){
            b[i] = Double.parseDouble(bs[i]);
        }
        String[] bks = words[5].split(",");
        for(int i = 0; i<3; i++){
            bk[i] = bks[i];
        }
        double diff1 = a1[0]*x[0] + a1[1]*x[1] +a1[2]*x[2] +a1[3]*x[3] +a1[4]*x[4] - b[0];
        double diff2 = a2[0]*x[0] + a2[1]*x[1] +a2[2]*x[2] +a2[3]*x[3] +a2[4]*x[4] - b[1];
        double diff3 = a3[0]*x[0] + a3[1]*x[1] +a3[2]*x[2] +a3[3]*x[3] +a3[4]*x[4] - b[2];
        boolean flag = p(diff1, bk[0]) &&p(diff2, bk[1])&&p(diff3, bk[2]);

        System.out.println(flag + " " + (int)Math.max(Math.max(diff1, diff2),diff3));
    }

    static boolean p(double x, String bk){
        String[] str = {">",">=","<","<=","="};

        if(bk.equals(str[0])){
            return x > 0.0;
        }else if(bk.equals(str[1])){
            return x >= 0.0;
        }else if(bk.equals(str[2])){
            return x < 0.0;
        }else if(bk.equals(str[3])){
            return x <= 0.0;
        }else{
            return x == 0.0;
        }
    }

}
