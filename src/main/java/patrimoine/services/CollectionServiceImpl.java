package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.models.Case;
import patrimoine.models.Collection;
import patrimoine.dao.CollectionMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public List<Collection> findAllData() {
        return collectionMapper.findAll();
    }

    /*@Override
    public void initializeData() {
        if(this.findAllData().size() == 0){
            List<List<String>> collection = new ArrayList<List<String>>();
            ArrayList<String> l=new ArrayList<>();
            l.add("nom");
            l.add("age");
            l.add("localité");
            l.add("test");
            collection.add(0, l);
            ArrayList<String> l1=new ArrayList<>();
            l1.add("loup");
            l1.add("5");
            l1.add("France");
            collection.add(1,l1);
            ArrayList<String> l2=new ArrayList<>();
            l2.add("chat");
            l2.add("10");
            l2.add("Angleterre");
            collection.add(2,l2);
            ArrayList<String> l3=new ArrayList<>();
            l3.add("");
            l3.add("15");
            l3.add("");
            collection.add(3, l3);
            this.saveCollection(collection);
        }
    }

    @Override
    public void saveCollection(List<List<String>> collection) {
        Table myTable = new Table();
        myTable.remplirTable(collection);
        collectionMapper.saveCollection(myTable);
    }*/

    @Override
    public List<Case> rechercherLigne(int idLigneCherche) {
        List<Case> ligne = new ArrayList<>();
        /*List<Case> tableArray = collectionMapper.getListById(0).getmListCase();
        for(Case currentCase : tableArray){
            if(currentCase.getLigne() == idLigneCherche)
                ligne.add(currentCase);
        }*/
        return  ligne;
    }

    @Override
    public Case rechercheCase(int idLigneCherche, String columnCherche) {
        Case maCase = new Case();
      /*  List<Case> tableTableau = collectionMapper.getListById(0).getmListCase();
        for(Case caseCourante : tableTableau){
            if(caseCourante.getLigne() == idLigneCherche && Objects.equals(caseCourante.getColumn(), columnCherche))
                maCase = caseCourante;
        }*/
        return maCase;
    }

}