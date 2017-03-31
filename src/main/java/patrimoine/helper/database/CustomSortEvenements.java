package patrimoine.helper.database;

import patrimoine.models.Evenement;

import java.util.Comparator;

/**
 * Created by LAMOOT Alexandre on 23/03/2017.
 */
public class CustomSortEvenements implements Comparator<Evenement> {
    @Override
    public int compare(Evenement o1, Evenement o2) {
        return o1.getTitre().compareTo(o2.getTitre());
    }
}
