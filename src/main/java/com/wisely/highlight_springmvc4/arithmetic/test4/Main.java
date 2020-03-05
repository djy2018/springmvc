package com.wisely.highlight_springmvc4.arithmetic.test4;

/**
 * Created by dujiayong on 2019/2/18.
 */
public class Main {

    public static boolean find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int i, j;
        i = rowCount - 1;
        j = 0;

        while (i >= 0 && j < colCount) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean b = find(3, a);
        System.out.println("result=" + b);
    }
}
