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
package learn.degisn.aop;

import java.util.Date;

/**
 * @author flysLi
 * @ClassName Logger
 * @Decription TODO
 * @Date 2018/11/23 14:26
 * @Version 1.0
 */
public class Logger {
    public static void start() {
        System.out.println(new Date() + " say hello start...");
    }

    public static void end() {
        System.out.println(new Date() + " say hello end");
    }
}
