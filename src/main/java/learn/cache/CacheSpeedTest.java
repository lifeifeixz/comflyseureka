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
package learn.cache;

import temp.util.LocalStorage;

/**
 * @author flysLi
 * @ClassName CacheSpeedTest
 * @Decription TODO
 * @Date 2018/11/19 11:23
 * @Version 1.0
 */
public class CacheSpeedTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LocalStorage storage = new LocalStorage("D:\\L临时数据\\speed.txt");
        for (int i = 0; i < 10000; i++) {
            storage.writer(String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - start) + "毫秒");
    }
}

class CacheSpeedStorage {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LocalStorage storage = new LocalStorage("D:\\L临时数据\\speedCache.txt", true);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append(i);
        }
        storage.writer(stringBuffer.toString());
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - start) + "毫秒");
    }
}
