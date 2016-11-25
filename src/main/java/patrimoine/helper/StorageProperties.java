package patrimoine.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    public final static String location = "files";
}
