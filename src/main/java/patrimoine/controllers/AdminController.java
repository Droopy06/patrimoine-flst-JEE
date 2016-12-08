package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import patrimoine.services.ExcelService;
import patrimoine.services.utility.StorageService;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class AdminController {

    private final ExcelService excelService;
    private final StorageService storageService;

    @Autowired
    public AdminController(ExcelService excelService, StorageService storageService) {
        this.excelService = excelService;
        this.storageService = storageService;
    }

    @RequestMapping(value = { "/admin/import" }, method = RequestMethod.POST)
    public ModelAndView readFile(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) throws IOException, BiffException {
        storageService.store(file);
        excelService.readFileExcelCollectionImport(file.getName());
        HashMap<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("patrimoine/Import-export",model);
    }

    @RequestMapping(value = { "/admin/import" }, method = RequestMethod.GET)
    public ModelAndView importFile() throws IOException, BiffException {
        HashMap<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("patrimoine/Import-export",model);
    }
}
