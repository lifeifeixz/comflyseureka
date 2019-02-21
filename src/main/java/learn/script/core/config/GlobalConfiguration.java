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

/**
 * @author flysLi
 * @ClassName GlobalConfiguration
 * @Decription TODO
 * @Date 2018/12/18 9:50
 * @Version 1.0
 */
public class GlobalConfiguration {
    private String url;
    private String user;
    private String pwd;
    private String driver;
    private String mapperPackage;
    private String mapperPath;
    private Map<String,NameSpace> nameSpaceMap;

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public Map<String, NameSpace> getNameSpaceMap() {
        return nameSpaceMap;
    }

    public void setNameSpaceMap(Map<String, NameSpace> nameSpaceMap) {
        this.nameSpaceMap = nameSpaceMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }
}
