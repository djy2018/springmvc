package com.wisely.highlight_springmvc4.thread.chapter1.test5;

/**
 * Created by dujiayong on 2019/2/17.
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + ",password=" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
