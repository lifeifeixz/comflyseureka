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
package util;

import org.checkerframework.checker.units.qual.A;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author flysLi
 * @ClassName Handler
 * @Decription TODO
 * @Date 2018/12/28 11:02
 * @Version 1.0
 */
public class Handler {
    private After after;

    public Handler(After after) {
        this.after = after;
    }

    public Object work(ArrayList<String> uris) {
        for (int i = 0; i < uris.size(); i++) {
            String var1 = uris.get(i);
            if (var1 == null || var1.length() == 0) {
                continue;
            }

            Connection conn = Jsoup.connect(var1).timeout(5000);
            conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.header("Accept-Encoding", "gzip, deflate, sdch");
            conn.header("Accept-Language", "zh-CN,zh;q=0.8");
            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

            Document document;
            try {
                document = conn.get();
                after.some(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
