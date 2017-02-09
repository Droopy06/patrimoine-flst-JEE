package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import patrimoine.DatabaseConfiguration;
import patrimoine.helper.DefaultClassCollection;
import patrimoine.helper.Helper;
import patrimoine.models.Collection;
import patrimoine.models.Herbiers;
import patrimoine.models.Pedagogique;
import patrimoine.services.CollectionService;
import sun.print.PeekGraphics;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class AdminCollectionsController {

    private final CollectionService collectionService;

    @Autowired
    public AdminCollectionsController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @RequestMapping(value = { "/admin/collections" }, method = RequestMethod.GET)
    public ModelAndView viewCollections(HttpSession httpSession) throws IOException, BiffException {
        if(Helper.isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("collection",new Collection());
            return new ModelAndView("patrimoine/Admin_Collections",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/collections/{nameCollection}" }, method = RequestMethod.GET)
    public ModelAndView viewObjectsCollections(@PathVariable(value = "nameCollection") String nameCollection,
                                               HttpSession httpSession) throws IOException, BiffException {
        if(Helper.isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<>();
            model.put("collection",nameCollection);
            model.put("nameCollection",nameCollection);
            model.put("object",new Pedagogique());
            return new ModelAndView("patrimoine/Admin_Collection",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/collections/{nameCollection}/{object}" }, method = RequestMethod.GET)
    public ModelAndView viewObjectsCollections(@PathVariable(value = "nameCollection") String nameCollection,
                                               @PathVariable(value = "object") String object,
                                               HttpSession httpSession) throws IOException, BiffException {
        if(Helper.isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<>();
            model.put("object",object);
            model.put("nameCollection",nameCollection);
            return new ModelAndView("patrimoine/Admin_Object",model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = { "/admin/collection/new" }, method = RequestMethod.POST)
    public ModelAndView createCollection(@ModelAttribute DefaultClassCollection object,
                                         @RequestParam("file") MultipartFile file,
                                         HttpSession httpSession){
        Pedagogique pedagogique = new Pedagogique();
        if (object instanceof Pedagogique)
            pedagogique = ((Pedagogique) object);
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("patrimoine/Admin-login",model);
    }
}
