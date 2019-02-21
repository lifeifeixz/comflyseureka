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

import java.util.ArrayList;

/**
 * @author flysLi
 * @ClassName Application
 * @Decription TODO
 * @Date 2018/12/28 11:08
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        After after = new TimeHistoryAfter();
        Handler handler = new Handler(after);
        ArrayList<String> urls = new ArrayList<>();
        for (int i = 43970; i <= 43983; i++) {
            String uri = "http://www.99lib.net/book/1655/" + i + ".htm";
            urls.add(uri);
        }
        handler.work(urls);
    }
}
