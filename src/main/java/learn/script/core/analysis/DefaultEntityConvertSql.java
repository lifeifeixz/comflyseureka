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

import java.lang.reflect.Field;

/**
 * @author flysLi
 * @ClassName DefaultEntityConvertSql
 * @Decription TODO
 * @Date 2018/12/19 13:17
 * @Version 1.0
 */
public class DefaultEntityConvertSql implements EntityConvertSql {
    private NameSpace nameSpace;
    private Object param;

    public String findOne() {
        String tableName = nameSpace.getGenericEntityType().getSimpleName();
        String primaryKey = nameSpace.getGenericPrimaryKeyType().getSimpleName();
        return "SELECT * FROM " + tableName + " WHERE " + primaryKey + "=" + param + ";";
    }

    public String findAll() {
        return "SELECT * FROM " + nameSpace.getGenericEntityType().getSimpleName() + ";";
    }

    public String delete() {
        String table = nameSpace.getGenericEntityType().getSimpleName();
        String primaryKey = nameSpace.getGenericPrimaryKeyType().getSimpleName();
        return "DELETE FROM " + table + " WHERE " + primaryKey + "=" + param;
    }

    public String update() {
        Class<?> cls = nameSpace.getGenericEntityType();
        String table = cls.getSimpleName();
        String primaryKey = nameSpace.getGenericPrimaryKeyType().getSimpleName();
        Field[] fields = cls.getDeclaredFields();
        StringBuffer sql = new StringBuffer("UPDATE " + table + " SET ");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object val = field.get(param);
                if (val != null) {
                    sql.append(field.getName() + "='" + val + "' ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sql.append(" WHERE " + primaryKey + "=?");

        return sql.toString();
    }

    public String count() {
        String table = nameSpace.getGenericEntityType().getSimpleName();
        String primaryKey = nameSpace.getGenericPrimaryKeyType().getSimpleName();
        return "SELECT COUNT(*) FROM " + table;
    }


    @Override
    public String convert(String method, NameSpace nameSpace, Object param) {
        this.nameSpace = nameSpace;
        this.param = param;
        switch (method) {
            case "findOne":
                return findOne();
            case "findAll":
                return findAll();
            case "delete":
                return delete();
            case "update":
                return update();
            case "count":
                return count();
        }
        return null;
    }
}
