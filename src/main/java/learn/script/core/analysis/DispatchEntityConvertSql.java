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
 * 通过不同的类型分发至不同的处理者
 *
 * @author flysLi
 * @ClassName DispatchEntityConvertSql
 * @Decription TODO
 * @Date 2018/12/19 13:12
 * @Version 1.0
 */
public class DispatchEntityConvertSql implements EntityConvertSql {
    private DefaultEntityConvertSql defaultEntityConvertSql;

    public DispatchEntityConvertSql() {
        defaultEntityConvertSql = new DefaultEntityConvertSql();
    }

    @Override
    public String convert(String method, NameSpace nameSpace, Object param) {
        if (isDefaultMethod(method)) {
            return defaultEntityConvertSql.convert(method, nameSpace, param);
        }
        return null;
    }

    protected boolean isDefaultMethod(String method) {
        if ("findOne".equals(method) ||
                "findAll".equals(method) ||
                "delete".equals(method) ||
                "update".equals(method) ||
                "findAll".equals(method) ||
                "count".equals(method)) {
            return true;

        }
        return false;
    }
}
