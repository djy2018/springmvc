package com.wisely.highlight_springmvc4.functionalinterface;

import java.util.Arrays;

/**
 * @author dujiayong
 * @date 2020/8/17
 **/
@FunctionalInterface
public interface FunctionalInterfaceWithStaticMethod {

    static int sum(int[] array) {
        return Arrays.stream(array).reduce((a, b) -> a+b).getAsInt();
    }

    void apply();

}
