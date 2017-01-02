package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.AdministratorMapper;
import patrimoine.models.Administrator;

import java.security.MessageDigest;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public List<Administrator> findAll() {
        return administratorMapper.findAll();
    }

    @Override
    public Administrator findOne(String email) {
        Administrator administrator = administratorMapper.findOne(email);
        return (administrator == null) ? new Administrator() : administrator;
    }

    @Override
    public Administrator save(Administrator administrator) {
        return administratorMapper.save(administrator);
    }

    @Override
    public void delete(Administrator administrator) {
        administratorMapper.delete(administrator);
    }

    /**
     * For encoding the password in sha256
     *
     * @param base
     * @return
     */
    public String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
