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
package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author flysLi
 * @ClassName ReadFormProcess
 * @Decription TODO
 * @Date 2019/3/8 16:35
 * @Version 1.0
 */
public class ReadFormProcess {
    public static void main(String[] args) throws IOException {
        //运行javac命令，返回运行该命令的子进程
        Process p=Runtime.getRuntime().exec("C:\\Users\\flysLi\\Desktop\\Google Chrome.lnk");
        try {
            //以p进程的错误流创建BufferedReader对象
            //这个错误流对本程序是输入流，对p进程则是输出流
            BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream(),"GBK"));
            {
                String buff=null;
                //采取循环方式来读取p进程的错误输出
                while((buff=br.readLine()) != null)
                {
                    System.out.println(buff);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
//
//        ---------------------
//                作者：_逐_流_
//        来源：CSDN
//        原文：https://blog.csdn.net/weixin_40857816/article/details/78397120
//        版权声明：本文为博主原创文章，转载请附上博文链接！
    }
}
