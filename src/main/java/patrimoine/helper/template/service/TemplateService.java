package patrimoine.helper.template.service;

import patrimoine.helper.template.model.Template;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface TemplateService {
    List<Template> findAll();
    Template findOne(String id);
    Template save(Template template);
    void delete(Template template);
}
