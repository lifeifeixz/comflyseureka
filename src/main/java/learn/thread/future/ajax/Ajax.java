
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
package thread.future.ajax;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @author flysLi
 * @ClassName Ajax
 * @Decription TODO
 * @Date 2018/10/29 16:35
 * @Version 1.0
 */
public class Ajax {

    public static void get(String uri, RequestCallback callback) {
        new Thread(() -> request(uri, callback)).start();
    }

    public static void post(String uri, RequestCallback callback) {

    }

    public static void post(String uri, Map<String, Object> params, RequestCallback callback) {

    }

    public static String request(String uri, RequestCallback callback) {
        URLConnection connection;
        InputStream inputStream;
        try {
            URL url = new URL(uri);
            try {
                connection = url.openConnection();
                connection.setConnectTimeout(30000);
                inputStream = connection.getInputStream();
                byte[] bytes;
                bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                return new String(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        URLConnection connection;
        InputStream inputStream;
        try {
            URL url = new URL("https://blog.csdn.net/lmy86263/article/details/60479350");
            try {
                connection = url.openConnection();
                connection.setConnectTimeout(30000);
                inputStream = connection.getInputStream();
                byte[] bytes = new byte[0];
                bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                String str = new String(bytes);
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author flysLi
     * @date 2018/10/29
     */
    public interface RequestCallback {

        /**
         * 请求成功后得到的数据会传入call方法中
         *
         * @param o
         */
        void call(Object o);
    }
}
