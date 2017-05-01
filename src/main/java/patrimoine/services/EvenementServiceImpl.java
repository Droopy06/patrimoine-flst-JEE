package patrimoine.services;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import patrimoine.dao.EvenementMapper;
import patrimoine.helper.database.CustomSortEvenements;
import patrimoine.models.Evenement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Service
public class EvenementServiceImpl implements EvenementService{

    @Autowired
    private EvenementMapper evenementMapper;
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Evenement> findAll() {
        return evenementMapper.findAll();
    }

    @Override
    public Evenement findOne(String id) {
        return evenementMapper.findOne(id);
    }

    @Override
    public List<Evenement> findOneByTitle(List<String> title) {
        List<Evenement> evenements;
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("titre").in(title));
        evenements = mongoOperations.find(query4, Evenement.class);
        evenements.sort(new CustomSortEvenements());
        return evenements;
    }

    @Override
    public List<Evenement> findOneByPosition(List<Integer> postion) {
        List<Evenement> evenements;
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("position").in(postion));
        evenements = mongoOperations.find(query4, Evenement.class);
        return evenements;
    }

    @Override
    public List<Evenement> findEvenementsForHome() {
        List<Evenement> evenements;
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("position").gt(0));
        evenements = mongoOperations.find(query4, Evenement.class);
        return evenements;
    }

    @Override
    public Evenement save(Evenement evenement) {
        return evenementMapper.save(evenement);
    }

    @Override
    public void delete(Evenement evenement) {
        evenementMapper.delete(evenement);
    }

}
