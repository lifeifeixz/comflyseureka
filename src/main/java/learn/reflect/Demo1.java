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
package reflect;

import reflect.bean.User;

import java.lang.reflect.Field;

/**
 * @author flysLi
 * @ClassName Demo1
 * @Decription TODO
 * @Date 2018/12/10 16:07
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        /* 通过Class类中的静态方法forName,直接获取到一个类的字节码文件对象，
         此时该类还是源文件阶段，并没有变为字节码文件。*/
        Class cls = Class.forName("reflect.bean.User");

        /*当类被加载成.class文件时，此时Person类变成了.class，
        在获取该字节码文件对象，也就是获取自己， 该类处于字节码阶段。*/
        cls = User.class;

        /*通过类的实例获取该类的字节码文件对象，该类处于创建对象阶段*/
        cls=new User().getClass();

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }
}
