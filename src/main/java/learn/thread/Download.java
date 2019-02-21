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
package thread;

import java.util.concurrent.Callable;

/**
 * @author flysLi
 * @ClassName Download
 * @Decription TODO
 * @Date 2018/10/22 13:42
 * @Version 1.0
 */
public class Download implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("同时下载");
        return null;
    }
}
