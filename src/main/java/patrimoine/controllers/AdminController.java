package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import patrimoine.models.Administrator;
import patrimoine.models.Collection;
import patrimoine.services.ExcelService;
import patrimoine.services.daoServices.AdministratorService;
import patrimoine.services.utility.StorageService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class AdminController {

    private final ExcelService excelService;
    private final StorageService storageService;
    private final AdministratorService administratorService;

    @Autowired
    public AdminController(ExcelService excelService, StorageService storageService, AdministratorService administratorService) {
        this.excelService = excelService;
        this.storageService = storageService;
        this.administratorService = administratorService;
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public ModelAndView admin(HttpSession httpSession){
        HashMap<String, Object> model = new HashMap<String, Object>();
        if(isConnect(httpSession)){
            return new ModelAndView("redirect:/admin/home",model);
        }
        model.put("administrator",new Administrator());
        return new ModelAndView("patrimoine/Admin-login",model);
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.POST)
    public ModelAndView adminLogin(@ModelAttribute Administrator administrator,HttpSession httpSession){
        Administrator adminMongo = administratorService.findOne(administrator.getEmail());
        if(administratorService.sha256(administrator.getPassword()).equals(adminMongo.getPassword()) && adminMongo.isActivated()){
            httpSession.setAttribute("administrator",adminMongo);
            return new ModelAndView("redirect:/admin/home");
        }
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("administrator",new Administrator());
        return new ModelAndView("patrimoine/Admin-login",model);
    }

    @RequestMapping(value = { "/admin/home" }, method = RequestMethod.GET)
    public ModelAndView adminHome(HttpSession httpSession){
        HashMap<String, Object> model = new HashMap<String, Object>();
        if(isConnect(httpSession)){
            return new ModelAndView("patrimoine/Admin_Home",model);
        }
        return new ModelAndView("redirect:/admin",model);
    }

    @RequestMapping(value = { "/admin/import" }, method = RequestMethod.POST)
    public ModelAndView readFile(@RequestParam("file") MultipartFile file,
                                 @ModelAttribute Collection collection,
                                 RedirectAttributes redirectAttributes) throws IOException, BiffException {
        storageService.store(file);
        excelService.loadFileExcelCollectionImport(file.getOriginalFilename());
        excelService.readFileExcelCollectionImport(collection.getNom());
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("collection",new Collection());
        return new ModelAndView("patrimoine/Import-export",model);
    }

    @RequestMapping(value = { "/admin/import" }, method = RequestMethod.GET)
    public ModelAndView importFile(HttpSession httpSession) throws IOException, BiffException {
        if(isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("collection",new Collection());
            return new ModelAndView("patrimoine/Import-export",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/export" }, method = RequestMethod.POST)
    public String writeFile(@ModelAttribute Collection collection,
                                  RedirectAttributes redirectAttributes,
                                  HttpSession httpSession) throws IOException, BiffException, WriteException {
            excelService.writeFileExcelExport(collection.getNom());
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("collection", new Collection());
            return "redirect:/admin/import";
    }

    @RequestMapping(value = {"/admin/deconnexion"}, method = RequestMethod.GET)
    public String deconnexion(HttpSession httpSession) {
        if(httpSession.getAttribute("administrator") != null){
            httpSession.setAttribute("administrator",null);
        }
        return "redirect:/admin";
    }

    private boolean isConnect(HttpSession session){
        boolean isConnect = false;
        if(session.getAttribute("administrator") != null){
            if(!session.getAttribute("administrator").equals(""))
                isConnect = true;
            else
                isConnect = false;
        }else
            isConnect = false;
        return isConnect;
    }
}
