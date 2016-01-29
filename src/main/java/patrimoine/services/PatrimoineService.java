package patrimoine.services;

import patrimoine.models.Case;
import patrimoine.models.Table;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
public interface PatrimoineService {

    List<Table> findAllData();
    void initializeData();
    void saveCollection(List<List<String>> collection);
    List<Case> rechercherLigne(int idLigneCherche);
    Case rechercheCase(int idLigneCherche,String columnCherche);
}
