package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Collection;
import patrimoine.models.Pedagogique;
import patrimoine.services.PedagogiqueService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimone")
public class PedagogiqueRestController {

    @Autowired
    PedagogiqueService pedagogiqueService;

    @Autowired
    public PedagogiqueRestController(PedagogiqueService pedagogiqueService) {
        this.pedagogiqueService = pedagogiqueService;
        List<Pedagogique> pedagogiqueList = this.pedagogiqueService.findAll();
    }

    @RequestMapping(value = "/pedagogique",method = RequestMethod.GET)
    public List<Pedagogique> getAllPedagogique(){
        return pedagogiqueService.findAll();
    }

    @RequestMapping(value = "/pedagogique/save",method = RequestMethod.GET)
    public Pedagogique savePedagogique(){
        Pedagogique pedagogique = new Pedagogique();
        pedagogique.setId("ICL-PEDA-002");
        pedagogique.setPicture("19-PHOTO MATERIEL PEDAGOGIQUE\\ICL-PEDA-001 (Abeilles).JPG");
        pedagogique.setName("Abeilles");
        pedagogique.setGroupe("Insectes");
        pedagogique.setKind("Apis");
        pedagogique.setEspece("mellifica");
        pedagogique.setAuthor("");
        pedagogique.setYear("1877");
        pedagogique.setCountry("France");
        pedagogique.setCity("Saint-Aubin-d’Ecrosville (Eure)");
        pedagogique.setPlace("");
        pedagogique.setNameCollection("Auzoux");
        pedagogique.setManifold("");
        pedagogique.setLocalization("");
        pedagogique.setRetentionColor("non écaillé");
        pedagogique.setRetentionMechanism("complet");
        pedagogique.setRetentionVarnish("non écaillé");
        pedagogique.setRetentionProperty("très bonne");
        pedagogique.setStateModel("complet");
        pedagogique.setType("ensemble écologique");
        pedagogique.setSignatureType("manuscrit");
        pedagogique.setSignatureInscription("Auzoux Doctr , fecit anno 1877");
        pedagogique.setStructure("démontable");
        pedagogique.setBuyingPrice("200");
        pedagogique.setBuyingPriceCommercial("");
        pedagogique.setDescriptif("non");
        pedagogique.setDimensions("");
        pedagogique.setNumberElements(0);
        pedagogique.setAdministrator("FGES");
        return pedagogiqueService.save(pedagogique);
    }

    @RequestMapping(value = "/pedagogique/delete",method = RequestMethod.GET)
    public void deletePedagogique(){
        Pedagogique pedagogique = new Pedagogique();
        pedagogique.setId("ICL-PEDA-002");
        pedagogique.setPicture("19-PHOTO MATERIEL PEDAGOGIQUE\\ICL-PEDA-001 (Abeilles).JPG");
        pedagogique.setName("Abeilles");
        pedagogique.setGroupe("Insectes");
        pedagogique.setKind("Apis");
        pedagogique.setEspece("mellifica");
        pedagogique.setAuthor("");
        pedagogique.setYear("1877");
        pedagogique.setCountry("France");
        pedagogique.setCity("Saint-Aubin-d’Ecrosville (Eure)");
        pedagogique.setPlace("");
        pedagogique.setNameCollection("Auzoux");
        pedagogique.setManifold("");
        pedagogique.setLocalization("");
        pedagogique.setRetentionColor("non écaillé");
        pedagogique.setRetentionMechanism("complet");
        pedagogique.setRetentionVarnish("non écaillé");
        pedagogique.setRetentionProperty("très bonne");
        pedagogique.setStateModel("complet");
        pedagogique.setType("ensemble écologique");
        pedagogique.setSignatureType("manuscrit");
        pedagogique.setSignatureInscription("Auzoux Doctr , fecit anno 1877");
        pedagogique.setStructure("démontable");
        pedagogique.setBuyingPrice("200");
        pedagogique.setBuyingPriceCommercial("");
        pedagogique.setDescriptif("non");
        pedagogique.setDimensions("");
        pedagogique.setNumberElements(0);
        pedagogique.setAdministrator("FGES");
        pedagogiqueService.delete(pedagogique);
    }
}
