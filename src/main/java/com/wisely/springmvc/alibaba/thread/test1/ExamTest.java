package com.wisely.springmvc.alibaba.thread.test1;

/**
 * Created by dujiayong on 2018/6/28
 */
public class ExamTest {

    public static void main(String[] args) {
        ExamTest examTest = new ExamTest();
        PrintResult printResult = examTest.new PrintResult();
        Number number = examTest.new Number(printResult);
        Character character = examTest.new Character(printResult);
        new Thread(number, "thread1").start();
        new Thread(character, "thread2").start();
    }

    class PrintResult {

        private int i = 1;
        private char character = 'A';

        public synchronized void printNumber() {
            System.out.println("thread1:" + i);
            System.out.println("thread1:" + (i + 1));
            i += 2;
            notifyAll();
            if (i <= 52) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void printCharacter() {
            System.out.println("thread2:" + character);
            character += 1;
            notifyAll();
            if (character <= 'Z') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Number implements Runnable {

        PrintResult printResult;

        public Number(PrintResult printResult) {
            this.printResult = printResult;
        }

        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                printResult.printNumber();
            }
        }
    }

    class Character implements Runnable {

        PrintResult printResult;

        public Character(PrintResult printResult) {
            this.printResult = printResult;
        }

        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                printResult.printCharacter();
            }
        }
    }
}
