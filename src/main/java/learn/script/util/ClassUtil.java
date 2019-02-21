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

import script.dao.UserMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author flysLi
 * @ClassName ClassUtil
 * @Decription TODO
 * @Date 2018/12/19 11:19
 * @Version 1.0
 */
public class ClassUtil {
    public static Type[] getActualTypesByClass(Class<?> cls) {
        Type[] ts = cls.getGenericInterfaces();
        if (ts != null) {
            if (ts.length > 0) {
                ParameterizedType parameterizedType = (ParameterizedType) ts[0];
                return parameterizedType.getActualTypeArguments();
            }
        }
        return null;
    }
}
