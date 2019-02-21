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
package temp.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author flysLi
 * @ClassName CrawlerEBook
 * @Decription TODO
 * @Date 2018/11/19 9:24
 * @Version 1.0
 */
public class CrawlerEBook {
    public static void main(String[] args) throws IOException, InterruptedException {

        program(10874057);
    }

    public static void program(int startPage) {
        for (int i = startPage; i <= 10874108; i++) {
            String uri = "http://www.qb5200.org/xiaoshuo/96/96056/" + i + ".html";
            Connection conn = Jsoup.connect(uri);
            conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.header("Accept-Encoding", "gzip, deflate, sdch");
            conn.header("Accept-Language", "zh-CN,zh;q=0.8");
            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            Document dom = null;
            try {
                dom = conn.get();
                //标题
                String title = dom.getElementById("title").html();
                //内容
                String content = dom.getElementById("content").html();
                writer(content);
                System.out.println("第 " + i + " 页完成...");
            } catch (Exception e) {
                //如果抓取失败,将祖泽10秒，递归重来
                try {
                    System.out.println("-----------阻塞中--------------");
                    Thread.sleep(10000);
                    program(i);
                    break;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

    public static void writer(String content) {
        File file = new File("D:\\temp\\鲁宾逊漂流记.txt");
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(file, true);
            byte[] bytes = content.getBytes();
            try {
                fop.write(bytes);
                fop.flush();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
