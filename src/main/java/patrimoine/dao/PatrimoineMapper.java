package patrimoine.dao;

import patrimoine.models.Table;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */

public interface PatrimoineMapper {

    List<Table> findAll();
    Table getListById(int id);
    void saveCollection(Table myTable);
}
