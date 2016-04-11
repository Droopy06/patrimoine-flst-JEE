package patrimoine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Document(collection = "objet")
public class Objet {
    private @Getter @Setter String id;
    private @Getter @Setter String titre;
    private @Getter @Setter String uri;
    private @Getter @Setter String img;
    private @Getter @Setter String description1;
    private @Getter @Setter String description2;
    private @Getter @Setter String description3;
}
