package com.wisely.springmvc.jdk;

import com.wisely.springmvc.web.ch4_6.MyRestController;
import org.junit.Test;

import java.util.StringTokenizer;

public class StringTokenizerTest {

    @Test
    public void test() {
        StringTokenizer st = new StringTokenizer("this,is a,test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    public void test2() {
        StringTokenizer st = new StringTokenizer("this,is a,test",",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    public void test3() {
        StringTokenizer st = new StringTokenizer("this,is a,test",",",true);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    public void test4(){
        StringBuilder sb = new StringBuilder();
        String simpleTypeName = MyRestController.class.getSimpleName();
        for (int i = 0 ; i < simpleTypeName.length(); i++) {
            if (Character.isUpperCase(simpleTypeName.charAt(i))) {
                sb.append(simpleTypeName.charAt(i));
            }
        }
        sb.append("#").append("test");
        System.out.println("result=" + sb.toString());
    }
}
