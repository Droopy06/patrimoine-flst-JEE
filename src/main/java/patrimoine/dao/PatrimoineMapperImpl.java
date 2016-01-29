package patrimoine.dao;

import org.springframework.stereotype.Repository;
import patrimoine.models.Table;

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
    public Table getListById(int id) {
        return listCollection.get(id);
    }

    @Override
    public void saveCollection(Table myTable) {
        listCollection.add(myTable);
    }
}
