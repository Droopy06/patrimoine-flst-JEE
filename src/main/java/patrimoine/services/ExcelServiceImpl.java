package patrimoine.services;

import jxl.Sheet;
import jxl.Workbook;
import java.io.IOException;
import java.io.File;

import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.models.*;
import patrimoine.services.daoServices.*;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    private Workbook workbook = null;
    @Autowired
    private HerbiersService herbiersService;
    @Autowired
    private InstrumentsService instrumentsService;
    @Autowired
    private JardinBotaniqueService jardinBotaniqueService;
    @Autowired
    private MaterielPedagoiqueService materielPedagoiqueService;
    @Autowired
    private MineralogieCristallographiqueService mineralogieCristallographiqueService;
    @Autowired
    private OuvragesCartesDocumentsService ouvragesCartesDocumentsService;
    @Autowired
    private PaleontologieAnimaleService paleontologieAnimaleService;
    @Autowired
    private PaleontologieVegetaleService paleontologieVegetaleService;
    @Autowired
    private PedagogiqueService pedagogiqueService;
    @Autowired
    private PetrographieService petrographieService;
    @Autowired
    private PhysiqueService physiqueService;
    @Autowired
    private TypothequeService typothequeService;
    @Autowired
    private ZoologieInvertebresAutresService zoologieInvertebresAutresService;
    @Autowired
    private ZoologieInvertebresInsectesService zoologieInvertebresInsectesService;
    @Autowired
    private ZoologieInvertebresMollusquesService zoologieInvertebresMollusquesService;
    @Autowired
    private ZoologieVertebresAutresService zoologieVertebresAutresService;
    @Autowired
    private ZoologieVertebresMammiferesService zoologieVertebresMammiferesService;
    @Autowired
    private ZoologieVertebresOiseauxService zoologieVertebresOiseauxService;
    @Autowired
    private ZoologieVertebresPoissonsService zoologieVertebresPoissonsService;
    @Autowired
    private ZoologieVertebresPrimatesService zoologieVertebresPrimatesService;
    @Autowired
    private ZoologieVertebresReptileService zoologieVertebresReptileService;

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
                readFileExcelPaleontologieAnimale();
                break;
            case "Paleontologie Vegetale":
                readFileExcelPaleontologieVegetale();
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
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Instruments instruments = new Instruments();
            instruments.setId(sheet.getCell(0,i).getContents());
            instruments.setPicture(sheet.getCell(1,i).getContents());
            instruments.setName(sheet.getCell(2,i).getContents());
            instruments.setGroupe(sheet.getCell(3,i).getContents());
            instruments.setKind(sheet.getCell(4,i).getContents());
            instruments.setEspece(sheet.getCell(5,i).getContents());
            instruments.setAuthor(sheet.getCell(6,i).getContents());
            instruments.setYear(sheet.getCell(7,i).getContents());
            instruments.setCountry(sheet.getCell(8,i).getContents());
            instruments.setCity(sheet.getCell(9,i).getContents());
            instruments.setPlace(sheet.getCell(10,i).getContents());
            instruments.setNameCollection(sheet.getCell(11,i).getContents());
            instruments.setManifold(sheet.getCell(12,i).getContents());
            instruments.setLocalization(sheet.getCell(13,i).getContents());
            instruments.setAnnexe1(sheet.getCell(14,i).getContents());
            instruments.setAnnexe2(sheet.getCell(15,i).getContents());
            instruments.setAnnexe3(sheet.getCell(16,i).getContents());
            instruments.setAnnexe4(sheet.getCell(17,i).getContents());
            instruments.setAnnexe5(sheet.getCell(18,i).getContents());
            instruments.setAnnexe6(sheet.getCell(19,i).getContents());
            instruments.setAnnexe7(sheet.getCell(20,i).getContents());
            instruments.setAnnexe8(sheet.getCell(21,i).getContents());
            instruments.setAnnexe9(sheet.getCell(22,i).getContents());
            instruments.setAnnexe10(sheet.getCell(23,i).getContents());
            instruments.setAnnexe11(sheet.getCell(24,i).getContents());
            instruments.setAnnexe12(sheet.getCell(25,i).getContents());
            instruments.setAnnexe13(sheet.getCell(26,i).getContents());
            instruments.setAnnexe14(sheet.getCell(27,i).getContents());
            instruments.setAnnexe15(sheet.getCell(28,i).getContents());
            instruments.setAnnexe16(sheet.getCell(29,i).getContents());
            instruments.setAnnexe17(sheet.getCell(30,i).getContents());
            instruments.setAnnexe18(sheet.getCell(31,i).getContents());
            instruments.setAnnexe19(sheet.getCell(32,i).getContents());
            instruments.setAnnexe20(sheet.getCell(33,i).getContents());
            instruments.setAnnexe21(sheet.getCell(34,i).getContents());
            instruments.setAnnexe22(sheet.getCell(35,i).getContents());
            instruments.setAnnexe23(sheet.getCell(36,i).getContents());
            instruments.setAnnexe24(sheet.getCell(37,i).getContents());
            instruments.setAnnexe25(sheet.getCell(38,i).getContents());
            instruments.setAnnexe26(sheet.getCell(39,i).getContents());
            instruments.setAnnexe27(sheet.getCell(40,i).getContents());
            instruments.setAnnexe28(sheet.getCell(41,i).getContents());
            instruments.setAnnexe29(sheet.getCell(42,i).getContents());
            instruments.setAnnexe30(sheet.getCell(43,i).getContents());
            instruments.setAnnexe31(sheet.getCell(44,i).getContents());
            instruments.setAnnexe32(sheet.getCell(45,i).getContents());
            instruments.setAnnexe33(sheet.getCell(46,i).getContents());
            instruments.setAnnexe34(sheet.getCell(47,i).getContents());
            instruments.setAnnexe35(sheet.getCell(48,i).getContents());
            instruments.setAnnexe36(sheet.getCell(49,i).getContents());
            instruments.setAnnexe37(sheet.getCell(50,i).getContents());
            instruments.setAnnexe38(sheet.getCell(51,i).getContents());
            instruments.setAnnexe39(sheet.getCell(52,i).getContents());
            instruments.setAnnexe40(sheet.getCell(53,i).getContents());
            instrumentsService.save(instruments);
        }
    }

    @Override
    public void readFileExcelJardinBotanique() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            JardinBotanique jardinBotanique = new JardinBotanique();
            jardinBotanique.setId(sheet.getCell(0,i).getContents());
            jardinBotanique.setPicture(sheet.getCell(1,i).getContents());
            jardinBotanique.setName(sheet.getCell(2,i).getContents());
            jardinBotanique.setGroupe(sheet.getCell(3,i).getContents());
            jardinBotanique.setKind(sheet.getCell(4,i).getContents());
            jardinBotanique.setEspece(sheet.getCell(5,i).getContents());
            jardinBotanique.setAuthor(sheet.getCell(6,i).getContents());
            jardinBotanique.setYear(sheet.getCell(7,i).getContents());
            jardinBotanique.setCountry(sheet.getCell(8,i).getContents());
            jardinBotanique.setCity(sheet.getCell(9,i).getContents());
            jardinBotanique.setPlace(sheet.getCell(10,i).getContents());
            jardinBotanique.setNameCollection(sheet.getCell(11,i).getContents());
            jardinBotanique.setManifold(sheet.getCell(12,i).getContents());
            jardinBotanique.setLocalization(sheet.getCell(13,i).getContents());
            jardinBotanique.setAnnexe1(sheet.getCell(14,i).getContents());
            jardinBotanique.setAnnexe2(sheet.getCell(15,i).getContents());
            jardinBotanique.setAnnexe3(sheet.getCell(16,i).getContents());
            jardinBotanique.setAnnexe4(sheet.getCell(17,i).getContents());
            jardinBotanique.setAnnexe5(sheet.getCell(18,i).getContents());
            jardinBotanique.setAnnexe6(sheet.getCell(19,i).getContents());
            jardinBotanique.setAnnexe7(sheet.getCell(20,i).getContents());
            jardinBotanique.setAnnexe8(sheet.getCell(21,i).getContents());
            jardinBotanique.setAnnexe9(sheet.getCell(22,i).getContents());
            jardinBotanique.setAnnexe10(sheet.getCell(23,i).getContents());
            jardinBotanique.setAnnexe11(sheet.getCell(24,i).getContents());
            jardinBotanique.setAnnexe12(sheet.getCell(25,i).getContents());
            jardinBotanique.setAnnexe13(sheet.getCell(26,i).getContents());
            jardinBotanique.setAnnexe14(sheet.getCell(27,i).getContents());
            jardinBotanique.setAnnexe15(sheet.getCell(28,i).getContents());
            jardinBotanique.setAnnexe16(sheet.getCell(29,i).getContents());
            jardinBotanique.setAnnexe17(sheet.getCell(30,i).getContents());
            jardinBotanique.setAnnexe18(sheet.getCell(31,i).getContents());
            jardinBotanique.setAnnexe19(sheet.getCell(32,i).getContents());
            jardinBotanique.setAnnexe20(sheet.getCell(33,i).getContents());
            jardinBotanique.setAnnexe21(sheet.getCell(34,i).getContents());
            jardinBotanique.setAnnexe22(sheet.getCell(35,i).getContents());
            jardinBotanique.setAnnexe23(sheet.getCell(36,i).getContents());
            jardinBotanique.setAnnexe24(sheet.getCell(37,i).getContents());
            jardinBotanique.setAnnexe25(sheet.getCell(38,i).getContents());
            jardinBotanique.setAnnexe26(sheet.getCell(39,i).getContents());
            jardinBotanique.setAnnexe27(sheet.getCell(40,i).getContents());
            jardinBotanique.setAnnexe28(sheet.getCell(41,i).getContents());
            jardinBotanique.setAnnexe29(sheet.getCell(42,i).getContents());
            jardinBotanique.setAnnexe30(sheet.getCell(43,i).getContents());
            jardinBotanique.setAnnexe31(sheet.getCell(44,i).getContents());
            jardinBotanique.setAnnexe32(sheet.getCell(45,i).getContents());
            jardinBotanique.setAnnexe33(sheet.getCell(46,i).getContents());
            jardinBotanique.setAnnexe34(sheet.getCell(47,i).getContents());
            jardinBotanique.setAnnexe35(sheet.getCell(48,i).getContents());
            jardinBotanique.setAnnexe36(sheet.getCell(49,i).getContents());
            jardinBotanique.setAnnexe37(sheet.getCell(50,i).getContents());
            jardinBotanique.setAnnexe38(sheet.getCell(51,i).getContents());
            jardinBotanique.setAnnexe39(sheet.getCell(52,i).getContents());
            jardinBotanique.setAnnexe40(sheet.getCell(53,i).getContents());
            jardinBotaniqueService.save(jardinBotanique);
        }
    }

    @Override
    public void readFileExcelMaterielPedagogique() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            MaterielPedagogique materielPedagogique = new MaterielPedagogique();
            materielPedagogique.setId(sheet.getCell(0,i).getContents());
            materielPedagogique.setPicture(sheet.getCell(1,i).getContents());
            materielPedagogique.setName(sheet.getCell(2,i).getContents());
            materielPedagogique.setGroupe(sheet.getCell(3,i).getContents());
            materielPedagogique.setKind(sheet.getCell(4,i).getContents());
            materielPedagogique.setEspece(sheet.getCell(5,i).getContents());
            materielPedagogique.setAuthor(sheet.getCell(6,i).getContents());
            materielPedagogique.setYear(sheet.getCell(7,i).getContents());
            materielPedagogique.setCountry(sheet.getCell(8,i).getContents());
            materielPedagogique.setCity(sheet.getCell(9,i).getContents());
            materielPedagogique.setPlace(sheet.getCell(10,i).getContents());
            materielPedagogique.setNameCollection(sheet.getCell(11,i).getContents());
            materielPedagogique.setManifold(sheet.getCell(12,i).getContents());
            materielPedagogique.setLocalization(sheet.getCell(13,i).getContents());
            materielPedagogique.setAnnexe1(sheet.getCell(14,i).getContents());
            materielPedagogique.setAnnexe2(sheet.getCell(15,i).getContents());
            materielPedagogique.setAnnexe3(sheet.getCell(16,i).getContents());
            materielPedagogique.setAnnexe4(sheet.getCell(17,i).getContents());
            materielPedagogique.setAnnexe5(sheet.getCell(18,i).getContents());
            materielPedagogique.setAnnexe6(sheet.getCell(19,i).getContents());
            materielPedagogique.setAnnexe7(sheet.getCell(20,i).getContents());
            materielPedagogique.setAnnexe8(sheet.getCell(21,i).getContents());
            materielPedagogique.setAnnexe9(sheet.getCell(22,i).getContents());
            materielPedagogique.setAnnexe10(sheet.getCell(23,i).getContents());
            materielPedagogique.setAnnexe11(sheet.getCell(24,i).getContents());
            materielPedagogique.setAnnexe12(sheet.getCell(25,i).getContents());
            materielPedagogique.setAnnexe13(sheet.getCell(26,i).getContents());
            materielPedagogique.setAnnexe14(sheet.getCell(27,i).getContents());
            materielPedagogique.setAnnexe15(sheet.getCell(28,i).getContents());
            materielPedagogique.setAnnexe16(sheet.getCell(29,i).getContents());
            materielPedagogique.setAnnexe17(sheet.getCell(30,i).getContents());
            materielPedagogique.setAnnexe18(sheet.getCell(31,i).getContents());
            materielPedagogique.setAnnexe19(sheet.getCell(32,i).getContents());
            materielPedagogique.setAnnexe20(sheet.getCell(33,i).getContents());
            materielPedagogique.setAnnexe21(sheet.getCell(34,i).getContents());
            materielPedagogique.setAnnexe22(sheet.getCell(35,i).getContents());
            materielPedagogique.setAnnexe23(sheet.getCell(36,i).getContents());
            materielPedagogique.setAnnexe24(sheet.getCell(37,i).getContents());
            materielPedagogique.setAnnexe25(sheet.getCell(38,i).getContents());
            materielPedagogique.setAnnexe26(sheet.getCell(39,i).getContents());
            materielPedagogique.setAnnexe27(sheet.getCell(40,i).getContents());
            materielPedagogique.setAnnexe28(sheet.getCell(41,i).getContents());
            materielPedagogique.setAnnexe29(sheet.getCell(42,i).getContents());
            materielPedagogique.setAnnexe30(sheet.getCell(43,i).getContents());
            materielPedagogique.setAnnexe31(sheet.getCell(44,i).getContents());
            materielPedagogique.setAnnexe32(sheet.getCell(45,i).getContents());
            materielPedagogique.setAnnexe33(sheet.getCell(46,i).getContents());
            materielPedagogique.setAnnexe34(sheet.getCell(47,i).getContents());
            materielPedagogique.setAnnexe35(sheet.getCell(48,i).getContents());
            materielPedagogique.setAnnexe36(sheet.getCell(49,i).getContents());
            materielPedagogique.setAnnexe37(sheet.getCell(50,i).getContents());
            materielPedagogique.setAnnexe38(sheet.getCell(51,i).getContents());
            materielPedagogique.setAnnexe39(sheet.getCell(52,i).getContents());
            materielPedagogique.setAnnexe40(sheet.getCell(53,i).getContents());
            materielPedagoiqueService.save(materielPedagogique);
        }
    }

    @Override
    public void readFileExcelMineralogieCristallographie() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            MineralogieCristallographie mineralogieCristallographie = new MineralogieCristallographie();
            mineralogieCristallographie.setId(sheet.getCell(0,i).getContents());
            mineralogieCristallographie.setPicture(sheet.getCell(1,i).getContents());
            mineralogieCristallographie.setName(sheet.getCell(2,i).getContents());
            mineralogieCristallographie.setGroupe(sheet.getCell(3,i).getContents());
            mineralogieCristallographie.setKind(sheet.getCell(4,i).getContents());
            mineralogieCristallographie.setEspece(sheet.getCell(5,i).getContents());
            mineralogieCristallographie.setAuthor(sheet.getCell(6,i).getContents());
            mineralogieCristallographie.setYear(sheet.getCell(7,i).getContents());
            mineralogieCristallographie.setCountry(sheet.getCell(8,i).getContents());
            mineralogieCristallographie.setCity(sheet.getCell(9,i).getContents());
            mineralogieCristallographie.setPlace(sheet.getCell(10,i).getContents());
            mineralogieCristallographie.setNameCollection(sheet.getCell(11,i).getContents());
            mineralogieCristallographie.setManifold(sheet.getCell(12,i).getContents());
            mineralogieCristallographie.setLocalization(sheet.getCell(13,i).getContents());
            mineralogieCristallographie.setAnnexe1(sheet.getCell(14,i).getContents());
            mineralogieCristallographie.setAnnexe2(sheet.getCell(15,i).getContents());
            mineralogieCristallographie.setAnnexe3(sheet.getCell(16,i).getContents());
            mineralogieCristallographie.setAnnexe4(sheet.getCell(17,i).getContents());
            mineralogieCristallographie.setAnnexe5(sheet.getCell(18,i).getContents());
            mineralogieCristallographie.setAnnexe6(sheet.getCell(19,i).getContents());
            mineralogieCristallographie.setAnnexe7(sheet.getCell(20,i).getContents());
            mineralogieCristallographie.setAnnexe8(sheet.getCell(21,i).getContents());
            mineralogieCristallographie.setAnnexe9(sheet.getCell(22,i).getContents());
            mineralogieCristallographie.setAnnexe10(sheet.getCell(23,i).getContents());
            mineralogieCristallographie.setAnnexe11(sheet.getCell(24,i).getContents());
            mineralogieCristallographie.setAnnexe12(sheet.getCell(25,i).getContents());
            mineralogieCristallographie.setAnnexe13(sheet.getCell(26,i).getContents());
            mineralogieCristallographie.setAnnexe14(sheet.getCell(27,i).getContents());
            mineralogieCristallographie.setAnnexe15(sheet.getCell(28,i).getContents());
            mineralogieCristallographie.setAnnexe16(sheet.getCell(29,i).getContents());
            mineralogieCristallographie.setAnnexe17(sheet.getCell(30,i).getContents());
            mineralogieCristallographie.setAnnexe18(sheet.getCell(31,i).getContents());
            mineralogieCristallographie.setAnnexe19(sheet.getCell(32,i).getContents());
            mineralogieCristallographie.setAnnexe20(sheet.getCell(33,i).getContents());
            mineralogieCristallographie.setAnnexe21(sheet.getCell(34,i).getContents());
            mineralogieCristallographie.setAnnexe22(sheet.getCell(35,i).getContents());
            mineralogieCristallographie.setAnnexe23(sheet.getCell(36,i).getContents());
            mineralogieCristallographie.setAnnexe24(sheet.getCell(37,i).getContents());
            mineralogieCristallographie.setAnnexe25(sheet.getCell(38,i).getContents());
            mineralogieCristallographie.setAnnexe26(sheet.getCell(39,i).getContents());
            mineralogieCristallographie.setAnnexe27(sheet.getCell(40,i).getContents());
            mineralogieCristallographie.setAnnexe28(sheet.getCell(41,i).getContents());
            mineralogieCristallographie.setAnnexe29(sheet.getCell(42,i).getContents());
            mineralogieCristallographie.setAnnexe30(sheet.getCell(43,i).getContents());
            mineralogieCristallographie.setAnnexe31(sheet.getCell(44,i).getContents());
            mineralogieCristallographie.setAnnexe32(sheet.getCell(45,i).getContents());
            mineralogieCristallographie.setAnnexe33(sheet.getCell(46,i).getContents());
            mineralogieCristallographie.setAnnexe34(sheet.getCell(47,i).getContents());
            mineralogieCristallographie.setAnnexe35(sheet.getCell(48,i).getContents());
            mineralogieCristallographie.setAnnexe36(sheet.getCell(49,i).getContents());
            mineralogieCristallographie.setAnnexe37(sheet.getCell(50,i).getContents());
            mineralogieCristallographie.setAnnexe38(sheet.getCell(51,i).getContents());
            mineralogieCristallographie.setAnnexe39(sheet.getCell(52,i).getContents());
            mineralogieCristallographie.setAnnexe40(sheet.getCell(53,i).getContents());
            mineralogieCristallographiqueService.save(mineralogieCristallographie);
        }
    }

    @Override
    public void readFileExcelOuvragesCartesDocuments() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            OuvragesCartesDocuments ouvragesCartesDocuments = new OuvragesCartesDocuments();
            ouvragesCartesDocuments.setId(sheet.getCell(0,i).getContents());
            ouvragesCartesDocuments.setPicture(sheet.getCell(1,i).getContents());
            ouvragesCartesDocuments.setName(sheet.getCell(2,i).getContents());
            ouvragesCartesDocuments.setGroupe(sheet.getCell(3,i).getContents());
            ouvragesCartesDocuments.setKind(sheet.getCell(4,i).getContents());
            ouvragesCartesDocuments.setEspece(sheet.getCell(5,i).getContents());
            ouvragesCartesDocuments.setAuthor(sheet.getCell(6,i).getContents());
            ouvragesCartesDocuments.setYear(sheet.getCell(7,i).getContents());
            ouvragesCartesDocuments.setCountry(sheet.getCell(8,i).getContents());
            ouvragesCartesDocuments.setCity(sheet.getCell(9,i).getContents());
            ouvragesCartesDocuments.setPlace(sheet.getCell(10,i).getContents());
            ouvragesCartesDocuments.setNameCollection(sheet.getCell(11,i).getContents());
            ouvragesCartesDocuments.setManifold(sheet.getCell(12,i).getContents());
            ouvragesCartesDocuments.setLocalization(sheet.getCell(13,i).getContents());
            ouvragesCartesDocuments.setAnnexe1(sheet.getCell(14,i).getContents());
            ouvragesCartesDocuments.setAnnexe2(sheet.getCell(15,i).getContents());
            ouvragesCartesDocuments.setAnnexe3(sheet.getCell(16,i).getContents());
            ouvragesCartesDocuments.setAnnexe4(sheet.getCell(17,i).getContents());
            ouvragesCartesDocuments.setAnnexe5(sheet.getCell(18,i).getContents());
            ouvragesCartesDocuments.setAnnexe6(sheet.getCell(19,i).getContents());
            ouvragesCartesDocuments.setAnnexe7(sheet.getCell(20,i).getContents());
            ouvragesCartesDocuments.setAnnexe8(sheet.getCell(21,i).getContents());
            ouvragesCartesDocuments.setAnnexe9(sheet.getCell(22,i).getContents());
            ouvragesCartesDocuments.setAnnexe10(sheet.getCell(23,i).getContents());
            ouvragesCartesDocuments.setAnnexe11(sheet.getCell(24,i).getContents());
            ouvragesCartesDocuments.setAnnexe12(sheet.getCell(25,i).getContents());
            ouvragesCartesDocuments.setAnnexe13(sheet.getCell(26,i).getContents());
            ouvragesCartesDocuments.setAnnexe14(sheet.getCell(27,i).getContents());
            ouvragesCartesDocuments.setAnnexe15(sheet.getCell(28,i).getContents());
            ouvragesCartesDocuments.setAnnexe16(sheet.getCell(29,i).getContents());
            ouvragesCartesDocuments.setAnnexe17(sheet.getCell(30,i).getContents());
            ouvragesCartesDocuments.setAnnexe18(sheet.getCell(31,i).getContents());
            ouvragesCartesDocuments.setAnnexe19(sheet.getCell(32,i).getContents());
            ouvragesCartesDocuments.setAnnexe20(sheet.getCell(33,i).getContents());
            ouvragesCartesDocuments.setAnnexe21(sheet.getCell(34,i).getContents());
            ouvragesCartesDocuments.setAnnexe22(sheet.getCell(35,i).getContents());
            ouvragesCartesDocuments.setAnnexe23(sheet.getCell(36,i).getContents());
            ouvragesCartesDocuments.setAnnexe24(sheet.getCell(37,i).getContents());
            ouvragesCartesDocuments.setAnnexe25(sheet.getCell(38,i).getContents());
            ouvragesCartesDocuments.setAnnexe26(sheet.getCell(39,i).getContents());
            ouvragesCartesDocuments.setAnnexe27(sheet.getCell(40,i).getContents());
            ouvragesCartesDocuments.setAnnexe28(sheet.getCell(41,i).getContents());
            ouvragesCartesDocuments.setAnnexe29(sheet.getCell(42,i).getContents());
            ouvragesCartesDocuments.setAnnexe30(sheet.getCell(43,i).getContents());
            ouvragesCartesDocuments.setAnnexe31(sheet.getCell(44,i).getContents());
            ouvragesCartesDocuments.setAnnexe32(sheet.getCell(45,i).getContents());
            ouvragesCartesDocuments.setAnnexe33(sheet.getCell(46,i).getContents());
            ouvragesCartesDocuments.setAnnexe34(sheet.getCell(47,i).getContents());
            ouvragesCartesDocuments.setAnnexe35(sheet.getCell(48,i).getContents());
            ouvragesCartesDocuments.setAnnexe36(sheet.getCell(49,i).getContents());
            ouvragesCartesDocuments.setAnnexe37(sheet.getCell(50,i).getContents());
            ouvragesCartesDocuments.setAnnexe38(sheet.getCell(51,i).getContents());
            ouvragesCartesDocuments.setAnnexe39(sheet.getCell(52,i).getContents());
            ouvragesCartesDocuments.setAnnexe40(sheet.getCell(53,i).getContents());
            ouvragesCartesDocumentsService.save(ouvragesCartesDocuments);
        }
    }

    @Override
    public void readFileExcelPaleontologieAnimale() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            PaleontologieAnimale paleontogieAnimale = new PaleontologieAnimale();
            paleontogieAnimale.setId(sheet.getCell(0,i).getContents());
            paleontogieAnimale.setPicture(sheet.getCell(1,i).getContents());
            paleontogieAnimale.setName(sheet.getCell(2,i).getContents());
            paleontogieAnimale.setGroupe(sheet.getCell(3,i).getContents());
            paleontogieAnimale.setKind(sheet.getCell(4,i).getContents());
            paleontogieAnimale.setEspece(sheet.getCell(5,i).getContents());
            paleontogieAnimale.setAuthor(sheet.getCell(6,i).getContents());
            paleontogieAnimale.setYear(sheet.getCell(7,i).getContents());
            paleontogieAnimale.setCountry(sheet.getCell(8,i).getContents());
            paleontogieAnimale.setCity(sheet.getCell(9,i).getContents());
            paleontogieAnimale.setPlace(sheet.getCell(10,i).getContents());
            paleontogieAnimale.setNameCollection(sheet.getCell(11,i).getContents());
            paleontogieAnimale.setManifold(sheet.getCell(12,i).getContents());
            paleontogieAnimale.setLocalization(sheet.getCell(13,i).getContents());
            paleontogieAnimale.setAnnexe1(sheet.getCell(14,i).getContents());
            paleontogieAnimale.setAnnexe2(sheet.getCell(15,i).getContents());
            paleontogieAnimale.setAnnexe3(sheet.getCell(16,i).getContents());
            paleontogieAnimale.setAnnexe4(sheet.getCell(17,i).getContents());
            paleontogieAnimale.setAnnexe5(sheet.getCell(18,i).getContents());
            paleontogieAnimale.setAnnexe6(sheet.getCell(19,i).getContents());
            paleontogieAnimale.setAnnexe7(sheet.getCell(20,i).getContents());
            paleontogieAnimale.setAnnexe8(sheet.getCell(21,i).getContents());
            paleontogieAnimale.setAnnexe9(sheet.getCell(22,i).getContents());
            paleontogieAnimale.setAnnexe10(sheet.getCell(23,i).getContents());
            paleontogieAnimale.setAnnexe11(sheet.getCell(24,i).getContents());
            paleontogieAnimale.setAnnexe12(sheet.getCell(25,i).getContents());
            paleontogieAnimale.setAnnexe13(sheet.getCell(26,i).getContents());
            paleontogieAnimale.setAnnexe14(sheet.getCell(27,i).getContents());
            paleontogieAnimale.setAnnexe15(sheet.getCell(28,i).getContents());
            paleontogieAnimale.setAnnexe16(sheet.getCell(29,i).getContents());
            paleontogieAnimale.setAnnexe17(sheet.getCell(30,i).getContents());
            paleontogieAnimale.setAnnexe18(sheet.getCell(31,i).getContents());
            paleontogieAnimale.setAnnexe19(sheet.getCell(32,i).getContents());
            paleontogieAnimale.setAnnexe20(sheet.getCell(33,i).getContents());
            paleontogieAnimale.setAnnexe21(sheet.getCell(34,i).getContents());
            paleontogieAnimale.setAnnexe22(sheet.getCell(35,i).getContents());
            paleontogieAnimale.setAnnexe23(sheet.getCell(36,i).getContents());
            paleontogieAnimale.setAnnexe24(sheet.getCell(37,i).getContents());
            paleontogieAnimale.setAnnexe25(sheet.getCell(38,i).getContents());
            paleontogieAnimale.setAnnexe26(sheet.getCell(39,i).getContents());
            paleontogieAnimale.setAnnexe27(sheet.getCell(40,i).getContents());
            paleontogieAnimale.setAnnexe28(sheet.getCell(41,i).getContents());
            paleontogieAnimale.setAnnexe29(sheet.getCell(42,i).getContents());
            paleontogieAnimale.setAnnexe30(sheet.getCell(43,i).getContents());
            paleontogieAnimale.setAnnexe31(sheet.getCell(44,i).getContents());
            paleontogieAnimale.setAnnexe32(sheet.getCell(45,i).getContents());
            paleontogieAnimale.setAnnexe33(sheet.getCell(46,i).getContents());
            paleontogieAnimale.setAnnexe34(sheet.getCell(47,i).getContents());
            paleontogieAnimale.setAnnexe35(sheet.getCell(48,i).getContents());
            paleontogieAnimale.setAnnexe36(sheet.getCell(49,i).getContents());
            paleontogieAnimale.setAnnexe37(sheet.getCell(50,i).getContents());
            paleontogieAnimale.setAnnexe38(sheet.getCell(51,i).getContents());
            paleontogieAnimale.setAnnexe39(sheet.getCell(52,i).getContents());
            paleontogieAnimale.setAnnexe40(sheet.getCell(53,i).getContents());
            paleontologieAnimaleService.save(paleontogieAnimale);
        }
    }

    @Override
    public void readFileExcelPaleontologieVegetale() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            PaleontologieVegetale paleontologieVegetale = new PaleontologieVegetale();
            paleontologieVegetale.setId(sheet.getCell(0,i).getContents());
            paleontologieVegetale.setPicture(sheet.getCell(1,i).getContents());
            paleontologieVegetale.setName(sheet.getCell(2,i).getContents());
            paleontologieVegetale.setGroupe(sheet.getCell(3,i).getContents());
            paleontologieVegetale.setKind(sheet.getCell(4,i).getContents());
            paleontologieVegetale.setEspece(sheet.getCell(5,i).getContents());
            paleontologieVegetale.setAuthor(sheet.getCell(6,i).getContents());
            paleontologieVegetale.setYear(sheet.getCell(7,i).getContents());
            paleontologieVegetale.setCountry(sheet.getCell(8,i).getContents());
            paleontologieVegetale.setCity(sheet.getCell(9,i).getContents());
            paleontologieVegetale.setPlace(sheet.getCell(10,i).getContents());
            paleontologieVegetale.setNameCollection(sheet.getCell(11,i).getContents());
            paleontologieVegetale.setManifold(sheet.getCell(12,i).getContents());
            paleontologieVegetale.setLocalization(sheet.getCell(13,i).getContents());
            paleontologieVegetale.setAnnexe1(sheet.getCell(14,i).getContents());
            paleontologieVegetale.setAnnexe2(sheet.getCell(15,i).getContents());
            paleontologieVegetale.setAnnexe3(sheet.getCell(16,i).getContents());
            paleontologieVegetale.setAnnexe4(sheet.getCell(17,i).getContents());
            paleontologieVegetale.setAnnexe5(sheet.getCell(18,i).getContents());
            paleontologieVegetale.setAnnexe6(sheet.getCell(19,i).getContents());
            paleontologieVegetale.setAnnexe7(sheet.getCell(20,i).getContents());
            paleontologieVegetale.setAnnexe8(sheet.getCell(21,i).getContents());
            paleontologieVegetale.setAnnexe9(sheet.getCell(22,i).getContents());
            paleontologieVegetale.setAnnexe10(sheet.getCell(23,i).getContents());
            paleontologieVegetale.setAnnexe11(sheet.getCell(24,i).getContents());
            paleontologieVegetale.setAnnexe12(sheet.getCell(25,i).getContents());
            paleontologieVegetale.setAnnexe13(sheet.getCell(26,i).getContents());
            paleontologieVegetale.setAnnexe14(sheet.getCell(27,i).getContents());
            paleontologieVegetale.setAnnexe15(sheet.getCell(28,i).getContents());
            paleontologieVegetale.setAnnexe16(sheet.getCell(29,i).getContents());
            paleontologieVegetale.setAnnexe17(sheet.getCell(30,i).getContents());
            paleontologieVegetale.setAnnexe18(sheet.getCell(31,i).getContents());
            paleontologieVegetale.setAnnexe19(sheet.getCell(32,i).getContents());
            paleontologieVegetale.setAnnexe20(sheet.getCell(33,i).getContents());
            paleontologieVegetale.setAnnexe21(sheet.getCell(34,i).getContents());
            paleontologieVegetale.setAnnexe22(sheet.getCell(35,i).getContents());
            paleontologieVegetale.setAnnexe23(sheet.getCell(36,i).getContents());
            paleontologieVegetale.setAnnexe24(sheet.getCell(37,i).getContents());
            paleontologieVegetale.setAnnexe25(sheet.getCell(38,i).getContents());
            paleontologieVegetale.setAnnexe26(sheet.getCell(39,i).getContents());
            paleontologieVegetale.setAnnexe27(sheet.getCell(40,i).getContents());
            paleontologieVegetale.setAnnexe28(sheet.getCell(41,i).getContents());
            paleontologieVegetale.setAnnexe29(sheet.getCell(42,i).getContents());
            paleontologieVegetale.setAnnexe30(sheet.getCell(43,i).getContents());
            paleontologieVegetale.setAnnexe31(sheet.getCell(44,i).getContents());
            paleontologieVegetale.setAnnexe32(sheet.getCell(45,i).getContents());
            paleontologieVegetale.setAnnexe33(sheet.getCell(46,i).getContents());
            paleontologieVegetale.setAnnexe34(sheet.getCell(47,i).getContents());
            paleontologieVegetale.setAnnexe35(sheet.getCell(48,i).getContents());
            paleontologieVegetale.setAnnexe36(sheet.getCell(49,i).getContents());
            paleontologieVegetale.setAnnexe37(sheet.getCell(50,i).getContents());
            paleontologieVegetale.setAnnexe38(sheet.getCell(51,i).getContents());
            paleontologieVegetale.setAnnexe39(sheet.getCell(52,i).getContents());
            paleontologieVegetale.setAnnexe40(sheet.getCell(53,i).getContents());
            paleontologieVegetaleService.save(paleontologieVegetale);
        }
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
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Petrographie petrographie = new Petrographie();
            petrographie.setId(sheet.getCell(0,i).getContents());
            petrographie.setPicture(sheet.getCell(1,i).getContents());
            petrographie.setName(sheet.getCell(2,i).getContents());
            petrographie.setGroupe(sheet.getCell(3,i).getContents());
            petrographie.setKind(sheet.getCell(4,i).getContents());
            petrographie.setEspece(sheet.getCell(5,i).getContents());
            petrographie.setAuthor(sheet.getCell(6,i).getContents());
            petrographie.setYear(sheet.getCell(7,i).getContents());
            petrographie.setCountry(sheet.getCell(8,i).getContents());
            petrographie.setCity(sheet.getCell(9,i).getContents());
            petrographie.setPlace(sheet.getCell(10,i).getContents());
            petrographie.setNameCollection(sheet.getCell(11,i).getContents());
            petrographie.setManifold(sheet.getCell(12,i).getContents());
            petrographie.setLocalization(sheet.getCell(13,i).getContents());
            petrographie.setAnnexe1(sheet.getCell(14,i).getContents());
            petrographie.setAnnexe2(sheet.getCell(15,i).getContents());
            petrographie.setAnnexe3(sheet.getCell(16,i).getContents());
            petrographie.setAnnexe4(sheet.getCell(17,i).getContents());
            petrographie.setAnnexe5(sheet.getCell(18,i).getContents());
            petrographie.setAnnexe6(sheet.getCell(19,i).getContents());
            petrographie.setAnnexe7(sheet.getCell(20,i).getContents());
            petrographie.setAnnexe8(sheet.getCell(21,i).getContents());
            petrographie.setAnnexe9(sheet.getCell(22,i).getContents());
            petrographie.setAnnexe10(sheet.getCell(23,i).getContents());
            petrographie.setAnnexe11(sheet.getCell(24,i).getContents());
            petrographie.setAnnexe12(sheet.getCell(25,i).getContents());
            petrographie.setAnnexe13(sheet.getCell(26,i).getContents());
            petrographie.setAnnexe14(sheet.getCell(27,i).getContents());
            petrographie.setAnnexe15(sheet.getCell(28,i).getContents());
            petrographie.setAnnexe16(sheet.getCell(29,i).getContents());
            petrographie.setAnnexe17(sheet.getCell(30,i).getContents());
            petrographie.setAnnexe18(sheet.getCell(31,i).getContents());
            petrographie.setAnnexe19(sheet.getCell(32,i).getContents());
            petrographie.setAnnexe20(sheet.getCell(33,i).getContents());
            petrographie.setAnnexe21(sheet.getCell(34,i).getContents());
            petrographie.setAnnexe22(sheet.getCell(35,i).getContents());
            petrographie.setAnnexe23(sheet.getCell(36,i).getContents());
            petrographie.setAnnexe24(sheet.getCell(37,i).getContents());
            petrographie.setAnnexe25(sheet.getCell(38,i).getContents());
            petrographie.setAnnexe26(sheet.getCell(39,i).getContents());
            petrographie.setAnnexe27(sheet.getCell(40,i).getContents());
            petrographie.setAnnexe28(sheet.getCell(41,i).getContents());
            petrographie.setAnnexe29(sheet.getCell(42,i).getContents());
            petrographie.setAnnexe30(sheet.getCell(43,i).getContents());
            petrographie.setAnnexe31(sheet.getCell(44,i).getContents());
            petrographie.setAnnexe32(sheet.getCell(45,i).getContents());
            petrographie.setAnnexe33(sheet.getCell(46,i).getContents());
            petrographie.setAnnexe34(sheet.getCell(47,i).getContents());
            petrographie.setAnnexe35(sheet.getCell(48,i).getContents());
            petrographie.setAnnexe36(sheet.getCell(49,i).getContents());
            petrographie.setAnnexe37(sheet.getCell(50,i).getContents());
            petrographie.setAnnexe38(sheet.getCell(51,i).getContents());
            petrographie.setAnnexe39(sheet.getCell(52,i).getContents());
            petrographie.setAnnexe40(sheet.getCell(53,i).getContents());
            petrographieService.save(petrographie);
        }
    }

    @Override
    public void readFileExcelPhysique() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Physique physique = new Physique();
            physique.setId(sheet.getCell(0,i).getContents());
            physique.setPicture(sheet.getCell(1,i).getContents());
            physique.setName(sheet.getCell(2,i).getContents());
            physique.setGroupe(sheet.getCell(3,i).getContents());
            physique.setKind(sheet.getCell(4,i).getContents());
            physique.setEspece(sheet.getCell(5,i).getContents());
            physique.setAuthor(sheet.getCell(6,i).getContents());
            physique.setYear(sheet.getCell(7,i).getContents());
            physique.setCountry(sheet.getCell(8,i).getContents());
            physique.setCity(sheet.getCell(9,i).getContents());
            physique.setPlace(sheet.getCell(10,i).getContents());
            physique.setNameCollection(sheet.getCell(11,i).getContents());
            physique.setManifold(sheet.getCell(12,i).getContents());
            physique.setLocalization(sheet.getCell(13,i).getContents());
            physique.setAnnexe1(sheet.getCell(14,i).getContents());
            physique.setAnnexe2(sheet.getCell(15,i).getContents());
            physique.setAnnexe3(sheet.getCell(16,i).getContents());
            physique.setAnnexe4(sheet.getCell(17,i).getContents());
            physique.setAnnexe5(sheet.getCell(18,i).getContents());
            physique.setAnnexe6(sheet.getCell(19,i).getContents());
            physique.setAnnexe7(sheet.getCell(20,i).getContents());
            physique.setAnnexe8(sheet.getCell(21,i).getContents());
            physique.setAnnexe9(sheet.getCell(22,i).getContents());
            physique.setAnnexe10(sheet.getCell(23,i).getContents());
            physique.setAnnexe11(sheet.getCell(24,i).getContents());
            physique.setAnnexe12(sheet.getCell(25,i).getContents());
            physique.setAnnexe13(sheet.getCell(26,i).getContents());
            physique.setAnnexe14(sheet.getCell(27,i).getContents());
            physique.setAnnexe15(sheet.getCell(28,i).getContents());
            physique.setAnnexe16(sheet.getCell(29,i).getContents());
            physique.setAnnexe17(sheet.getCell(30,i).getContents());
            physique.setAnnexe18(sheet.getCell(31,i).getContents());
            physique.setAnnexe19(sheet.getCell(32,i).getContents());
            physique.setAnnexe20(sheet.getCell(33,i).getContents());
            physique.setAnnexe21(sheet.getCell(34,i).getContents());
            physique.setAnnexe22(sheet.getCell(35,i).getContents());
            physique.setAnnexe23(sheet.getCell(36,i).getContents());
            physique.setAnnexe24(sheet.getCell(37,i).getContents());
            physique.setAnnexe25(sheet.getCell(38,i).getContents());
            physique.setAnnexe26(sheet.getCell(39,i).getContents());
            physique.setAnnexe27(sheet.getCell(40,i).getContents());
            physique.setAnnexe28(sheet.getCell(41,i).getContents());
            physique.setAnnexe29(sheet.getCell(42,i).getContents());
            physique.setAnnexe30(sheet.getCell(43,i).getContents());
            physique.setAnnexe31(sheet.getCell(44,i).getContents());
            physique.setAnnexe32(sheet.getCell(45,i).getContents());
            physique.setAnnexe33(sheet.getCell(46,i).getContents());
            physique.setAnnexe34(sheet.getCell(47,i).getContents());
            physique.setAnnexe35(sheet.getCell(48,i).getContents());
            physique.setAnnexe36(sheet.getCell(49,i).getContents());
            physique.setAnnexe37(sheet.getCell(50,i).getContents());
            physique.setAnnexe38(sheet.getCell(51,i).getContents());
            physique.setAnnexe39(sheet.getCell(52,i).getContents());
            physique.setAnnexe40(sheet.getCell(53,i).getContents());
            physiqueService.save(physique);
        }
    }

    @Override
    public void readFileExcelTypotheque() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            Typotheque typotheque = new Typotheque();
            typotheque.setId(sheet.getCell(0,i).getContents());
            typotheque.setPicture(sheet.getCell(1,i).getContents());
            typotheque.setName(sheet.getCell(2,i).getContents());
            typotheque.setGroupe(sheet.getCell(3,i).getContents());
            typotheque.setKind(sheet.getCell(4,i).getContents());
            typotheque.setEspece(sheet.getCell(5,i).getContents());
            typotheque.setAuthor(sheet.getCell(6,i).getContents());
            typotheque.setYear(sheet.getCell(7,i).getContents());
            typotheque.setCountry(sheet.getCell(8,i).getContents());
            typotheque.setCity(sheet.getCell(9,i).getContents());
            typotheque.setPlace(sheet.getCell(10,i).getContents());
            typotheque.setNameCollection(sheet.getCell(11,i).getContents());
            typotheque.setManifold(sheet.getCell(12,i).getContents());
            typotheque.setLocalization(sheet.getCell(13,i).getContents());
            typotheque.setAnnexe1(sheet.getCell(14,i).getContents());
            typotheque.setAnnexe2(sheet.getCell(15,i).getContents());
            typotheque.setAnnexe3(sheet.getCell(16,i).getContents());
            typotheque.setAnnexe4(sheet.getCell(17,i).getContents());
            typotheque.setAnnexe5(sheet.getCell(18,i).getContents());
            typotheque.setAnnexe6(sheet.getCell(19,i).getContents());
            typotheque.setAnnexe7(sheet.getCell(20,i).getContents());
            typotheque.setAnnexe8(sheet.getCell(21,i).getContents());
            typotheque.setAnnexe9(sheet.getCell(22,i).getContents());
            typotheque.setAnnexe10(sheet.getCell(23,i).getContents());
            typotheque.setAnnexe11(sheet.getCell(24,i).getContents());
            typotheque.setAnnexe12(sheet.getCell(25,i).getContents());
            typotheque.setAnnexe13(sheet.getCell(26,i).getContents());
            typotheque.setAnnexe14(sheet.getCell(27,i).getContents());
            typotheque.setAnnexe15(sheet.getCell(28,i).getContents());
            typotheque.setAnnexe16(sheet.getCell(29,i).getContents());
            typotheque.setAnnexe17(sheet.getCell(30,i).getContents());
            typotheque.setAnnexe18(sheet.getCell(31,i).getContents());
            typotheque.setAnnexe19(sheet.getCell(32,i).getContents());
            typotheque.setAnnexe20(sheet.getCell(33,i).getContents());
            typotheque.setAnnexe21(sheet.getCell(34,i).getContents());
            typotheque.setAnnexe22(sheet.getCell(35,i).getContents());
            typotheque.setAnnexe23(sheet.getCell(36,i).getContents());
            typotheque.setAnnexe24(sheet.getCell(37,i).getContents());
            typotheque.setAnnexe25(sheet.getCell(38,i).getContents());
            typotheque.setAnnexe26(sheet.getCell(39,i).getContents());
            typotheque.setAnnexe27(sheet.getCell(40,i).getContents());
            typotheque.setAnnexe28(sheet.getCell(41,i).getContents());
            typotheque.setAnnexe29(sheet.getCell(42,i).getContents());
            typotheque.setAnnexe30(sheet.getCell(43,i).getContents());
            typotheque.setAnnexe31(sheet.getCell(44,i).getContents());
            typotheque.setAnnexe32(sheet.getCell(45,i).getContents());
            typotheque.setAnnexe33(sheet.getCell(46,i).getContents());
            typotheque.setAnnexe34(sheet.getCell(47,i).getContents());
            typotheque.setAnnexe35(sheet.getCell(48,i).getContents());
            typotheque.setAnnexe36(sheet.getCell(49,i).getContents());
            typotheque.setAnnexe37(sheet.getCell(50,i).getContents());
            typotheque.setAnnexe38(sheet.getCell(51,i).getContents());
            typotheque.setAnnexe39(sheet.getCell(52,i).getContents());
            typotheque.setAnnexe40(sheet.getCell(53,i).getContents());
            typothequeService.save(typotheque);
        }
    }

    @Override
    public void readFileExcelZoologieInvertebresAutres() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieInvertebresAutres zoologieInvertebresAutres = new ZoologieInvertebresAutres();
            zoologieInvertebresAutres.setId(sheet.getCell(0,i).getContents());
            zoologieInvertebresAutres.setPicture(sheet.getCell(1,i).getContents());
            zoologieInvertebresAutres.setName(sheet.getCell(2,i).getContents());
            zoologieInvertebresAutres.setGroupe(sheet.getCell(3,i).getContents());
            zoologieInvertebresAutres.setKind(sheet.getCell(4,i).getContents());
            zoologieInvertebresAutres.setEspece(sheet.getCell(5,i).getContents());
            zoologieInvertebresAutres.setAuthor(sheet.getCell(6,i).getContents());
            zoologieInvertebresAutres.setYear(sheet.getCell(7,i).getContents());
            zoologieInvertebresAutres.setCountry(sheet.getCell(8,i).getContents());
            zoologieInvertebresAutres.setCity(sheet.getCell(9,i).getContents());
            zoologieInvertebresAutres.setPlace(sheet.getCell(10,i).getContents());
            zoologieInvertebresAutres.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieInvertebresAutres.setManifold(sheet.getCell(12,i).getContents());
            zoologieInvertebresAutres.setLocalization(sheet.getCell(13,i).getContents());
            zoologieInvertebresAutres.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieInvertebresAutres.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieInvertebresAutres.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieInvertebresAutres.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieInvertebresAutres.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieInvertebresAutres.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieInvertebresAutres.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieInvertebresAutres.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieInvertebresAutres.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieInvertebresAutres.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieInvertebresAutres.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieInvertebresAutres.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieInvertebresAutres.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieInvertebresAutres.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieInvertebresAutres.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieInvertebresAutres.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieInvertebresAutres.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieInvertebresAutres.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieInvertebresAutres.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieInvertebresAutres.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieInvertebresAutres.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieInvertebresAutres.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieInvertebresAutres.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieInvertebresAutres.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieInvertebresAutres.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieInvertebresAutres.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieInvertebresAutres.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieInvertebresAutres.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieInvertebresAutres.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieInvertebresAutres.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieInvertebresAutres.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieInvertebresAutres.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieInvertebresAutres.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieInvertebresAutres.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieInvertebresAutres.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieInvertebresAutres.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieInvertebresAutres.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieInvertebresAutres.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieInvertebresAutres.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieInvertebresAutres.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieInvertebresAutresService.save(zoologieInvertebresAutres);
        }
    }

    @Override
    public void readFileExcelZoologieInvertebresInsectes() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieInvertebresInsectes zoologieInvertebresInsectes = new ZoologieInvertebresInsectes();
            zoologieInvertebresInsectes.setId(sheet.getCell(0,i).getContents());
            zoologieInvertebresInsectes.setPicture(sheet.getCell(1,i).getContents());
            zoologieInvertebresInsectes.setName(sheet.getCell(2,i).getContents());
            zoologieInvertebresInsectes.setGroupe(sheet.getCell(3,i).getContents());
            zoologieInvertebresInsectes.setKind(sheet.getCell(4,i).getContents());
            zoologieInvertebresInsectes.setEspece(sheet.getCell(5,i).getContents());
            zoologieInvertebresInsectes.setAuthor(sheet.getCell(6,i).getContents());
            zoologieInvertebresInsectes.setYear(sheet.getCell(7,i).getContents());
            zoologieInvertebresInsectes.setCountry(sheet.getCell(8,i).getContents());
            zoologieInvertebresInsectes.setCity(sheet.getCell(9,i).getContents());
            zoologieInvertebresInsectes.setPlace(sheet.getCell(10,i).getContents());
            zoologieInvertebresInsectes.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieInvertebresInsectes.setManifold(sheet.getCell(12,i).getContents());
            zoologieInvertebresInsectes.setLocalization(sheet.getCell(13,i).getContents());
            zoologieInvertebresInsectes.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieInvertebresInsectes.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieInvertebresInsectes.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieInvertebresInsectes.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieInvertebresInsectes.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieInvertebresInsectes.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieInvertebresInsectes.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieInvertebresInsectes.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieInvertebresInsectes.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieInvertebresInsectes.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieInvertebresInsectes.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieInvertebresInsectes.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieInvertebresInsectes.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieInvertebresInsectes.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieInvertebresInsectes.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieInvertebresInsectes.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieInvertebresInsectes.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieInvertebresInsectes.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieInvertebresInsectes.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieInvertebresInsectes.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieInvertebresInsectes.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieInvertebresInsectes.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieInvertebresInsectes.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieInvertebresInsectes.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieInvertebresInsectes.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieInvertebresInsectes.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieInvertebresInsectes.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieInvertebresInsectes.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieInvertebresInsectes.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieInvertebresInsectes.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieInvertebresInsectes.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieInvertebresInsectes.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieInvertebresInsectes.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieInvertebresInsectes.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieInvertebresInsectes.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieInvertebresInsectes.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieInvertebresInsectes.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieInvertebresInsectes.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieInvertebresInsectes.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieInvertebresInsectes.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieInvertebresInsectesService.save(zoologieInvertebresInsectes);
        }
    }

    @Override
    public void readFileExcelZoologieInvertebresMollusque() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieInvertebresMollusques zoologieInvertebresMollusques = new ZoologieInvertebresMollusques();
            zoologieInvertebresMollusques.setId(sheet.getCell(0,i).getContents());
            zoologieInvertebresMollusques.setPicture(sheet.getCell(1,i).getContents());
            zoologieInvertebresMollusques.setName(sheet.getCell(2,i).getContents());
            zoologieInvertebresMollusques.setGroupe(sheet.getCell(3,i).getContents());
            zoologieInvertebresMollusques.setKind(sheet.getCell(4,i).getContents());
            zoologieInvertebresMollusques.setEspece(sheet.getCell(5,i).getContents());
            zoologieInvertebresMollusques.setAuthor(sheet.getCell(6,i).getContents());
            zoologieInvertebresMollusques.setYear(sheet.getCell(7,i).getContents());
            zoologieInvertebresMollusques.setCountry(sheet.getCell(8,i).getContents());
            zoologieInvertebresMollusques.setCity(sheet.getCell(9,i).getContents());
            zoologieInvertebresMollusques.setPlace(sheet.getCell(10,i).getContents());
            zoologieInvertebresMollusques.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieInvertebresMollusques.setManifold(sheet.getCell(12,i).getContents());
            zoologieInvertebresMollusques.setLocalization(sheet.getCell(13,i).getContents());
            zoologieInvertebresMollusques.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieInvertebresMollusques.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieInvertebresMollusques.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieInvertebresMollusques.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieInvertebresMollusques.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieInvertebresMollusques.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieInvertebresMollusques.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieInvertebresMollusques.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieInvertebresMollusques.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieInvertebresMollusques.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieInvertebresMollusques.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieInvertebresMollusques.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieInvertebresMollusques.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieInvertebresMollusques.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieInvertebresMollusques.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieInvertebresMollusques.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieInvertebresMollusques.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieInvertebresMollusques.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieInvertebresMollusques.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieInvertebresMollusques.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieInvertebresMollusques.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieInvertebresMollusques.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieInvertebresMollusques.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieInvertebresMollusques.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieInvertebresMollusques.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieInvertebresMollusques.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieInvertebresMollusques.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieInvertebresMollusques.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieInvertebresMollusques.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieInvertebresMollusques.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieInvertebresMollusques.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieInvertebresMollusques.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieInvertebresMollusques.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieInvertebresMollusques.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieInvertebresMollusques.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieInvertebresMollusques.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieInvertebresMollusques.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieInvertebresMollusques.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieInvertebresMollusques.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieInvertebresMollusques.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieInvertebresMollusquesService.save(zoologieInvertebresMollusques);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresAutres() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresAutres zoologieVertebresAutres = new ZoologieVertebresAutres();
            zoologieVertebresAutres.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresAutres.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresAutres.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresAutres.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresAutres.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresAutres.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresAutres.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresAutres.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresAutres.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresAutres.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresAutres.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresAutres.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresAutres.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresAutres.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresAutres.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresAutres.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresAutres.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresAutres.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresAutres.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresAutres.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresAutres.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresAutres.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresAutres.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresAutres.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresAutres.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresAutres.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresAutres.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresAutres.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresAutres.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresAutres.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresAutres.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresAutres.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresAutres.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresAutres.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresAutres.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresAutres.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresAutres.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresAutres.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresAutres.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresAutres.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresAutres.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresAutres.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresAutres.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresAutres.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresAutres.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresAutres.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresAutres.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresAutres.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresAutres.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresAutres.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresAutres.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresAutres.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresAutres.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresAutres.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresAutresService.save(zoologieVertebresAutres);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresMammiferes() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresMammiferes zoologieVertebresMammiferes = new ZoologieVertebresMammiferes();
            zoologieVertebresMammiferes.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresMammiferes.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresMammiferes.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresMammiferes.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresMammiferes.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresMammiferes.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresMammiferes.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresMammiferes.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresMammiferes.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresMammiferes.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresMammiferes.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresMammiferes.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresMammiferes.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresMammiferes.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresMammiferes.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresMammiferes.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresMammiferes.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresMammiferes.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresMammiferes.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresMammiferes.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresMammiferes.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresMammiferes.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresMammiferes.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresMammiferes.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresMammiferes.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresMammiferes.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresMammiferes.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresMammiferes.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresMammiferes.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresMammiferes.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresMammiferes.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresMammiferes.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresMammiferes.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresMammiferes.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresMammiferes.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresMammiferes.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresMammiferes.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresMammiferes.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresMammiferes.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresMammiferes.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresMammiferes.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresMammiferes.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresMammiferes.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresMammiferes.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresMammiferes.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresMammiferes.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresMammiferes.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresMammiferes.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresMammiferes.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresMammiferes.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresMammiferes.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresMammiferes.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresMammiferes.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresMammiferes.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresMammiferesService.save(zoologieVertebresMammiferes);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresOiseaux() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresOiseaux zoologieVertebresOiseaux = new ZoologieVertebresOiseaux();
            zoologieVertebresOiseaux.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresOiseaux.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresOiseaux.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresOiseaux.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresOiseaux.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresOiseaux.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresOiseaux.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresOiseaux.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresOiseaux.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresOiseaux.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresOiseaux.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresOiseaux.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresOiseaux.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresOiseaux.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresOiseaux.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresOiseaux.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresOiseaux.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresOiseaux.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresOiseaux.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresOiseaux.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresOiseaux.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresOiseaux.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresOiseaux.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresOiseaux.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresOiseaux.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresOiseaux.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresOiseaux.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresOiseaux.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresOiseaux.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresOiseaux.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresOiseaux.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresOiseaux.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresOiseaux.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresOiseaux.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresOiseaux.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresOiseaux.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresOiseaux.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresOiseaux.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresOiseaux.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresOiseaux.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresOiseaux.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresOiseaux.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresOiseaux.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresOiseaux.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresOiseaux.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresOiseaux.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresOiseaux.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresOiseaux.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresOiseaux.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresOiseaux.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresOiseaux.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresOiseaux.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresOiseaux.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresOiseaux.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresOiseauxService.save(zoologieVertebresOiseaux);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresPoissons() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresPoissons zoologieVertebresPoissons = new ZoologieVertebresPoissons();
            zoologieVertebresPoissons.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresPoissons.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresPoissons.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresPoissons.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresPoissons.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresPoissons.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresPoissons.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresPoissons.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresPoissons.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresPoissons.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresPoissons.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresPoissons.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresPoissons.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresPoissons.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresPoissons.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresPoissons.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresPoissons.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresPoissons.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresPoissons.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresPoissons.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresPoissons.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresPoissons.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresPoissons.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresPoissons.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresPoissons.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresPoissons.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresPoissons.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresPoissons.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresPoissons.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresPoissons.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresPoissons.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresPoissons.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresPoissons.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresPoissons.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresPoissons.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresPoissons.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresPoissons.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresPoissons.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresPoissons.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresPoissons.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresPoissons.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresPoissons.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresPoissons.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresPoissons.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresPoissons.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresPoissons.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresPoissons.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresPoissons.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresPoissons.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresPoissons.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresPoissons.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresPoissons.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresPoissons.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresPoissons.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresPoissonsService.save(zoologieVertebresPoissons);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresPrimates() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresPrimates zoologieVertebresPrimates = new ZoologieVertebresPrimates();
            zoologieVertebresPrimates.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresPrimates.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresPrimates.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresPrimates.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresPrimates.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresPrimates.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresPrimates.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresPrimates.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresPrimates.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresPrimates.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresPrimates.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresPrimates.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresPrimates.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresPrimates.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresPrimates.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresPrimates.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresPrimates.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresPrimates.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresPrimates.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresPrimates.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresPrimates.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresPrimates.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresPrimates.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresPrimates.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresPrimates.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresPrimates.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresPrimates.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresPrimates.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresPrimates.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresPrimates.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresPrimates.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresPrimates.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresPrimates.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresPrimates.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresPrimates.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresPrimates.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresPrimates.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresPrimates.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresPrimates.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresPrimates.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresPrimates.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresPrimates.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresPrimates.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresPrimates.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresPrimates.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresPrimates.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresPrimates.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresPrimates.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresPrimates.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresPrimates.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresPrimates.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresPrimates.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresPrimates.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresPrimates.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresPrimatesService.save(zoologieVertebresPrimates);
        }
    }

    @Override
    public void readFileExcelZoologieVertebresReptile() throws IOException, BiffException {
        Sheet sheet = workbook.getSheet(1);
        //Cell cell = sheet.getCell(0,4);
        for(int i = 3;i < sheet.getRows();i++){
            ZoologieVertebresReptile zoologieVertebresReptile = new ZoologieVertebresReptile();
            zoologieVertebresReptile.setId(sheet.getCell(0,i).getContents());
            zoologieVertebresReptile.setPicture(sheet.getCell(1,i).getContents());
            zoologieVertebresReptile.setName(sheet.getCell(2,i).getContents());
            zoologieVertebresReptile.setGroupe(sheet.getCell(3,i).getContents());
            zoologieVertebresReptile.setKind(sheet.getCell(4,i).getContents());
            zoologieVertebresReptile.setEspece(sheet.getCell(5,i).getContents());
            zoologieVertebresReptile.setAuthor(sheet.getCell(6,i).getContents());
            zoologieVertebresReptile.setYear(sheet.getCell(7,i).getContents());
            zoologieVertebresReptile.setCountry(sheet.getCell(8,i).getContents());
            zoologieVertebresReptile.setCity(sheet.getCell(9,i).getContents());
            zoologieVertebresReptile.setPlace(sheet.getCell(10,i).getContents());
            zoologieVertebresReptile.setNameCollection(sheet.getCell(11,i).getContents());
            zoologieVertebresReptile.setManifold(sheet.getCell(12,i).getContents());
            zoologieVertebresReptile.setLocalization(sheet.getCell(13,i).getContents());
            zoologieVertebresReptile.setAnnexe1(sheet.getCell(14,i).getContents());
            zoologieVertebresReptile.setAnnexe2(sheet.getCell(15,i).getContents());
            zoologieVertebresReptile.setAnnexe3(sheet.getCell(16,i).getContents());
            zoologieVertebresReptile.setAnnexe4(sheet.getCell(17,i).getContents());
            zoologieVertebresReptile.setAnnexe5(sheet.getCell(18,i).getContents());
            zoologieVertebresReptile.setAnnexe6(sheet.getCell(19,i).getContents());
            zoologieVertebresReptile.setAnnexe7(sheet.getCell(20,i).getContents());
            zoologieVertebresReptile.setAnnexe8(sheet.getCell(21,i).getContents());
            zoologieVertebresReptile.setAnnexe9(sheet.getCell(22,i).getContents());
            zoologieVertebresReptile.setAnnexe10(sheet.getCell(23,i).getContents());
            zoologieVertebresReptile.setAnnexe11(sheet.getCell(24,i).getContents());
            zoologieVertebresReptile.setAnnexe12(sheet.getCell(25,i).getContents());
            zoologieVertebresReptile.setAnnexe13(sheet.getCell(26,i).getContents());
            zoologieVertebresReptile.setAnnexe14(sheet.getCell(27,i).getContents());
            zoologieVertebresReptile.setAnnexe15(sheet.getCell(28,i).getContents());
            zoologieVertebresReptile.setAnnexe16(sheet.getCell(29,i).getContents());
            zoologieVertebresReptile.setAnnexe17(sheet.getCell(30,i).getContents());
            zoologieVertebresReptile.setAnnexe18(sheet.getCell(31,i).getContents());
            zoologieVertebresReptile.setAnnexe19(sheet.getCell(32,i).getContents());
            zoologieVertebresReptile.setAnnexe20(sheet.getCell(33,i).getContents());
            zoologieVertebresReptile.setAnnexe21(sheet.getCell(34,i).getContents());
            zoologieVertebresReptile.setAnnexe22(sheet.getCell(35,i).getContents());
            zoologieVertebresReptile.setAnnexe23(sheet.getCell(36,i).getContents());
            zoologieVertebresReptile.setAnnexe24(sheet.getCell(37,i).getContents());
            zoologieVertebresReptile.setAnnexe25(sheet.getCell(38,i).getContents());
            zoologieVertebresReptile.setAnnexe26(sheet.getCell(39,i).getContents());
            zoologieVertebresReptile.setAnnexe27(sheet.getCell(40,i).getContents());
            zoologieVertebresReptile.setAnnexe28(sheet.getCell(41,i).getContents());
            zoologieVertebresReptile.setAnnexe29(sheet.getCell(42,i).getContents());
            zoologieVertebresReptile.setAnnexe30(sheet.getCell(43,i).getContents());
            zoologieVertebresReptile.setAnnexe31(sheet.getCell(44,i).getContents());
            zoologieVertebresReptile.setAnnexe32(sheet.getCell(45,i).getContents());
            zoologieVertebresReptile.setAnnexe33(sheet.getCell(46,i).getContents());
            zoologieVertebresReptile.setAnnexe34(sheet.getCell(47,i).getContents());
            zoologieVertebresReptile.setAnnexe35(sheet.getCell(48,i).getContents());
            zoologieVertebresReptile.setAnnexe36(sheet.getCell(49,i).getContents());
            zoologieVertebresReptile.setAnnexe37(sheet.getCell(50,i).getContents());
            zoologieVertebresReptile.setAnnexe38(sheet.getCell(51,i).getContents());
            zoologieVertebresReptile.setAnnexe39(sheet.getCell(52,i).getContents());
            zoologieVertebresReptile.setAnnexe40(sheet.getCell(53,i).getContents());
            zoologieVertebresReptileService.save(zoologieVertebresReptile);
        }
    }
}
