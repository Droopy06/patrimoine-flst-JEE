package patrimoine.controllers;

import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import patrimoine.helper.Helper;
import patrimoine.models.Evenement;
import patrimoine.services.EvenementService;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Olive on 03/03/2017.
 */
@Controller
public class AdminEventsController {

    private final EvenementService evenementService;
    private Evenement evenement;
    private MultipartFile file;
    private HttpSession httpSession;

    @Autowired
    public AdminEventsController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @RequestMapping(value = {"/admin/evenement"}, method = RequestMethod.GET)
    public ModelAndView viewEvenement(HttpSession httpSession) throws IOException, BiffException {
        if (Helper.isConnect(httpSession)) {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("evenement", new Evenement());
            model.put("object",new Evenement());
            return new ModelAndView("patrimoine/Admin_Events", model);
        }
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = {"/admin/evenement/{titre}"}, method = RequestMethod.GET)
    public ModelAndView viewObjectsCollections(@PathVariable(value = "titre") String titre,
                                               HttpSession httpSession) throws IOException, BiffException {
        if(Helper.isConnect(httpSession)){
            HashMap<String, Object> model = new HashMap<>();
            model.put("evenement", new Evenement());
            model.put("object",new Evenement());
            model.put("titre",titre);
           return new ModelAndView("patrimoine/Admin_Event",model);
        }
        return new ModelAndView("redirect:/admin");
    }
    @RequestMapping(value = {"/admin/evenement/new"}, method = RequestMethod.POST)
    public ModelAndView createEvent(@ModelAttribute Evenement object,
                                    @RequestParam("file") MultipartFile file,
                                    HttpSession httpSession){

        evenementService.save(object);
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("redirect:/admin/evenement",model);
    }
    @RequestMapping(value = {"/admin/evenement/update"}, method = RequestMethod.POST)
    public ModelAndView updateEvent(@ModelAttribute Evenement object,
                                    HttpSession httpSession){

        evenementService.save(object);
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("redirect:/admin/evenement",model);
    }


}

