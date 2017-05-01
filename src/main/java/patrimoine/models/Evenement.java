package patrimoine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Document(collection = "evenement")
public class Evenement {
    private @Getter @Setter String id;
    private @Getter @Setter String titre;
    private @Getter @Setter String miniDescr;
    private @Getter @Setter String imageuri;
    private @Getter @Setter String miniimageuri;
    private @Getter @Setter String twitter;
    private @Getter @Setter String facebook;
    private @Getter @Setter String go;
    private @Getter @Setter Integer position;
    private @Getter @Setter ArrayList<String> gallery;
}
