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
package learn.degisn.command;

/**
 * @author flysLi
 * @ClassName Command
 * @Decription TODO
 * @Date 2019/3/11 10:28
 * @Version 1.0
 */
public interface Command {

    /**
     * 执行命令
     */
    void excute();

    /**
     * 撤销命令
     */
    void unDo();
}
