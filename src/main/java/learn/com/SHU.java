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
package learn.com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author flysLi
 * @ClassName SHU
 * @Decription TODO
 * @Date 2018/12/27 16:52
 * @Version 1.0
 */
public class SHU {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            try {
                Document document = Jsoup.connect("https://www.1616n.com/kf/867637.shtml").get();
                System.out.println(document.toString());
                System.out.println("--------------------");
                System.out.println(i);
            } catch (IOException e) {
                try {
                    Jsoup.connect("https://www.1616n.com/kf/867637.shtml").get();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
