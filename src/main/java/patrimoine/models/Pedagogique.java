package patrimoine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import patrimoine.helper.DefaultClassCollection;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Document(collection = "pedagogique")
public class Pedagogique extends DefaultClassCollection {

    /*private @Getter @Setter T object;

    public Pedagogique(T object) {
        this.object = object;
    }

    public Pedagogique() {
        this.object = null;
    }*/
}
