package com.wisely.springmvc.service;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by dujiayong on 2020/4/5.
 */
public class Proxy {

    public static void main(String[] args) throws Exception {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "$Proxy", new Class[]{UserService.class});
        FileOutputStream outputStream = new FileOutputStream("D:/Proxy.class");
        outputStream.write(proxyClassFile);
        outputStream.flush();
        outputStream.close();
    }
}
