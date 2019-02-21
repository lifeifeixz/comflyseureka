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
package script.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author flysLi
 * @ClassName Logger
 * @Decription TODO
 * @Date 2018/12/19 12:58
 * @Version 1.0
 */
public class Logger {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void waring(String info) {
        System.err.println(currentTime() + "[警告]" + info);
    }

    public static void info(String info) {
        System.err.println(currentTime() + "[信息]" + info);
    }

    protected static String currentTime() {
        return sdf.format(new Date());
    }
}
