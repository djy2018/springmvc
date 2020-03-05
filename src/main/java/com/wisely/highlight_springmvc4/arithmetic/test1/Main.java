package com.wisely.highlight_springmvc4.arithmetic.test1;

import java.util.Scanner;

/**
 * Created by dujiayong on 2019/2/18.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        scanner.close();
        System.out.println(Integer.toHexString(n));
    }

}
