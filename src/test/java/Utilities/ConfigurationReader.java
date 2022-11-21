package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {

            //which file to read
            String path="conf.properties";
            //read file in java using string path
            FileInputStream input=new FileInputStream(path);

            //properties class that store properties in key value format
            properties=new Properties();

            properties.load(input);
            input.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
