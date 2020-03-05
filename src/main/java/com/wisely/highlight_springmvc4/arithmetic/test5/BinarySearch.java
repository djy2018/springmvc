package com.wisely.highlight_springmvc4.arithmetic.test5;

/**
 * Created by dujiayong on 2019/2/19.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int num) {
        int length = arr.length;
        int mid;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            mid = (right + left) / 2;
            if (num > arr[mid]) {
                left = mid + 1;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int aim = 5;
        int result = binarySearch(arr, aim);
        if (result == -1) {
            System.out.println("Can't find " + aim);
        } else {
            System.out.println("position is " + (result + 1));
        }
    }
}
