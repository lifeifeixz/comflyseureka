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
package script.core.analysis;

import script.core.config.NameSpace;

/**
 * @author flysLi
 * @ClassName EntityConvertSql
 * @Decription TODO
 * @Date 2018/12/19 13:11
 * @Version 1.0
 */
public interface EntityConvertSql {

    /**
     * 通过实体类型抓换成SQL
     *
     * @param nameSpace
     * @return
     */
    String convert(String method, NameSpace nameSpace,Object param);
}
