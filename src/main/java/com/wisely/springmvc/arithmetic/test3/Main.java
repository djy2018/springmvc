package com.wisely.springmvc.arithmetic.test3;

/**
 * Created by dujiayong on 2019/2/18.
 */
public class Main {

    public static int findMoreThanHalfNum(int[] numbers) {
        int length = numbers.length;
        if (length == 0) return -1;
        int num = numbers[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (numbers[i] == num) count++;
            else count--;
            if (count == 0) {
                num = numbers[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == num) count++;
        }
        if (count * 2 > length) return num;
        else return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 8, 3, 2, 2, 2, 5, 4, 2};
        int num = findMoreThanHalfNum(numbers);
        System.out.println("num:" + num);
    }
}
