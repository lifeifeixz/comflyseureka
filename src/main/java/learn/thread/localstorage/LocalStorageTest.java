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
package thread.localstorage;

/**
 * @author flysLi
 * @ClassName LocalStorageTest
 * @Decription TODO
 * @Date 2018/11/19 10:46
 * @Version 1.0
 */
public class LocalStorageTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("当前线程数据：main");
        System.out.println(threadLocal.get());
    }
}
