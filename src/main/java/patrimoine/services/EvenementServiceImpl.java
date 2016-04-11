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
    EvenementMapper evenementMapper;

    @Override
    public List<Evenement> findAllData() {
        return evenementMapper.findAll();
    }
}
