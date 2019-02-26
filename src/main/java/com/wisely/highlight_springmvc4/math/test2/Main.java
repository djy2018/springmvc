package com.wisely.highlight_springmvc4.math.test2;

import java.util.Scanner;

/**
 * 求出区间[a,b]中所有整数的质因数分解
 * @author dujiayong
 * @date 2019/02/26
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        Integer b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            // 输入值大于等于3
            if (i >= 3) {
                String m = "";
                int k = 2;
                int j = i;
                while (j != k) {
                    // 如果n>k，但是n能被k整除，则应打印出k的值，并用n除以k的值作为新的正整数n
                    if (j % k == 0) {
                        m = m + k + "*";
                        j = j / k;
                    } else if (j % k != 0) { // 如果n不能被k整除，则用k+1作为k的值
                        k++;
                    }
                }
                m = m + k;
                System.out.println(i + "=" + m);
            } else {
                System.out.println(i + "=" + i);
            }

        }
    }
}
