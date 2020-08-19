package com.wisely.highlight_springmvc4.functionalinterface;

/**
 * @author dujiayong
 * @date 2020/8/17
 **/
public class FunctionalInterfaceWithDefaultMethod {

    public static void main(String[] args) {
        InterfaceWithDefaultMethod i = (o) -> {
            System.out.println(o.toString());
        };
        i.apply("hello");
        i.say("djy");
    }
}
