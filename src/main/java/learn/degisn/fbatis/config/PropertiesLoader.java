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
package learn.degisn.fbatis.config;

import learn.degisn.fbatis.Configuration;
import learn.degisn.fbatis.beans.DBParamter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author flysLi
 * @ClassName PropertiesLoader
 * @Decription TODO
 * @Date 2018/11/27 21:40
 * @Version 1.0
 */
public class PropertiesLoader implements ResourceLoader {
    @Override
    public Configuration loadConfiguration(String resource) {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(resource);
            properties.load(inputStream);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            DBParamter paramter = new DBParamter();
            paramter.setDriver(driver);
            paramter.setUsername(username);
            paramter.setUrl(url);
            paramter.setPassword(password);
            configuration.setDbParamter(paramter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }
}
