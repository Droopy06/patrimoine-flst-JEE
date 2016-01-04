package patrimoine.models;

import patrimoine.classes.Table;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */

public interface PatrimoineMapper {

    List<Table> findAll();
    void saveCollection(Table myTable);
}
