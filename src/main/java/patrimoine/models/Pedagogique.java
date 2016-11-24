package patrimoine.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Document(collection = "pedagogique")
public class Pedagogique {
    private @Getter @Setter String id;
    private @Getter @Setter String picture;
    private @Getter @Setter String name;
    private @Getter @Setter String groupe;
    private @Getter @Setter String kind;
    private @Getter @Setter String espece;
    private @Getter @Setter String author;
    private @Getter @Setter String year;
    private @Getter @Setter String country;
    private @Getter @Setter String city;
    private @Getter @Setter String place;
    private @Getter @Setter String nameCollection;
    private @Getter @Setter String manifold;
    private @Getter @Setter String localization;
    private @Getter @Setter String retentionColor;
    private @Getter @Setter String retentionMechanism;
    private @Getter @Setter String retentionVarnish;
    private @Getter @Setter String retentionProperty;
    private @Getter @Setter String stateModel;
    private @Getter @Setter String type;
    private @Getter @Setter String SignatureType;
    private @Getter @Setter String SignatureInscription;
    private @Getter @Setter String Structure;
    private @Getter @Setter String buyingPrice;
    private @Getter @Setter String buyingPriceCommercial;
    private @Getter @Setter String descriptif;
    private @Getter @Setter String dimensions;
    private @Getter @Setter Integer numberElements;
    private @Getter @Setter String administrator;
}
