package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

    public static final String BASE_URI = getBaseUri();
    public static final String USERNAME = getUsername();
    public static final String PASSWORD = getPassword();

    private static String getBaseUri() {
        return getProperty("baseUri");
    }

    private static String getUsername() {
        return getProperty("username");
    }

    private static String getPassword() {
        return getProperty("password");
    }

    private static String getProperty(String property) {
        if (System.getProperty(property) != null) {
            return System.getProperty(property);
        } else {
            try {
                FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties");
                java.util.Properties prop = new java.util.Properties();

                prop.load(fis);
                return prop.get(property).toString();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
