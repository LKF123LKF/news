package com.kgc.util;

import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: LKF
 * @date: 2019/3/27 9:45
 */
public class ConfigManager {
    private static ConfigManager configManager;
//    properties.load(InputStream)读取属性文件
    private static Properties properties;

    private ConfigManager(){
        String cofigFile="database.properties";
        properties=new Properties();
        InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(cofigFile);
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance(){
        if (configManager == null) {
            configManager=new ConfigManager();
        }
        return configManager;
    }

//    通过key获取相应的value
    public String getString(String key){
        return properties.getProperty(key);
    }
}
