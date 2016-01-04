package patrimoine.models;

import org.springframework.stereotype.Repository;
import patrimoine.classes.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
@Repository
public class PatrimoineMapperImpl implements PatrimoineMapper{

    private List<Table> listCollection = new ArrayList<>();

    @Override
    public List<Table> findAll() {
        return this.listCollection;
    }

    @Override
    public void saveCollection(Table myTable) {
        listCollection.add(myTable);
    }
}
