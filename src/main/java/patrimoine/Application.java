package patrimoine;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DatabaseConfiguration.class})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
        /*MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // Now connect to your databases
        DB db = mongoClient.getDB( "patrimoine-flst" );*/
    }
}