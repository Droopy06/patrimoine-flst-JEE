package patrimoine.helper.database;

import patrimoine.helper.DefaultClassCollection;
import patrimoine.models.Evenement;

import java.util.Comparator;

/**
 * Created by LAMOOT Alexandre on 23/03/2017.
 */
public class CustomSortDefaultClassCollection implements Comparator<DefaultClassCollection> {
    @Override
    public int compare(DefaultClassCollection o1, DefaultClassCollection o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
