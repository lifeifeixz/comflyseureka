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
package learn.ftp.man;

import org.apache.commons.net.ftp.FTPClient;

import java.io.InputStream;

/**
 * 作者：我是奥特man
 * 来源：CSDN
 * 原文：https://blog.csdn.net/wangpei555/article/details/71305603
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public interface FtpService {
    /*
     * 登录至FTP
     */
    public boolean loginFTP(FTPClient client, ReadFtpProperties rfp);

    /*
     * 退出ftp
     */
    public boolean logout(FTPClient client);//

    /*
     * 上传文件到remotePath，其在ftp上的名字为inputStream
     */
    public boolean uploadFile(FTPClient client, String remotePath,
                              String fileNewName, InputStream inputStream, ReadFtpProperties rfp);

    /*
     * 从目录remotePath，下载文件fileName
     */
    public InputStream downFileByFtp(FTPClient client, String remotePath,
                                     String fileName);

    /*
     * 删除ftp上的目录为pathName的文件
     */
    public boolean delFile(FTPClient client, String pathName);
}
