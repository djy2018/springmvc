package com.wisely.springmvc.functionalinterface;

/**
 * @author dujiayong
 * @date 2020/8/17
 **/
public class StaticMethodFunctionalInterface {

    public static void main(String[] args) {
        int sum = FunctionalInterfaceWithStaticMethod.sum(new int[]{1, 2, 3, 4, 5});
        System.out.println("sum=" + sum);
    }

}
