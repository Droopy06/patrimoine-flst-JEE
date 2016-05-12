package patrimoine;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static java.util.Collections.singletonList;

/**
 * Created by LAMOOT Alexandre on 17/03/2016.
 */
@Configuration
@EnableMongoRepositories("patrimoine")
public class DatabaseConfiguration extends AbstractMongoConfiguration {
    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
    //@Value("${spring.data.mongodb.host}")
    private final static String host = "vps278022.ovh.net";
    //@Value("${spring.data.mongodb.port}")
    private final static Integer port = 27017;
    //@Value("${spring.data.mongodb.username}")
    private final static String username = "patrimoine";
    //@Value("${spring.data.mongodb.database}")
    private final static String database = "patrimoine-flst";
    //@Value("${spring.data.mongodb.password}")
    private final static String password = "museehome";
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    @Override
    public String getDatabaseName() {
        return database;
    }
    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress(host, port)),
                singletonList(MongoCredential.createCredential(username,database, password.toCharArray())));
    }
}
