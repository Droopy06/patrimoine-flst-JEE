package patrimoine.services;

import patrimoine.classes.Table;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
public interface PatrimoineService {

    List<Table> findAllData();
    void saveCollection(List<List<String>> collection);
}
