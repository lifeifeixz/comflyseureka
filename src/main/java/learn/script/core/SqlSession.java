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
package script.core;

/**
 * @author flysLi
 * @ClassName DefaultSqlSession
 * @Decription TODO
 * @Date 2018/12/17 14:24
 * @Version 1.0
 */
public interface SqlSession {
    <T> T getMapper(Class<T> tClass);

    void init();
}
