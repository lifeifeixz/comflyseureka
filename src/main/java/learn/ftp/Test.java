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
package learn.ftp;

import java.io.File;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/11/13 11:55
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Ftp f = new Ftp();
        f.setIpAddr("60.205.27.217");
        f.setUserName("bxu2343060098");
        f.setPwd("88Share1234");
        FtpUtil.connectFtp(f);
        File file = new File("D:\\temp\\Z账户资料\\官网ftp.txt");
        FtpUtil.upload(file);//把文件上传在ftp上
        System.out.println("上传文件完成。。。。");
    }
}
