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

import script.common.DropPolicy;
import script.core.Executor;
import script.core.ResultHandler;
import script.core.config.GlobalConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author flysLi
 * @ClassName DefaultExecutor
 * @Decription TODO
 * @Date 2018/12/17 14:47
 * @Version 1.0
 */
@SuppressWarnings("all")
public class DefaultExecutor implements Executor {
    private GlobalConfiguration configuration;
    private Connection connection;
    private ResultHandler resultHandler;


    public DefaultExecutor(GlobalConfiguration configuration) {
        this.configuration = configuration;
        resultHandler = new DefaultResultHandler(configuration);
    }

    public Object executeQuery(String sql) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer executeUpdate(String sql) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public <T> T execute(String sql, String dropType, Class<T> returnType) {
        try {
            System.out.println(sql);
            this.connection = JDBCUtil.open();
            Object result = null;
            if (dropType.equals(DropPolicy.Select.name())) {
                result = executeQuery(sql);
            } else {
                result = executeUpdate(sql);
            }
            return resultHandler.handle(result, returnType);
        } catch (Exception e) {

        } finally {
            JDBCUtil.close(connection);
        }
        return null;
    }
}
