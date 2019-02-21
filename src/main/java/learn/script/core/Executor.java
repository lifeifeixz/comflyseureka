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
 * SQL执行器
 *
 * @author flysLi
 * @ClassName Executor
 * @Decription TODO
 * @Date 2018/12/17 14:17
 * @Version 1.0
 */
public interface Executor {

    <T> T execute(String sql, String dropType,Class<T> returnType);
}
