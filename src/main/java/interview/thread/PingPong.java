/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package interview.thread;

/**
 * @author flysLi
 * @ClassName PingPong
 * @Decription TODO
 * @Date 2019/2/25 10:45
 * @Version 1.0
 */
public class PingPong extends Thread {
    String word;
    int delay;

    public PingPong(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.println(word + " ");
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        new PingPong("ping", 33).start();
        new PingPong("PONG", 100).start();
    }
}
