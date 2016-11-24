package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import patrimoine.services.CollectionService;
import patrimoine.services.ExcelService;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class AdminController {
    @Autowired
    ExcelService excelService;

    @RequestMapping(value = { "/admin/import" }, method = RequestMethod.GET)
    public ModelAndView list() throws IOException, BiffException {
        excelService.readFileExcelCollectionImport("19- MATERIEL PEDAGOGIQUE (ICL-PEDA-000).xls");
        HashMap<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("patrimoine/Home",model);
    }
}
