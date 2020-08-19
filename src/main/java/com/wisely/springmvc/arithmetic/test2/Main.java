package com.wisely.springmvc.arithmetic.test2;

import java.util.Scanner;

/**
 * Created by dujiayong on 2019/2/18.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[8];
        // 数组b的元素的个数由a决定，由于a<2^32,即a<16^8
        char[] s = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if(a >=0 && a < 16){
            for (int i = 0; i < 16; i++) {
                int m = a % 16;
                if(m == i){
                    System.out.println(s[i]);
                }
            }
        }else{
            int i = 0;
            while (a != 0){
                b[i] = a % 16;
                a = a/16;
                i++;
            }
            for (int j = i-1; j >=0 ; j--) {
                if(b[j] == 10)
                    System.out.print("A");
                else if(b[j] == 11)
                    System.out.print("B");
                else if(b[j] == 12)
                    System.out.print("C");
                else if(b[j] == 13)
                    System.out.print("D");
                else if(b[j] == 14)
                    System.out.print("E");
                else if(b[j] == 15)
                    System.out.print("F");
                else
                    System.out.print(b[j]);
            }
        }
    }
}
