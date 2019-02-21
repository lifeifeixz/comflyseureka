package learn.degisn.fbatis.config;

import learn.degisn.fbatis.Configuration;

/**
 * @author flysLi
 * @date 2018/11/27
 */
public interface ResourceLoader {

    /**
     * 初始化全局配置
     *
     * @param resource 配置文件所在地址
     * @return
     */
    Configuration loadConfiguration(String resource);

}
