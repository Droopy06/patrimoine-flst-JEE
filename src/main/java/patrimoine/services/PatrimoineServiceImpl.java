package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.classes.Table;
import patrimoine.models.PatrimoineMapper;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
@Service
public class PatrimoineServiceImpl implements PatrimoineService{

    @Autowired
    PatrimoineMapper patrimoineMapper;

    @Override
    public List<Table> findAllData() {
        return patrimoineMapper.findAll();
    }

    @Override
    public void saveCollection(List<List<String>> collection) {
        Table myTable = new Table();
        myTable.remplirTable(collection);
        patrimoineMapper.saveCollection(myTable);
    }
}
