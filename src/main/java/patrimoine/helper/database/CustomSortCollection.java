package patrimoine.helper.database;

import patrimoine.models.Collection;
import patrimoine.models.Evenement;

import java.util.Comparator;

/**
 * Created by LAMOOT Alexandre on 23/03/2017.
 */
public class CustomSortCollection implements Comparator<Collection> {
    @Override
    public int compare(Collection o1, Collection o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
