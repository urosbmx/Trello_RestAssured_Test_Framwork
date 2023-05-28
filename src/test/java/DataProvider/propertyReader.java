package DataProvider;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyReader {

    public static class API_values{
        private static Properties properties;

        static {
            try {
                String path ="src/test/resources/atlasian.properties";
                FileInputStream input = new FileInputStream(path);
                properties = new Properties();
                properties.load(input);
                input.close();
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
        public static String get(String keyName){return properties.getProperty(keyName);}
    }
}
