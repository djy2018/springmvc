package com.wisely.highlight_springmvc4.functionalinterface;

/**
 * @author dujiayong
 * @date 2020/8/17
 **/
@FunctionalInterface
public interface InterfaceWithDefaultMethod {

    void apply(Object obj);

    default void say(String name) {
        System.out.println("hello " + name);
    }

}
