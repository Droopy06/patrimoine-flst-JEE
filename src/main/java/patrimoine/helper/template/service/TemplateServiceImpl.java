package patrimoine.helper.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import patrimoine.helper.template.dao.TemplateMapper;
import patrimoine.helper.template.model.Template;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateMapper templateMapper;

    @Override
    public List<Template> findAll() {
        return templateMapper.findAll();
    }

    @Override
    public Template findOne(String id) {
        return templateMapper.findOne(id);
    }

    @Override
    public Template save(Template template) {
        return templateMapper.save(template);
    }

    @Override
    public void delete(Template template) {
        templateMapper.delete(template);
    }
}
