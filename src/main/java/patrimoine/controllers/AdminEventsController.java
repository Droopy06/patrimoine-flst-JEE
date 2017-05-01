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

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
    public ModelAndView viewObjectsEvenements(@PathVariable(value = "titre") String titre,
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
                                    HttpSession httpSession){
        object.setPosition(0);
        evenementService.save(object);
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("redirect:/admin/evenement",model);
    }
    @RequestMapping(value = {"/admin/evenement/update"}, method = RequestMethod.POST)
    public ModelAndView updateEvent(HttpServletRequest request, HttpSession httpSession){
        List<String> eventTitle = new ArrayList<>();
        eventTitle.add(request.getParameter("titre"));
        Evenement evenement = evenementService.findOneByTitle(eventTitle).get(0);
        evenement.setId(request.getParameter("id"));
        evenement.setTitre(request.getParameter("titre"));
        evenement.setMiniDescr(request.getParameter("miniDescr"));
        evenement.setTwitter(request.getParameter("twitter"));
        evenement.setFacebook(request.getParameter("facebook"));
        evenement.setGo(request.getParameter("go"));
        evenementService.save(evenement);
        HashMap<String, Object> model = new HashMap<>();
        return new ModelAndView("redirect:/admin/evenement",model);
    }

    @RequestMapping(value = {"/admin/evenement/home/{position}"}, method = RequestMethod.POST)
    public ModelAndView updateEventPosition(@PathVariable(value = "position") String position,
                                            HttpServletRequest request,
                                            HttpSession httpSession){
        List<Integer> intPosition = new ArrayList<>();
        List<String> titleEvent = new ArrayList<>();
        intPosition.add(Integer.parseInt(position));
        titleEvent.add(request.getParameter("event"));
        Evenement oldEvenement = evenementService.findOneByPosition(intPosition).get(0);
        Evenement newEvenement = evenementService.findOneByTitle(titleEvent).get(0);
        oldEvenement.setPosition(0);
        newEvenement.setPosition(Integer.parseInt(position));
        evenementService.save(oldEvenement);
        evenementService.save(newEvenement);
        return new ModelAndView("redirect:/admin");
    }
}

