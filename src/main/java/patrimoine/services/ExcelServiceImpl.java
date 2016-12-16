package patrimoine.services;

import jxl.Sheet;
import jxl.Workbook;
import java.io.IOException;
import java.io.File;

import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.models.Herbiers;
import patrimoine.models.Pedagogique;
import patrimoine.services.daoServices.HerbiersService;
import patrimoine.services.daoServices.InstrumentsService;
import patrimoine.services.daoServices.JardinBotaniqueService;
import patrimoine.services.daoServices.PedagogiqueService;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    private Workbook workbook = null;

    @Autowired
    HerbiersService herbiersService;
    @Autowired
    InstrumentsService instrumentsService;
    @Autowired
    JardinBotaniqueService jardinBotaniqueService;
    @Autowired
    PedagogiqueService pedagogiqueService;

    @Override
    public void loadFileExcelCollectionImport(String name) throws IOException, BiffException {
        String path = new File(".").getCanonicalPath()+"\\file";
        workbook = Workbook.getWorkbook(new java.io.File(path+"\\"+name));
    }

    @Override
    public void readFileExcelCollectionImport(String object) throws IOException,BiffException  {
        switch (object){
            case "Herbiers":
                readFileExcelHerbiers();
                break;
            case "Instruments":
                readFileExcelInstruments();
                break;
            case "Jardin Botanique":
                readFileExcelJardinBotanique();
                break;
            case "Materiel Pedagogique":
                readFileExcelMaterielPedagogique();
                break;
            case "Mineralogie Cristallographie":
                readFileExcelMineralogieCristallographie();
                break;
            case "Ouvrages Cartes Documents":
                readFileExcelOuvragesCartesDocuments();
                break;
            case "Paleontologie Animale":
                readFileExcelPaleontogieAnimale();
                break;
            case "Paleontologie Vegetale":
                readFileExcelPaleontogieVegetale();
                break;
            case "Pedagogique":
                readFileExcelPedagogique();
                break;
            case "Petrographie":
                readFileExcelPetrographie();
                break;
            case "Physique":
                readFileExcelPhysique();
                break;
            case "Typotheque":
                readFileExcelTypotheque();
                break;
            case "Zoologie Invertebres Autres":
                readFileExcelZoologieInvertebresAutres();
                break;
            case "Zoologie Invertebres Insectes":
                readFileExcelZoologieInvertebresInsectes();
                break;
            case "Zoologie Invertebres Mollusques":
                readFileExcelZoologieInvertebresMollusque();
                break;
            case "Zoologie Vertebres Autres":
                readFileExcelZoologieVertebresAutres();
                break;
            case "Zoologie Vertebres Mammiferes":
                readFileExcelZoologieVertebresMammiferes();
                break;
            case "Zoologie Vertebres Oiseaux":
                readFileExcelZoologieVertebresOiseaux();
                break;
            case "Zoologie Vertebres Poissons":
                readFileExcelZoologieVertebresPoissons();
                break;
            case "Zoologie Vertebres Primates":
                readFileExcelZoologieVertebresPrimates();
                break;
            case "Zoologie Vertebres Reptile":
                readFileExcelZoologieVertebresReptile();
                break;
            default:
                break;
        }
    }

    @Override
    public void readFileExcelHerbiers() throws IOException, BiffException {
        /* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Herbiers herbier = new Herbiers();
            herbier.setId(sheet.getCell(0,i).getContents());
            herbier.setPicture(sheet.getCell(1,i).getContents());
            herbier.setName(sheet.getCell(2,i).getContents());
            herbier.setGroupe(sheet.getCell(3,i).getContents());
            herbier.setKind(sheet.getCell(4,i).getContents());
            herbier.setEspece(sheet.getCell(5,i).getContents());
            herbier.setAuthor(sheet.getCell(6,i).getContents());
            herbier.setYear(sheet.getCell(7,i).getContents());
            herbier.setCountry(sheet.getCell(8,i).getContents());
            herbier.setCity(sheet.getCell(9,i).getContents());
            herbier.setPlace(sheet.getCell(10,i).getContents());
            herbier.setNameCollection(sheet.getCell(11,i).getContents());
            herbier.setManifold(sheet.getCell(12,i).getContents());
            herbier.setLocalization(sheet.getCell(13,i).getContents());
            herbier.setAnnexe1(sheet.getCell(14,i).getContents());
            herbier.setAnnexe2(sheet.getCell(15,i).getContents());
            herbier.setAnnexe3(sheet.getCell(16,i).getContents());
            herbier.setAnnexe4(sheet.getCell(17,i).getContents());
            herbier.setAnnexe5(sheet.getCell(18,i).getContents());
            herbier.setAnnexe6(sheet.getCell(19,i).getContents());
            herbier.setAnnexe7(sheet.getCell(20,i).getContents());
            herbier.setAnnexe8(sheet.getCell(21,i).getContents());
            herbier.setAnnexe9(sheet.getCell(22,i).getContents());
            herbier.setAnnexe10(sheet.getCell(23,i).getContents());
            herbier.setAnnexe11(sheet.getCell(24,i).getContents());
            herbier.setAnnexe12(sheet.getCell(25,i).getContents());
            herbier.setAnnexe13(sheet.getCell(26,i).getContents());
            herbier.setAnnexe14(sheet.getCell(27,i).getContents());
            herbier.setAnnexe15(sheet.getCell(28,i).getContents());
            herbier.setAnnexe16(sheet.getCell(29,i).getContents());
            herbier.setAnnexe17(sheet.getCell(30,i).getContents());
            herbier.setAnnexe18(sheet.getCell(31,i).getContents());
            herbier.setAnnexe19(sheet.getCell(32,i).getContents());
            herbier.setAnnexe20(sheet.getCell(33,i).getContents());
            herbier.setAnnexe21(sheet.getCell(34,i).getContents());
            herbier.setAnnexe22(sheet.getCell(35,i).getContents());
            herbier.setAnnexe23(sheet.getCell(36,i).getContents());
            herbier.setAnnexe24(sheet.getCell(37,i).getContents());
            herbier.setAnnexe25(sheet.getCell(38,i).getContents());
            herbier.setAnnexe26(sheet.getCell(39,i).getContents());
            herbier.setAnnexe27(sheet.getCell(40,i).getContents());
            herbier.setAnnexe28(sheet.getCell(41,i).getContents());
            herbier.setAnnexe29(sheet.getCell(42,i).getContents());
            herbier.setAnnexe30(sheet.getCell(43,i).getContents());
            herbier.setAnnexe31(sheet.getCell(44,i).getContents());
            herbier.setAnnexe32(sheet.getCell(45,i).getContents());
            herbier.setAnnexe33(sheet.getCell(46,i).getContents());
            herbier.setAnnexe34(sheet.getCell(47,i).getContents());
            herbier.setAnnexe35(sheet.getCell(48,i).getContents());
            herbier.setAnnexe36(sheet.getCell(49,i).getContents());
            herbier.setAnnexe37(sheet.getCell(50,i).getContents());
            herbier.setAnnexe38(sheet.getCell(51,i).getContents());
            herbier.setAnnexe39(sheet.getCell(52,i).getContents());
            herbier.setAnnexe40(sheet.getCell(53,i).getContents());
            herbiersService.save(herbier);
        }
    }

    @Override
    public void readFileExcelInstruments() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelJardinBotanique() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelMaterielPedagogique() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelMineralogieCristallographie() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelOuvragesCartesDocuments() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelPaleontogieAnimale() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelPaleontogieVegetale() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelPedagogique() throws IOException, BiffException {
        /* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Pedagogique pedagogique = new Pedagogique();
            pedagogique.setId(sheet.getCell(0,i).getContents());
            pedagogique.setPicture(sheet.getCell(1,i).getContents());
            pedagogique.setName(sheet.getCell(2,i).getContents());
            pedagogique.setGroupe(sheet.getCell(3,i).getContents());
            pedagogique.setKind(sheet.getCell(4,i).getContents());
            pedagogique.setEspece(sheet.getCell(5,i).getContents());
            pedagogique.setAuthor(sheet.getCell(6,i).getContents());
            pedagogique.setYear(sheet.getCell(7,i).getContents());
            pedagogique.setCountry(sheet.getCell(8,i).getContents());
            pedagogique.setCity(sheet.getCell(9,i).getContents());
            pedagogique.setPlace(sheet.getCell(10,i).getContents());
            pedagogique.setNameCollection(sheet.getCell(11,i).getContents());
            pedagogique.setManifold(sheet.getCell(12,i).getContents());
            pedagogique.setLocalization(sheet.getCell(13,i).getContents());
            pedagogique.setRetentionColor(sheet.getCell(14,i).getContents());
            pedagogique.setRetentionMechanism(sheet.getCell(15,i).getContents());
            pedagogique.setRetentionVarnish(sheet.getCell(16,i).getContents());
            pedagogique.setRetentionProperty(sheet.getCell(17,i).getContents());
            pedagogique.setStateModel(sheet.getCell(18,i).getContents());
            pedagogique.setType(sheet.getCell(19,i).getContents());
            pedagogique.setSignatureType(sheet.getCell(20,i).getContents());
            pedagogique.setSignatureInscription(sheet.getCell(21,i).getContents());
            pedagogique.setStructure(sheet.getCell(22,i).getContents());
            pedagogique.setBuyingPrice(sheet.getCell(23,i).getContents());
            pedagogique.setBuyingPriceCommercial(sheet.getCell(24,i).getContents());
            pedagogique.setDescriptif(sheet.getCell(25,i).getContents());
            pedagogique.setDimensions(sheet.getCell(26,i).getContents());
            pedagogique.setNumberElements(0);
            pedagogique.setAdministrator(sheet.getCell(28,i).getContents());
            pedagogiqueService.save(pedagogique);
        }
    }

    @Override
    public void readFileExcelPetrographie() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelPhysique() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelTypotheque() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieInvertebresAutres() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieInvertebresInsectes() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieInvertebresMollusque() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresAutres() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresMammiferes() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresOiseaux() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresPoissons() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresPrimates() throws IOException, BiffException {

    }

    @Override
    public void readFileExcelZoologieVertebresReptile() throws IOException, BiffException {

    }
}
