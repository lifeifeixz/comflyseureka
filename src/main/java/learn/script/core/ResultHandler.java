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
 * SQL执行结果处理器
 *
 * @author flysLi
 * @ClassName ResultHandler
 * @Decription TODO
 * @Date 2018/12/17 14:18
 * @Version 1.0
 */
public interface ResultHandler {

    <T> T handle(Object result,Class<T> resultType);
}
