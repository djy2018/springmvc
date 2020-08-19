package com.wisely.springmvc.alibaba.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by dujiayong on 2018/6/22
 * OOP规约
 */
public class OOPProtocol {

    private static Logger logger = LoggerFactory.getLogger(OOPProtocol.class);

    public Boolean test(String a,String b){
        if(a == b) return true;
        if(a == null) return false;
        return a.equals(b);
    }

    public static void main(String[] args) {
        String test = "test";
        logger.info("result:" + Objects.equals(test, "test"));


        Integer a = new Integer(200);
        Integer b = new Integer(200);

        Integer a2 = new Integer(100);
        Integer b2 = new Integer(100);

        Integer a3 = Integer.valueOf(100);
        Integer b3 = Integer.valueOf(100);

        Integer a4 = Integer.valueOf(200);
        Integer b4 = Integer.valueOf(200);

        logger.info("result=" + (a == b));
        logger.info("result=" + (a2 == b2));
        logger.info("result=" + (a3 == b3));
        logger.info("result=" + (a4 == b4));

        logger.info("equals=" + a3.equals(b3));
        logger.info("equals=" + a4.equals(b4));
    }

}
