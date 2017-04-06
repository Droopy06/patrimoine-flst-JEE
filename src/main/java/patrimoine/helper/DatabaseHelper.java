package patrimoine.helper;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import static java.util.Collections.singletonList;

/**
 * Created by LAMOOT Alexandre on 02/04/2017.
 */
public class DatabaseHelper {

    private static Mongo mongo;
    private final static String host = "localhost";
    //@Value("${spring.data.mongodb.port}")
    private final static Integer port = 27017;
    //@Value("${spring.data.mongodb.username}")
    private final static String username = "patrimoine";
    //@Value("${spring.data.mongodb.database}")
    private final static String database = "patrimoine-flst";
    //@Value("${spring.data.mongodb.password}")
    private final static String password = "museehome";

    public static Mongo getInstance() throws Exception {
        if(mongo == null){
            mongo = new MongoClient(singletonList(new ServerAddress(host, port)),
                    singletonList(MongoCredential.createCredential(username,database, password.toCharArray())));
        }
        return mongo;
    }
}
