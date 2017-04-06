package patrimoine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 01/04/2017.
 */
@Document(collection = "contact")
public class Contact {
    private @Getter @Setter String name;
    private @Getter @Setter String lastName;
    private @Getter @Setter String mail;
    private @Getter @Setter String subject;
    private @Getter @Setter String message;
    private @Getter @Setter String category;
}
