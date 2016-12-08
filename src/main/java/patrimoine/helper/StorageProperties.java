package patrimoine.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;
import java.io.IOException;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    public static String location = "C:/Users/prog/Documents/GitHub/";

    public StorageProperties() throws IOException {
        location = new File(".").getCanonicalPath()+"\\src\\main\\resources\\static\\files\\";
    }
}
