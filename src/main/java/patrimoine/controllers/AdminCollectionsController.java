package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import patrimoine.models.Administrator;
import patrimoine.models.Collection;
import patrimoine.services.CollectionService;
import patrimoine.services.ExcelService;
import patrimoine.services.daoServices.AdministratorService;
import patrimoine.services.utility.StorageService;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class AdminCollectionsController {

    private final CollectionService collectionService;

    @Autowired
    public AdminCollectionsController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @RequestMapping(value = { "/admin/collections" }, method = RequestMethod.GET)
    public ModelAndView viewCollections(HttpSession httpSession) throws IOException, BiffException {
        if(isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("collection",new Collection());
            return new ModelAndView("patrimoine/Admin_Collections",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/collections/{nameCollection}" }, method = RequestMethod.GET)
    public ModelAndView viewObjectsCollections(@PathVariable(value = "nameCollection") String nameCollection,
                                               HttpSession httpSession) throws IOException, BiffException {
        if(isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("collection",nameCollection);
            model.put("nameCollection",nameCollection);
            return new ModelAndView("patrimoine/Admin_Collection",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/collections/{nameCollection}/{object}" }, method = RequestMethod.GET)
    public ModelAndView viewObjectsCollections(@PathVariable(value = "nameCollection") String nameCollection,
                                               @PathVariable(value = "object") String object,
                                               HttpSession httpSession) throws IOException, BiffException {
        if(isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("object",object);
            model.put("nameCollection",nameCollection);
            return new ModelAndView("patrimoine/Admin_Object",model);
        }
        return new ModelAndView("redirect:/admin");
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
