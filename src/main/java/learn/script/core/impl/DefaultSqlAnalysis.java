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

import script.core.SqlAnalysis;
import script.core.analysis.DispatchEntityConvertSql;
import script.core.analysis.EntityConvertSql;
import script.core.config.GlobalConfiguration;
import script.core.config.NameSpace;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.annotation.Annotation;

/**
 * @author flysLi
 * @ClassName DefaultSqlAnalysis
 * @Decription TODO
 * @Date 2018/12/17 14:53
 * @Version 1.0
 */
public class DefaultSqlAnalysis implements SqlAnalysis {
    private ScriptEngine engine;
    private GlobalConfiguration configuration;
    private EntityConvertSql convertSql;

    public DefaultSqlAnalysis(GlobalConfiguration configuration) {
        this.configuration = configuration;
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
        this.convertSql = new DispatchEntityConvertSql();
    }

    public DefaultSqlAnalysis() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    @Override
    public String splitSql(String nameSpace, String method, Object param) {
        try {
            engine.eval(new FileReader(nameSpace));
            Invocable invocable = (Invocable) engine;
            try {
                return invocable.invokeFunction(method, param).toString();
            } catch (NoSuchMethodException e) {
                /*当找不到method的时候,使用jpa模式*/
                nameSpace = nameSpace.substring(nameSpace.lastIndexOf("\\")+1,nameSpace.lastIndexOf("."));
                NameSpace ns = configuration.getNameSpaceMap().get(nameSpace.toUpperCase());
                return convertSql.convert(method, ns, param);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String splitFieldByEntity(Class<?> entityCls) {


        return null;
    }

    public static void main(String[] args) {

        String path = DefaultSqlAnalysis.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
    }
}
