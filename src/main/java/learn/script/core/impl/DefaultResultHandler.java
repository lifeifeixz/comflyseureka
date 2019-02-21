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
package script.core.impl;

import script.core.ResultHandler;
import script.core.config.GlobalConfiguration;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author flysLi
 * @ClassName DefaultResultHandler
 * @Decription TODO
 * @Date 2018/12/17 14:56
 * @Version 1.0
 */
public class DefaultResultHandler implements ResultHandler {
    private GlobalConfiguration configuration;

    public DefaultResultHandler(GlobalConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T handle(Object result, Class<T> resultType) {
        if (result instanceof ResultSet) {
            ResultSet rs = (ResultSet) result;
            try {
                if (rs.next()) {
                    Field[] fields = resultType.getDeclaredFields();
                    try {
                        T newObject = resultType.newInstance();
                        for (Field field : fields) {
                            String attributeName = field.getName();
                            Object fieldValue = rs.getObject(attributeName);
                            field.setAccessible(true);
                            field.set(newObject, fieldValue);
                        }
                        return newObject;
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T) result;
    }
}
