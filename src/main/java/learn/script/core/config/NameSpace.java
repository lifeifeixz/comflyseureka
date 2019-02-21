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
package script.core.config;

import java.util.Map;

public class NameSpace {
    private String mapperPath;
    private Class<?> genericEntityType;
    private Class<?> genericPrimaryKeyType;
    private String primaryKeyName;
    private Map<String, FuncMethod> funcMethodMap;

    public NameSpace() {
    }

    public NameSpace(String mapperPath, Map<String, FuncMethod> funcMethodMap) {
        this.mapperPath = mapperPath;
        this.funcMethodMap = funcMethodMap;
    }

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    public Class<?> getGenericEntityType() {
        return genericEntityType;
    }

    public void setGenericEntityType(Class<?> genericEntityType) {
        this.genericEntityType = genericEntityType;
    }

    public Class<?> getGenericPrimaryKeyType() {
        return genericPrimaryKeyType;
    }

    public void setGenericPrimaryKeyType(Class<?> genericPrimaryKeyType) {
        this.genericPrimaryKeyType = genericPrimaryKeyType;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public Map<String, FuncMethod> getFuncMethodMap() {
        return funcMethodMap;
    }

    public void setFuncMethodMap(Map<String, FuncMethod> funcMethodMap) {
        this.funcMethodMap = funcMethodMap;
    }
}
