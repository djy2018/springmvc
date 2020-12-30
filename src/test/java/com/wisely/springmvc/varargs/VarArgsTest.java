package com.wisely.springmvc.varargs;

/**
 * @author dujiayong
 * @date 2020/12/25 19:41
 */
public class VarArgsTest {

    public static void m1(String s, String... ss) {
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }

    public static void main(String[] args) {
        m1("");
        m1("aaa");
        m1("aaa", "bbb");
    }

}
