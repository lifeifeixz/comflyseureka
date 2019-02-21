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
package script;

import script.core.SqlSession;
import script.core.config.GlobalConfiguration;
import script.core.impl.DefaultSqlSession;
import script.dao.UserMapper;
import script.entity.User;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/12/17 11:15
 * @Version 1.0
 */
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager()
                .getEngineByName("nashorn");
        engine.eval(new FileReader("D:\\workspace_srudent\\comflyseureka\\src\\main\\java\\script\\demo.js"));
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("showName", "李飞飞");
        System.out.println("java得到的结果");
        System.out.println(result);
    }
}

@SuppressWarnings("all")
class Test2 {
    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager()
                .getEngineByName("nashorn");
        engine.eval(new FileReader("D:\\workspace_srudent\\comflyseureka\\src\\main\\java\\script\\mapper\\userMapper.js"));
        Invocable invocable = (Invocable) engine;
        Map map = new HashMap<>(10);
        map.put("name", "李毛毛");
        map.put("age", "20");
        map.put("address", "北京市庐阳区");
        map.put("bird", "1998-12-17");
        Object result = invocable.invokeFunction("selectAll", map);
        System.out.println("java得到的结果");
        System.out.println(result);
    }
}

class Test3 {
    public static void main(String[] args) {
        SqlSession session = new DefaultSqlSession("");
        UserMapper userMapper = session.getMapper(UserMapper.class);
    }
}

class Test4 {
    public static void main(String[] args) {
        GlobalConfiguration config = new GlobalConfiguration();
        config.setDriver("com.mysql.jdbc.Driver");
        config.setUrl("jdbc:mysql://localhost:3306/test");
        config.setUser("root");
        config.setPwd("root");
        config.setMapperPackage("script.dao");
        config.setMapperPath("script.mapper");


        SqlSession session = new DefaultSqlSession(config);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findOne(1);
        System.out.println(user);
    }
}
