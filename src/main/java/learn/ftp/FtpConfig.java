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

/**
 * @author flysLi
 * @ClassName FtpConfig
 * @Decription TODO
 * @Date 2018/11/13 11:40
 * @Version 1.0
 */
public class FtpConfig {
    private int port = 21; //ftp端口
    private String ftpLoginName = "bxu2343060098"; //ftp服务器登录账户
    private String ftpLoginPwd = "88Share1234"; //ftp服务器登录密码
    private String hostName = "bxu2343060098.my3w.com"; //ftp主机ip
    private String basePath = "/htdocs/"; //ftp文件基础路径
    private String baseImgUrl; //ftp前端界面图片访问路径

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFtpLoginName() {
        return ftpLoginName;
    }

    public void setFtpLoginName(String ftpLoginName) {
        this.ftpLoginName = ftpLoginName;
    }

    public String getFtpLoginPwd() {
        return ftpLoginPwd;
    }

    public void setFtpLoginPwd(String ftpLoginPwd) {
        this.ftpLoginPwd = ftpLoginPwd;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBaseImgUrl() {
        return baseImgUrl;
    }

    public void setBaseImgUrl(String baseImgUrl) {
        this.baseImgUrl = baseImgUrl;
    }
}
