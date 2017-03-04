package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.EvenementMapper;
import patrimoine.models.Evenement;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Service
public class EvenementServiceImpl implements EvenementService{

    @Autowired
    private EvenementMapper evenementMapper;

    @Override
    public List<Evenement> findAll() {
        return evenementMapper.findAll();
    }

    @Override
    public Evenement findOne(String id) {
        return evenementMapper.findOne(id);
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
