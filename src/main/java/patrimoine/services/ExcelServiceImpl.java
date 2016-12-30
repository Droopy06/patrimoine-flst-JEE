package patrimoine.services;

import jxl.Sheet;
import jxl.Workbook;
import java.io.IOException;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
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
    private WritableWorkbook workbookWrite = null;
    private WritableSheet wsheet = null;
    @Autowired
    private CollectionDetailsService collectionDetailsService;
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
        readFileExcelHeaderImport(object);
        CollectionDetails collectionDetails = collectionDetailsService.findOne(object);
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
    public void readFileExcelHeaderImport(String object) throws IOException, BiffException {
        /* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
        Sheet sheet = workbook.getSheet(1);
        int i = 2;
        CollectionDetails collectionDetails = new CollectionDetails();
        collectionDetails.setNameOfCollection(object);
        collectionDetails.setId(sheet.getCell(0,i).getContents());
        collectionDetails.setPicture(sheet.getCell(1,i).getContents());
        collectionDetails.setName(sheet.getCell(2,i).getContents());
        collectionDetails.setGroupe(sheet.getCell(3,i).getContents());
        collectionDetails.setKind(sheet.getCell(4,i).getContents());
        collectionDetails.setEspece(sheet.getCell(5,i).getContents());
        collectionDetails.setAuthor(sheet.getCell(6,i).getContents());
        collectionDetails.setYear(sheet.getCell(7,i).getContents());
        collectionDetails.setCountry(sheet.getCell(8,i).getContents());
        collectionDetails.setCity(sheet.getCell(9,i).getContents());
        collectionDetails.setPlace(sheet.getCell(10,i).getContents());
        collectionDetails.setNameCollection(sheet.getCell(11,i).getContents());
        collectionDetails.setManifold(sheet.getCell(12,i).getContents());
        collectionDetails.setLocalization(sheet.getCell(13,i).getContents());
        collectionDetails.setAnnexe1(sheet.getCell(14,i).getContents());
        collectionDetails.setAnnexe2(sheet.getCell(15,i).getContents());
        collectionDetails.setAnnexe3(sheet.getCell(16,i).getContents());
        collectionDetails.setAnnexe4(sheet.getCell(17,i).getContents());
        collectionDetails.setAnnexe5(sheet.getCell(18,i).getContents());
        collectionDetails.setAnnexe6(sheet.getCell(19,i).getContents());
        collectionDetails.setAnnexe7(sheet.getCell(20,i).getContents());
        collectionDetails.setAnnexe8(sheet.getCell(21,i).getContents());
        collectionDetails.setAnnexe9(sheet.getCell(22,i).getContents());
        collectionDetails.setAnnexe10(sheet.getCell(23,i).getContents());
        collectionDetails.setAnnexe11(sheet.getCell(24,i).getContents());
        collectionDetails.setAnnexe12(sheet.getCell(25,i).getContents());
        collectionDetails.setAnnexe13(sheet.getCell(26,i).getContents());
        collectionDetails.setAnnexe14(sheet.getCell(27,i).getContents());
        collectionDetails.setAnnexe15(sheet.getCell(28,i).getContents());
        collectionDetails.setAnnexe16(sheet.getCell(29,i).getContents());
        collectionDetails.setAnnexe17(sheet.getCell(30,i).getContents());
        collectionDetails.setAnnexe18(sheet.getCell(31,i).getContents());
        collectionDetails.setAnnexe19(sheet.getCell(32,i).getContents());
        collectionDetails.setAnnexe20(sheet.getCell(33,i).getContents());
        collectionDetails.setAnnexe21(sheet.getCell(34,i).getContents());
        collectionDetails.setAnnexe22(sheet.getCell(35,i).getContents());
        collectionDetails.setAnnexe23(sheet.getCell(36,i).getContents());
        collectionDetails.setAnnexe24(sheet.getCell(37,i).getContents());
        collectionDetails.setAnnexe25(sheet.getCell(38,i).getContents());
        collectionDetails.setAnnexe26(sheet.getCell(39,i).getContents());
        collectionDetails.setAnnexe27(sheet.getCell(40,i).getContents());
        collectionDetails.setAnnexe28(sheet.getCell(41,i).getContents());
        collectionDetails.setAnnexe29(sheet.getCell(42,i).getContents());
        collectionDetails.setAnnexe30(sheet.getCell(43,i).getContents());
        collectionDetails.setAnnexe31(sheet.getCell(44,i).getContents());
        collectionDetails.setAnnexe32(sheet.getCell(45,i).getContents());
        collectionDetails.setAnnexe33(sheet.getCell(46,i).getContents());
        collectionDetails.setAnnexe34(sheet.getCell(47,i).getContents());
        collectionDetails.setAnnexe35(sheet.getCell(48,i).getContents());
        collectionDetails.setAnnexe36(sheet.getCell(49,i).getContents());
        collectionDetails.setAnnexe37(sheet.getCell(50,i).getContents());
        collectionDetails.setAnnexe38(sheet.getCell(51,i).getContents());
        collectionDetails.setAnnexe39(sheet.getCell(52,i).getContents());
        collectionDetails.setAnnexe40(sheet.getCell(53,i).getContents());
        collectionDetailsService.save(collectionDetails);
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
            pedagogique.setId(new String(sheet.getCell(0,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setPicture(new String(sheet.getCell(1,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setName(new String(sheet.getCell(2,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setGroupe(new String(sheet.getCell(3,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setKind(new String(sheet.getCell(4,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setEspece(new String(sheet.getCell(5,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setAuthor(new String(sheet.getCell(6,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setYear(new String(sheet.getCell(7,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setCountry(new String(sheet.getCell(8,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setCity(new String(sheet.getCell(9,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setPlace(new String(sheet.getCell(10,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setNameCollection(new String(sheet.getCell(11,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setManifold(new String(sheet.getCell(12,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setLocalization(new String(sheet.getCell(13,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setRetentionColor(new String(sheet.getCell(14,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setRetentionMechanism(new String(sheet.getCell(15,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setRetentionVarnish(new String(sheet.getCell(16,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setRetentionProperty(new String(sheet.getCell(17,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setStateModel(new String(sheet.getCell(18,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setType(new String(sheet.getCell(19,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setSignatureType(new String(sheet.getCell(20,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setSignatureInscription(new String(sheet.getCell(21,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setStructure(new String(sheet.getCell(22,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setBuyingPrice(new String(sheet.getCell(23,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setBuyingPriceCommercial(new String(sheet.getCell(24,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setDescriptif(new String(sheet.getCell(25,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setDimensions(new String(sheet.getCell(26,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
            pedagogique.setNumberElements(0);
            pedagogique.setAdministrator(new String(sheet.getCell(28,i).getContents().getBytes("ISO-8859-1" ), "UTF-8"));
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

    @Override
    public void writeFileExcelExport(String object) throws IOException, BiffException, WriteException {
        this.workbookWrite = Workbook.createWorkbook(new File(new File(".").getCanonicalPath()+"\\file\\"+object+".xls"));
        this.wsheet = workbookWrite.createSheet("Données", 0);
        writeFileExcelHeaderExport(object);
        switch (object) {
            case "Herbiers":
                writeFileExcelHerbiers();
                break;
            case "Instruments":
                writeFileExcelInstruments();
                break;
            case "Jardin Botanique":
                writeFileExcelJardinBotanique();
                break;
            case "Materiel Pedagogique":
                writeFileExcelMaterielPedagogique();
                break;
            case "Mineralogie Cristallographie":
                writeFileExcelMineralogieCristallographie();
                break;
            case "Ouvrages Cartes Documents":
                writeFileExcelOuvragesCartesDocuments();
                break;
            case "Paleontologie Animale":
                writeFileExcelPaleontologieAnimale();
                break;
            case "Paleontologie Vegetale":
                writeFileExcelPaleontologieVegetale();
                break;
            case "Pedagogique":
                writeFileExcelPedagogique();
                break;
            case "Petrographie":
                writeFileExcelPetrographie();
                break;
            case "Physique":
                writeFileExcelPhysique();
                break;
            case "Typotheque":
                writeFileExcelTypotheque();
                break;
            case "Zoologie Invertebres Autres":
                writeFileExcelZoologieInvertebresAutres();
                break;
            case "Zoologie Invertebres Insectes":
                writeFileExcelZoologieInvertebresInsectes();
                break;
            case "Zoologie Invertebres Mollusques":
                writeFileExcelZoologieInvertebresMollusque();
                break;
            case "Zoologie Vertebres Autres":
                writeFileExcelZoologieVertebresAutres();
                break;
            case "Zoologie Vertebres Mammiferes":
                writeFileExcelZoologieVertebresMammiferes();
                break;
            case "Zoologie Vertebres Oiseaux":
                writeFileExcelZoologieVertebresOiseaux();
                break;
            case "Zoologie Vertebres Poissons":
                writeFileExcelZoologieVertebresPoissons();
                break;
            case "Zoologie Vertebres Primates":
                writeFileExcelZoologieVertebresPrimates();
                break;
            case "Zoologie Vertebres Reptile":
                writeFileExcelZoologieVertebresReptile();
                break;
            default:
                break;
        }
        this.workbookWrite.write();
        this.workbookWrite.close();
    }

    @Override
    public void writeFileExcelHeaderExport(String object) throws IOException, BiffException, WriteException {
        /*CollectionDetails modelDetail = collectionDetailsService.findOne("Model");
        CollectionDetails headerModelObject = collectionDetailsService.findOne(object);*/
        CollectionDetails headerObject = collectionDetailsService.findOne(object);
        this.wsheet.addCell(new Label(0, 3, headerObject.getId()));
        this.wsheet.addCell(new Label(1, 3, headerObject.getPicture()));
        this.wsheet.addCell(new Label(2, 3, headerObject.getName()));
        this.wsheet.addCell(new Label(3, 3, headerObject.getGroupe()));
        this.wsheet.addCell(new Label(4, 3, headerObject.getKind()));
        this.wsheet.addCell(new Label(5, 3, headerObject.getEspece()));
        this.wsheet.addCell(new Label(6, 3, headerObject.getAuthor()));
        this.wsheet.addCell(new Label(7, 3, headerObject.getYear()));
        this.wsheet.addCell(new Label(8, 3, headerObject.getCountry()));
        this.wsheet.addCell(new Label(9, 3, headerObject.getCity()));
        this.wsheet.addCell(new Label(10, 3, headerObject.getPlace()));
        this.wsheet.addCell(new Label(11, 3, headerObject.getNameCollection()));
        this.wsheet.addCell(new Label(12, 3, headerObject.getManifold()));
        this.wsheet.addCell(new Label(13, 3, headerObject.getLocalization()));
        this.wsheet.addCell(new Label(14, 3, headerObject.getAnnexe1()));
        this.wsheet.addCell(new Label(15, 3, headerObject.getAnnexe2()));
        this.wsheet.addCell(new Label(16, 3, headerObject.getAnnexe3()));
        this.wsheet.addCell(new Label(17, 3, headerObject.getAnnexe4()));
        this.wsheet.addCell(new Label(18, 3, headerObject.getAnnexe5()));
        this.wsheet.addCell(new Label(19, 3, headerObject.getAnnexe6()));
        this.wsheet.addCell(new Label(20, 3, headerObject.getAnnexe7()));
        this.wsheet.addCell(new Label(21, 3, headerObject.getAnnexe8()));
        this.wsheet.addCell(new Label(22, 3, headerObject.getAnnexe9()));
        this.wsheet.addCell(new Label(23, 3, headerObject.getAnnexe10()));
        this.wsheet.addCell(new Label(24, 3, headerObject.getAnnexe11()));
        this.wsheet.addCell(new Label(25, 3, headerObject.getAnnexe12()));
        this.wsheet.addCell(new Label(26, 3, headerObject.getAnnexe13()));
        this.wsheet.addCell(new Label(27, 3, headerObject.getAnnexe14()));
        this.wsheet.addCell(new Label(28, 3, headerObject.getAnnexe15()));
        this.wsheet.addCell(new Label(29, 3, headerObject.getAnnexe16()));
        this.wsheet.addCell(new Label(30, 3, headerObject.getAnnexe17()));
        this.wsheet.addCell(new Label(31, 3, headerObject.getAnnexe18()));
        this.wsheet.addCell(new Label(32, 3, headerObject.getAnnexe19()));
        this.wsheet.addCell(new Label(33, 3, headerObject.getAnnexe20()));
        this.wsheet.addCell(new Label(34, 3, headerObject.getAnnexe21()));
        this.wsheet.addCell(new Label(35, 3, headerObject.getAnnexe22()));
        this.wsheet.addCell(new Label(36, 3, headerObject.getAnnexe23()));
        this.wsheet.addCell(new Label(37, 3, headerObject.getAnnexe24()));
        this.wsheet.addCell(new Label(38, 3, headerObject.getAnnexe25()));
        this.wsheet.addCell(new Label(39, 3, headerObject.getAnnexe26()));
        this.wsheet.addCell(new Label(40, 3, headerObject.getAnnexe27()));
        this.wsheet.addCell(new Label(41, 3, headerObject.getAnnexe28()));
        this.wsheet.addCell(new Label(42, 3, headerObject.getAnnexe29()));
        this.wsheet.addCell(new Label(43, 3, headerObject.getAnnexe30()));
        this.wsheet.addCell(new Label(44, 3, headerObject.getAnnexe31()));
        this.wsheet.addCell(new Label(45, 3, headerObject.getAnnexe32()));
        this.wsheet.addCell(new Label(46, 3, headerObject.getAnnexe33()));
        this.wsheet.addCell(new Label(47, 3, headerObject.getAnnexe34()));
        this.wsheet.addCell(new Label(48, 3, headerObject.getAnnexe35()));
        this.wsheet.addCell(new Label(49, 3, headerObject.getAnnexe36()));
        this.wsheet.addCell(new Label(50, 3, headerObject.getAnnexe37()));
        this.wsheet.addCell(new Label(51, 3, headerObject.getAnnexe38()));
        this.wsheet.addCell(new Label(52, 3, headerObject.getAnnexe39()));
        this.wsheet.addCell(new Label(53, 3, headerObject.getAnnexe40()));
    }

    @Override
    public void writeFileExcelHerbiers() throws IOException, BiffException, WriteException {
        List<Herbiers> herbiersList = herbiersService.findAll();
        int rows = 4;
        for (Herbiers herbiers : herbiersList) {
            this.wsheet.addCell(new Label(0, rows, herbiers.getId()));
            this.wsheet.addCell(new Label(1, rows, herbiers.getPicture()));
            this.wsheet.addCell(new Label(2, rows, herbiers.getName()));
            this.wsheet.addCell(new Label(3, rows, herbiers.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, herbiers.getKind()));
            this.wsheet.addCell(new Label(5, rows, herbiers.getEspece()));
            this.wsheet.addCell(new Label(6, rows, herbiers.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, herbiers.getYear()));
            this.wsheet.addCell(new Label(8, rows, herbiers.getCountry()));
            this.wsheet.addCell(new Label(9, rows, herbiers.getCity()));
            this.wsheet.addCell(new Label(10, rows, herbiers.getPlace()));
            this.wsheet.addCell(new Label(11, rows, herbiers.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, herbiers.getManifold()));
            this.wsheet.addCell(new Label(13, rows, herbiers.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, herbiers.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, herbiers.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, herbiers.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, herbiers.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, herbiers.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, herbiers.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, herbiers.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, herbiers.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, herbiers.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, herbiers.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, herbiers.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, herbiers.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, herbiers.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, herbiers.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, herbiers.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, herbiers.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, herbiers.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, herbiers.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, herbiers.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, herbiers.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, herbiers.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, herbiers.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, herbiers.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, herbiers.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, herbiers.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, herbiers.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, herbiers.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, herbiers.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, herbiers.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, herbiers.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, herbiers.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, herbiers.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, herbiers.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, herbiers.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, herbiers.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, herbiers.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, herbiers.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, herbiers.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, herbiers.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, herbiers.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelInstruments() throws IOException, BiffException, WriteException {
        List<Instruments> instrumentsList = instrumentsService.findAll();
        int rows = 4;
        for (Instruments instruments : instrumentsList) {
            this.wsheet.addCell(new Label(0, rows, instruments.getId()));
            this.wsheet.addCell(new Label(1, rows, instruments.getPicture()));
            this.wsheet.addCell(new Label(2, rows, instruments.getName()));
            this.wsheet.addCell(new Label(3, rows, instruments.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, instruments.getKind()));
            this.wsheet.addCell(new Label(5, rows, instruments.getEspece()));
            this.wsheet.addCell(new Label(6, rows, instruments.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, instruments.getYear()));
            this.wsheet.addCell(new Label(8, rows, instruments.getCountry()));
            this.wsheet.addCell(new Label(9, rows, instruments.getCity()));
            this.wsheet.addCell(new Label(10, rows, instruments.getPlace()));
            this.wsheet.addCell(new Label(11, rows, instruments.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, instruments.getManifold()));
            this.wsheet.addCell(new Label(13, rows, instruments.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, instruments.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, instruments.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, instruments.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, instruments.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, instruments.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, instruments.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, instruments.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, instruments.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, instruments.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, instruments.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, instruments.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, instruments.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, instruments.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, instruments.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, instruments.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, instruments.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, instruments.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, instruments.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, instruments.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, instruments.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, instruments.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, instruments.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, instruments.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, instruments.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, instruments.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, instruments.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, instruments.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, instruments.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, instruments.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, instruments.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, instruments.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, instruments.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, instruments.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, instruments.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, instruments.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, instruments.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, instruments.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, instruments.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, instruments.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, instruments.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelJardinBotanique() throws IOException, BiffException, WriteException {
        List<JardinBotanique> jardinBotaniqueList = jardinBotaniqueService.findAll();
        int rows = 4;
        for (JardinBotanique jardinBotanique : jardinBotaniqueList) {
            this.wsheet.addCell(new Label(0, rows, jardinBotanique.getId()));
            this.wsheet.addCell(new Label(1, rows, jardinBotanique.getPicture()));
            this.wsheet.addCell(new Label(2, rows, jardinBotanique.getName()));
            this.wsheet.addCell(new Label(3, rows, jardinBotanique.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, jardinBotanique.getKind()));
            this.wsheet.addCell(new Label(5, rows, jardinBotanique.getEspece()));
            this.wsheet.addCell(new Label(6, rows, jardinBotanique.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, jardinBotanique.getYear()));
            this.wsheet.addCell(new Label(8, rows, jardinBotanique.getCountry()));
            this.wsheet.addCell(new Label(9, rows, jardinBotanique.getCity()));
            this.wsheet.addCell(new Label(10, rows, jardinBotanique.getPlace()));
            this.wsheet.addCell(new Label(11, rows, jardinBotanique.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, jardinBotanique.getManifold()));
            this.wsheet.addCell(new Label(13, rows, jardinBotanique.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, jardinBotanique.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, jardinBotanique.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, jardinBotanique.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, jardinBotanique.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, jardinBotanique.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, jardinBotanique.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, jardinBotanique.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, jardinBotanique.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, jardinBotanique.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, jardinBotanique.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, jardinBotanique.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, jardinBotanique.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, jardinBotanique.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, jardinBotanique.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, jardinBotanique.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, jardinBotanique.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, jardinBotanique.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, jardinBotanique.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, jardinBotanique.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, jardinBotanique.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, jardinBotanique.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, jardinBotanique.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, jardinBotanique.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, jardinBotanique.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, jardinBotanique.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, jardinBotanique.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, jardinBotanique.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, jardinBotanique.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, jardinBotanique.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, jardinBotanique.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, jardinBotanique.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, jardinBotanique.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, jardinBotanique.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, jardinBotanique.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, jardinBotanique.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, jardinBotanique.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, jardinBotanique.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, jardinBotanique.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, jardinBotanique.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, jardinBotanique.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelMaterielPedagogique() throws IOException, BiffException, WriteException {
        List<MaterielPedagogique> materielPedagogiqueList = materielPedagoiqueService.findAll();
        int rows = 4;
        for (MaterielPedagogique materielPedagogique : materielPedagogiqueList) {
            this.wsheet.addCell(new Label(0, rows, materielPedagogique.getId()));
            this.wsheet.addCell(new Label(1, rows, materielPedagogique.getPicture()));
            this.wsheet.addCell(new Label(2, rows, materielPedagogique.getName()));
            this.wsheet.addCell(new Label(3, rows, materielPedagogique.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, materielPedagogique.getKind()));
            this.wsheet.addCell(new Label(5, rows, materielPedagogique.getEspece()));
            this.wsheet.addCell(new Label(6, rows, materielPedagogique.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, materielPedagogique.getYear()));
            this.wsheet.addCell(new Label(8, rows, materielPedagogique.getCountry()));
            this.wsheet.addCell(new Label(9, rows, materielPedagogique.getCity()));
            this.wsheet.addCell(new Label(10, rows, materielPedagogique.getPlace()));
            this.wsheet.addCell(new Label(11, rows, materielPedagogique.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, materielPedagogique.getManifold()));
            this.wsheet.addCell(new Label(13, rows, materielPedagogique.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, materielPedagogique.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, materielPedagogique.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, materielPedagogique.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, materielPedagogique.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, materielPedagogique.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, materielPedagogique.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, materielPedagogique.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, materielPedagogique.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, materielPedagogique.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, materielPedagogique.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, materielPedagogique.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, materielPedagogique.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, materielPedagogique.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, materielPedagogique.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, materielPedagogique.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, materielPedagogique.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, materielPedagogique.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, materielPedagogique.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, materielPedagogique.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, materielPedagogique.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, materielPedagogique.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, materielPedagogique.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, materielPedagogique.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, materielPedagogique.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, materielPedagogique.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, materielPedagogique.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, materielPedagogique.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, materielPedagogique.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, materielPedagogique.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, materielPedagogique.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, materielPedagogique.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, materielPedagogique.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, materielPedagogique.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, materielPedagogique.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, materielPedagogique.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, materielPedagogique.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, materielPedagogique.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, materielPedagogique.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, materielPedagogique.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, materielPedagogique.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelMineralogieCristallographie() throws IOException, BiffException, WriteException {
        List<MineralogieCristallographie> mineralogieCristallographieList = mineralogieCristallographiqueService.findAll();
        int rows = 4;
        for (MineralogieCristallographie mineralogieCristallographie : mineralogieCristallographieList) {
            this.wsheet.addCell(new Label(0, rows, mineralogieCristallographie.getId()));
            this.wsheet.addCell(new Label(1, rows, mineralogieCristallographie.getPicture()));
            this.wsheet.addCell(new Label(2, rows, mineralogieCristallographie.getName()));
            this.wsheet.addCell(new Label(3, rows, mineralogieCristallographie.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, mineralogieCristallographie.getKind()));
            this.wsheet.addCell(new Label(5, rows, mineralogieCristallographie.getEspece()));
            this.wsheet.addCell(new Label(6, rows, mineralogieCristallographie.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, mineralogieCristallographie.getYear()));
            this.wsheet.addCell(new Label(8, rows, mineralogieCristallographie.getCountry()));
            this.wsheet.addCell(new Label(9, rows, mineralogieCristallographie.getCity()));
            this.wsheet.addCell(new Label(10, rows, mineralogieCristallographie.getPlace()));
            this.wsheet.addCell(new Label(11, rows, mineralogieCristallographie.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, mineralogieCristallographie.getManifold()));
            this.wsheet.addCell(new Label(13, rows, mineralogieCristallographie.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, mineralogieCristallographie.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, mineralogieCristallographie.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, mineralogieCristallographie.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, mineralogieCristallographie.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, mineralogieCristallographie.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, mineralogieCristallographie.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, mineralogieCristallographie.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, mineralogieCristallographie.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, mineralogieCristallographie.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, mineralogieCristallographie.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, mineralogieCristallographie.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, mineralogieCristallographie.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, mineralogieCristallographie.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, mineralogieCristallographie.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, mineralogieCristallographie.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, mineralogieCristallographie.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, mineralogieCristallographie.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, mineralogieCristallographie.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, mineralogieCristallographie.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, mineralogieCristallographie.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, mineralogieCristallographie.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, mineralogieCristallographie.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, mineralogieCristallographie.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, mineralogieCristallographie.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, mineralogieCristallographie.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, mineralogieCristallographie.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, mineralogieCristallographie.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, mineralogieCristallographie.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, mineralogieCristallographie.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, mineralogieCristallographie.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, mineralogieCristallographie.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, mineralogieCristallographie.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, mineralogieCristallographie.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, mineralogieCristallographie.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, mineralogieCristallographie.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, mineralogieCristallographie.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, mineralogieCristallographie.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, mineralogieCristallographie.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, mineralogieCristallographie.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, mineralogieCristallographie.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelOuvragesCartesDocuments() throws IOException, BiffException, WriteException {
        List<OuvragesCartesDocuments> ouvragesCartesDocumentsList = ouvragesCartesDocumentsService.findAll();
        int rows = 4;
        for (OuvragesCartesDocuments cartesDocuments : ouvragesCartesDocumentsList) {
            this.wsheet.addCell(new Label(0, rows, cartesDocuments.getId()));
            this.wsheet.addCell(new Label(1, rows, cartesDocuments.getPicture()));
            this.wsheet.addCell(new Label(2, rows, cartesDocuments.getName()));
            this.wsheet.addCell(new Label(3, rows, cartesDocuments.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, cartesDocuments.getKind()));
            this.wsheet.addCell(new Label(5, rows, cartesDocuments.getEspece()));
            this.wsheet.addCell(new Label(6, rows, cartesDocuments.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, cartesDocuments.getYear()));
            this.wsheet.addCell(new Label(8, rows, cartesDocuments.getCountry()));
            this.wsheet.addCell(new Label(9, rows, cartesDocuments.getCity()));
            this.wsheet.addCell(new Label(10, rows, cartesDocuments.getPlace()));
            this.wsheet.addCell(new Label(11, rows, cartesDocuments.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, cartesDocuments.getManifold()));
            this.wsheet.addCell(new Label(13, rows, cartesDocuments.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, cartesDocuments.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, cartesDocuments.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, cartesDocuments.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, cartesDocuments.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, cartesDocuments.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, cartesDocuments.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, cartesDocuments.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, cartesDocuments.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, cartesDocuments.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, cartesDocuments.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, cartesDocuments.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, cartesDocuments.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, cartesDocuments.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, cartesDocuments.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, cartesDocuments.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, cartesDocuments.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, cartesDocuments.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, cartesDocuments.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, cartesDocuments.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, cartesDocuments.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, cartesDocuments.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, cartesDocuments.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, cartesDocuments.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, cartesDocuments.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, cartesDocuments.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, cartesDocuments.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, cartesDocuments.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, cartesDocuments.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, cartesDocuments.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, cartesDocuments.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, cartesDocuments.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, cartesDocuments.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, cartesDocuments.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, cartesDocuments.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, cartesDocuments.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, cartesDocuments.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, cartesDocuments.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, cartesDocuments.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, cartesDocuments.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, cartesDocuments.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelPaleontologieAnimale() throws IOException, BiffException, WriteException {
        List<PaleontologieAnimale> paleontologieAnimaleList = paleontologieAnimaleService.findAll();
        int rows = 4;
        for (PaleontologieAnimale paleontologieAnimale : paleontologieAnimaleList) {
            this.wsheet.addCell(new Label(0, rows, paleontologieAnimale.getId()));
            this.wsheet.addCell(new Label(1, rows, paleontologieAnimale.getPicture()));
            this.wsheet.addCell(new Label(2, rows, paleontologieAnimale.getName()));
            this.wsheet.addCell(new Label(3, rows, paleontologieAnimale.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, paleontologieAnimale.getKind()));
            this.wsheet.addCell(new Label(5, rows, paleontologieAnimale.getEspece()));
            this.wsheet.addCell(new Label(6, rows, paleontologieAnimale.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, paleontologieAnimale.getYear()));
            this.wsheet.addCell(new Label(8, rows, paleontologieAnimale.getCountry()));
            this.wsheet.addCell(new Label(9, rows, paleontologieAnimale.getCity()));
            this.wsheet.addCell(new Label(10, rows, paleontologieAnimale.getPlace()));
            this.wsheet.addCell(new Label(11, rows, paleontologieAnimale.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, paleontologieAnimale.getManifold()));
            this.wsheet.addCell(new Label(13, rows, paleontologieAnimale.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, paleontologieAnimale.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, paleontologieAnimale.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, paleontologieAnimale.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, paleontologieAnimale.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, paleontologieAnimale.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, paleontologieAnimale.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, paleontologieAnimale.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, paleontologieAnimale.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, paleontologieAnimale.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, paleontologieAnimale.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, paleontologieAnimale.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, paleontologieAnimale.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, paleontologieAnimale.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, paleontologieAnimale.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, paleontologieAnimale.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, paleontologieAnimale.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, paleontologieAnimale.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, paleontologieAnimale.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, paleontologieAnimale.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, paleontologieAnimale.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, paleontologieAnimale.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, paleontologieAnimale.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, paleontologieAnimale.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, paleontologieAnimale.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, paleontologieAnimale.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, paleontologieAnimale.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, paleontologieAnimale.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, paleontologieAnimale.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, paleontologieAnimale.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, paleontologieAnimale.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, paleontologieAnimale.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, paleontologieAnimale.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, paleontologieAnimale.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, paleontologieAnimale.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, paleontologieAnimale.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, paleontologieAnimale.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, paleontologieAnimale.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, paleontologieAnimale.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, paleontologieAnimale.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, paleontologieAnimale.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelPaleontologieVegetale() throws IOException, BiffException, WriteException {
        List<PaleontologieVegetale> paleontologieVegetaleList = paleontologieVegetaleService.findAll();
        int rows = 4;
        for (PaleontologieVegetale paleontologieVegetale : paleontologieVegetaleList) {
            this.wsheet.addCell(new Label(0, rows, paleontologieVegetale.getId()));
            this.wsheet.addCell(new Label(1, rows, paleontologieVegetale.getPicture()));
            this.wsheet.addCell(new Label(2, rows, paleontologieVegetale.getName()));
            this.wsheet.addCell(new Label(3, rows, paleontologieVegetale.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, paleontologieVegetale.getKind()));
            this.wsheet.addCell(new Label(5, rows, paleontologieVegetale.getEspece()));
            this.wsheet.addCell(new Label(6, rows, paleontologieVegetale.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, paleontologieVegetale.getYear()));
            this.wsheet.addCell(new Label(8, rows, paleontologieVegetale.getCountry()));
            this.wsheet.addCell(new Label(9, rows, paleontologieVegetale.getCity()));
            this.wsheet.addCell(new Label(10, rows, paleontologieVegetale.getPlace()));
            this.wsheet.addCell(new Label(11, rows, paleontologieVegetale.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, paleontologieVegetale.getManifold()));
            this.wsheet.addCell(new Label(13, rows, paleontologieVegetale.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, paleontologieVegetale.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, paleontologieVegetale.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, paleontologieVegetale.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, paleontologieVegetale.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, paleontologieVegetale.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, paleontologieVegetale.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, paleontologieVegetale.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, paleontologieVegetale.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, paleontologieVegetale.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, paleontologieVegetale.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, paleontologieVegetale.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, paleontologieVegetale.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, paleontologieVegetale.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, paleontologieVegetale.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, paleontologieVegetale.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, paleontologieVegetale.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, paleontologieVegetale.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, paleontologieVegetale.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, paleontologieVegetale.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, paleontologieVegetale.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, paleontologieVegetale.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, paleontologieVegetale.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, paleontologieVegetale.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, paleontologieVegetale.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, paleontologieVegetale.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, paleontologieVegetale.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, paleontologieVegetale.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, paleontologieVegetale.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, paleontologieVegetale.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, paleontologieVegetale.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, paleontologieVegetale.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, paleontologieVegetale.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, paleontologieVegetale.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, paleontologieVegetale.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, paleontologieVegetale.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, paleontologieVegetale.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, paleontologieVegetale.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, paleontologieVegetale.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, paleontologieVegetale.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, paleontologieVegetale.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelPedagogique() throws IOException, BiffException, WriteException {
        List<Pedagogique> pedagogiqueList = pedagogiqueService.findAll();
        int rows = 4;
        for (Pedagogique pedagogique : pedagogiqueList) {
            this.wsheet.addCell(new Label(0, rows, pedagogique.getId()));
            this.wsheet.addCell(new Label(1, rows, pedagogique.getPicture()));
            this.wsheet.addCell(new Label(2, rows, pedagogique.getName()));
            this.wsheet.addCell(new Label(3, rows, pedagogique.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, pedagogique.getKind()));
            this.wsheet.addCell(new Label(5, rows, pedagogique.getEspece()));
            this.wsheet.addCell(new Label(6, rows, pedagogique.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, pedagogique.getYear()));
            this.wsheet.addCell(new Label(8, rows, pedagogique.getCountry()));
            this.wsheet.addCell(new Label(9, rows, pedagogique.getCity()));
            this.wsheet.addCell(new Label(10, rows, pedagogique.getPlace()));
            this.wsheet.addCell(new Label(11, rows, pedagogique.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, pedagogique.getManifold()));
            this.wsheet.addCell(new Label(13, rows, pedagogique.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, pedagogique.getRetentionColor()));
            this.wsheet.addCell(new Label(15, rows, pedagogique.getRetentionMechanism()));
            this.wsheet.addCell(new Label(16, rows, pedagogique.getRetentionVarnish()));
            this.wsheet.addCell(new Label(17, rows, pedagogique.getRetentionProperty()));
            this.wsheet.addCell(new Label(18, rows, pedagogique.getStateModel()));
            this.wsheet.addCell(new Label(19, rows, pedagogique.getType()));
            this.wsheet.addCell(new Label(20, rows, pedagogique.getSignatureType()));
            this.wsheet.addCell(new Label(21, rows, pedagogique.getSignatureInscription()));
            this.wsheet.addCell(new Label(22, rows, pedagogique.getStructure()));
            this.wsheet.addCell(new Label(23, rows, pedagogique.getBuyingPrice()));
            this.wsheet.addCell(new Label(24, rows, pedagogique.getBuyingPriceCommercial()));
            this.wsheet.addCell(new Label(25, rows, pedagogique.getDescriptif()));
            this.wsheet.addCell(new Label(26, rows, pedagogique.getDimensions()));
            this.wsheet.addCell(new Label(27, rows, pedagogique.getNumberElements().toString()));
            this.wsheet.addCell(new Label(28, rows, pedagogique.getAdministrator()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelPetrographie() throws IOException, BiffException, WriteException {
        List<Petrographie> petrographieList = petrographieService.findAll();
        int rows = 4;
        for (Petrographie petrographie : petrographieList) {
            this.wsheet.addCell(new Label(0, rows, petrographie.getId()));
            this.wsheet.addCell(new Label(1, rows, petrographie.getPicture()));
            this.wsheet.addCell(new Label(2, rows, petrographie.getName()));
            this.wsheet.addCell(new Label(3, rows, petrographie.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, petrographie.getKind()));
            this.wsheet.addCell(new Label(5, rows, petrographie.getEspece()));
            this.wsheet.addCell(new Label(6, rows, petrographie.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, petrographie.getYear()));
            this.wsheet.addCell(new Label(8, rows, petrographie.getCountry()));
            this.wsheet.addCell(new Label(9, rows, petrographie.getCity()));
            this.wsheet.addCell(new Label(10, rows, petrographie.getPlace()));
            this.wsheet.addCell(new Label(11, rows, petrographie.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, petrographie.getManifold()));
            this.wsheet.addCell(new Label(13, rows, petrographie.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, petrographie.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, petrographie.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, petrographie.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, petrographie.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, petrographie.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, petrographie.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, petrographie.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, petrographie.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, petrographie.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, petrographie.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, petrographie.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, petrographie.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, petrographie.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, petrographie.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, petrographie.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, petrographie.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, petrographie.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, petrographie.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, petrographie.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, petrographie.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, petrographie.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, petrographie.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, petrographie.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, petrographie.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, petrographie.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, petrographie.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, petrographie.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, petrographie.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, petrographie.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, petrographie.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, petrographie.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, petrographie.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, petrographie.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, petrographie.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, petrographie.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, petrographie.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, petrographie.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, petrographie.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, petrographie.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, petrographie.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelPhysique() throws IOException, BiffException, WriteException {
        List<Physique> physiqueList = physiqueService.findAll();
        int rows = 4;
        for (Physique physique : physiqueList) {
            this.wsheet.addCell(new Label(0, rows, physique.getId()));
            this.wsheet.addCell(new Label(1, rows, physique.getPicture()));
            this.wsheet.addCell(new Label(2, rows, physique.getName()));
            this.wsheet.addCell(new Label(3, rows, physique.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, physique.getKind()));
            this.wsheet.addCell(new Label(5, rows, physique.getEspece()));
            this.wsheet.addCell(new Label(6, rows, physique.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, physique.getYear()));
            this.wsheet.addCell(new Label(8, rows, physique.getCountry()));
            this.wsheet.addCell(new Label(9, rows, physique.getCity()));
            this.wsheet.addCell(new Label(10, rows, physique.getPlace()));
            this.wsheet.addCell(new Label(11, rows, physique.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, physique.getManifold()));
            this.wsheet.addCell(new Label(13, rows, physique.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, physique.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, physique.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, physique.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, physique.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, physique.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, physique.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, physique.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, physique.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, physique.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, physique.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, physique.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, physique.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, physique.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, physique.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, physique.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, physique.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, physique.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, physique.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, physique.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, physique.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, physique.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, physique.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, physique.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, physique.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, physique.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, physique.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, physique.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, physique.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, physique.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, physique.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, physique.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, physique.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, physique.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, physique.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, physique.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, physique.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, physique.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, physique.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, physique.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, physique.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelTypotheque() throws IOException, BiffException, WriteException {
        List<Typotheque> typothequeList = typothequeService.findAll();
        int rows = 4;
        for (Typotheque typotheque : typothequeList) {
            this.wsheet.addCell(new Label(0, rows, typotheque.getId()));
            this.wsheet.addCell(new Label(1, rows, typotheque.getPicture()));
            this.wsheet.addCell(new Label(2, rows, typotheque.getName()));
            this.wsheet.addCell(new Label(3, rows, typotheque.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, typotheque.getKind()));
            this.wsheet.addCell(new Label(5, rows, typotheque.getEspece()));
            this.wsheet.addCell(new Label(6, rows, typotheque.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, typotheque.getYear()));
            this.wsheet.addCell(new Label(8, rows, typotheque.getCountry()));
            this.wsheet.addCell(new Label(9, rows, typotheque.getCity()));
            this.wsheet.addCell(new Label(10, rows, typotheque.getPlace()));
            this.wsheet.addCell(new Label(11, rows, typotheque.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, typotheque.getManifold()));
            this.wsheet.addCell(new Label(13, rows, typotheque.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, typotheque.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, typotheque.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, typotheque.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, typotheque.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, typotheque.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, typotheque.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, typotheque.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, typotheque.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, typotheque.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, typotheque.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, typotheque.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, typotheque.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, typotheque.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, typotheque.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, typotheque.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, typotheque.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, typotheque.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, typotheque.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, typotheque.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, typotheque.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, typotheque.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, typotheque.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, typotheque.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, typotheque.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, typotheque.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, typotheque.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, typotheque.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, typotheque.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, typotheque.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, typotheque.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, typotheque.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, typotheque.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, typotheque.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, typotheque.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, typotheque.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, typotheque.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, typotheque.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, typotheque.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, typotheque.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, typotheque.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieInvertebresAutres() throws IOException, BiffException, WriteException {
        List<ZoologieInvertebresAutres> zoologieInvertebresAutresList = zoologieInvertebresAutresService.findAll();
        int rows = 4;
        for (ZoologieInvertebresAutres zoologieInvertebresAutres : zoologieInvertebresAutresList) {
            this.wsheet.addCell(new Label(0, rows, zoologieInvertebresAutres.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieInvertebresAutres.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieInvertebresAutres.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieInvertebresAutres.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieInvertebresAutres.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieInvertebresAutres.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieInvertebresAutres.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieInvertebresAutres.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieInvertebresAutres.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieInvertebresAutres.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieInvertebresAutres.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieInvertebresAutres.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieInvertebresAutres.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieInvertebresAutres.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieInvertebresAutres.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieInvertebresAutres.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieInvertebresAutres.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieInvertebresAutres.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieInvertebresAutres.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieInvertebresAutres.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieInvertebresAutres.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieInvertebresAutres.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieInvertebresAutres.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieInvertebresAutres.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieInvertebresAutres.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieInvertebresAutres.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieInvertebresAutres.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieInvertebresAutres.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieInvertebresAutres.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieInvertebresAutres.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieInvertebresAutres.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieInvertebresAutres.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieInvertebresAutres.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieInvertebresAutres.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieInvertebresAutres.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieInvertebresAutres.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieInvertebresAutres.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieInvertebresAutres.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieInvertebresAutres.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieInvertebresAutres.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieInvertebresAutres.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieInvertebresAutres.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieInvertebresAutres.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieInvertebresAutres.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieInvertebresAutres.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieInvertebresAutres.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieInvertebresAutres.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieInvertebresAutres.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieInvertebresAutres.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieInvertebresAutres.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieInvertebresAutres.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieInvertebresAutres.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieInvertebresAutres.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieInvertebresAutres.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieInvertebresInsectes() throws IOException, BiffException, WriteException {
        List<ZoologieInvertebresInsectes> zoologieInvertebresInsectesList = zoologieInvertebresInsectesService.findAll();
        int rows = 4;
        for (ZoologieInvertebresInsectes invertebresInsectes : zoologieInvertebresInsectesList) {
            this.wsheet.addCell(new Label(0, rows, invertebresInsectes.getId()));
            this.wsheet.addCell(new Label(1, rows, invertebresInsectes.getPicture()));
            this.wsheet.addCell(new Label(2, rows, invertebresInsectes.getName()));
            this.wsheet.addCell(new Label(3, rows, invertebresInsectes.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, invertebresInsectes.getKind()));
            this.wsheet.addCell(new Label(5, rows, invertebresInsectes.getEspece()));
            this.wsheet.addCell(new Label(6, rows, invertebresInsectes.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, invertebresInsectes.getYear()));
            this.wsheet.addCell(new Label(8, rows, invertebresInsectes.getCountry()));
            this.wsheet.addCell(new Label(9, rows, invertebresInsectes.getCity()));
            this.wsheet.addCell(new Label(10, rows, invertebresInsectes.getPlace()));
            this.wsheet.addCell(new Label(11, rows, invertebresInsectes.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, invertebresInsectes.getManifold()));
            this.wsheet.addCell(new Label(13, rows, invertebresInsectes.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, invertebresInsectes.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, invertebresInsectes.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, invertebresInsectes.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, invertebresInsectes.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, invertebresInsectes.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, invertebresInsectes.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, invertebresInsectes.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, invertebresInsectes.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, invertebresInsectes.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, invertebresInsectes.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, invertebresInsectes.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, invertebresInsectes.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, invertebresInsectes.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, invertebresInsectes.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, invertebresInsectes.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, invertebresInsectes.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, invertebresInsectes.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, invertebresInsectes.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, invertebresInsectes.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, invertebresInsectes.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, invertebresInsectes.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, invertebresInsectes.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, invertebresInsectes.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, invertebresInsectes.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, invertebresInsectes.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, invertebresInsectes.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, invertebresInsectes.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, invertebresInsectes.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, invertebresInsectes.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, invertebresInsectes.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, invertebresInsectes.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, invertebresInsectes.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, invertebresInsectes.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, invertebresInsectes.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, invertebresInsectes.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, invertebresInsectes.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, invertebresInsectes.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, invertebresInsectes.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, invertebresInsectes.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, invertebresInsectes.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieInvertebresMollusque() throws IOException, BiffException, WriteException {
        List<ZoologieInvertebresMollusques> zoologieInvertebresMollusquesList = zoologieInvertebresMollusquesService.findAll();
        int rows = 4;
        for (ZoologieInvertebresMollusques zoologieInvertebresMollusque : zoologieInvertebresMollusquesList) {
            this.wsheet.addCell(new Label(0, rows, zoologieInvertebresMollusque.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieInvertebresMollusque.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieInvertebresMollusque.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieInvertebresMollusque.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieInvertebresMollusque.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieInvertebresMollusque.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieInvertebresMollusque.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieInvertebresMollusque.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieInvertebresMollusque.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieInvertebresMollusque.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieInvertebresMollusque.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieInvertebresMollusque.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieInvertebresMollusque.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieInvertebresMollusque.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieInvertebresMollusque.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieInvertebresMollusque.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieInvertebresMollusque.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieInvertebresMollusque.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieInvertebresMollusque.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieInvertebresMollusque.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieInvertebresMollusque.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieInvertebresMollusque.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieInvertebresMollusque.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieInvertebresMollusque.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieInvertebresMollusque.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieInvertebresMollusque.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieInvertebresMollusque.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieInvertebresMollusque.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieInvertebresMollusque.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieInvertebresMollusque.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieInvertebresMollusque.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieInvertebresMollusque.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieInvertebresMollusque.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieInvertebresMollusque.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieInvertebresMollusque.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieInvertebresMollusque.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieInvertebresMollusque.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieInvertebresMollusque.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieInvertebresMollusque.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieInvertebresMollusque.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieInvertebresMollusque.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieInvertebresMollusque.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieInvertebresMollusque.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieInvertebresMollusque.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieInvertebresMollusque.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieInvertebresMollusque.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieInvertebresMollusque.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieInvertebresMollusque.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieInvertebresMollusque.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieInvertebresMollusque.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieInvertebresMollusque.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieInvertebresMollusque.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieInvertebresMollusque.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieInvertebresMollusque.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresAutres() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresAutres> autresList = zoologieVertebresAutresService.findAll();
        int rows = 4;
        for (ZoologieVertebresAutres zoologieVertebresAutres : autresList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresAutres.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresAutres.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresAutres.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresAutres.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresAutres.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresAutres.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresAutres.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresAutres.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresAutres.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresAutres.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresAutres.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresAutres.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresAutres.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresAutres.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresAutres.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresAutres.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresAutres.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresAutres.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresAutres.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresAutres.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresAutres.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresAutres.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresAutres.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresAutres.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresAutres.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresAutres.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresAutres.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresAutres.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresAutres.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresAutres.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresAutres.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresAutres.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresAutres.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresAutres.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresAutres.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresAutres.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresAutres.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresAutres.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresAutres.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresAutres.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresAutres.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresAutres.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresAutres.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresAutres.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresAutres.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresAutres.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresAutres.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresAutres.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresAutres.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresAutres.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresAutres.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresAutres.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresAutres.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresAutres.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresMammiferes() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresMammiferes> zoologieVertebresMammiferesList = zoologieVertebresMammiferesService.findAll();
        int rows = 4;
        for (ZoologieVertebresMammiferes zoologieVertebresMammiferes : zoologieVertebresMammiferesList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresMammiferes.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresMammiferes.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresMammiferes.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresMammiferes.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresMammiferes.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresMammiferes.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresMammiferes.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresMammiferes.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresMammiferes.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresMammiferes.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresMammiferes.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresMammiferes.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresMammiferes.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresMammiferes.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresMammiferes.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresMammiferes.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresMammiferes.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresMammiferes.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresMammiferes.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresMammiferes.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresMammiferes.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresMammiferes.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresMammiferes.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresMammiferes.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresMammiferes.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresMammiferes.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresMammiferes.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresMammiferes.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresMammiferes.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresMammiferes.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresMammiferes.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresMammiferes.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresMammiferes.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresMammiferes.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresMammiferes.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresMammiferes.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresMammiferes.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresMammiferes.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresMammiferes.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresMammiferes.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresMammiferes.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresMammiferes.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresMammiferes.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresMammiferes.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresMammiferes.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresMammiferes.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresMammiferes.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresMammiferes.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresMammiferes.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresMammiferes.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresMammiferes.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresMammiferes.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresMammiferes.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresMammiferes.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresOiseaux() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresOiseaux> zoologieVertebresOiseauxList = zoologieVertebresOiseauxService.findAll();
        int rows = 4;
        for (ZoologieVertebresOiseaux zoologieVertebresOiseaux : zoologieVertebresOiseauxList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresOiseaux.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresOiseaux.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresOiseaux.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresOiseaux.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresOiseaux.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresOiseaux.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresOiseaux.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresOiseaux.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresOiseaux.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresOiseaux.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresOiseaux.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresOiseaux.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresOiseaux.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresOiseaux.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresOiseaux.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresOiseaux.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresOiseaux.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresOiseaux.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresOiseaux.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresOiseaux.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresOiseaux.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresOiseaux.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresOiseaux.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresOiseaux.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresOiseaux.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresOiseaux.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresOiseaux.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresOiseaux.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresOiseaux.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresOiseaux.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresOiseaux.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresOiseaux.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresOiseaux.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresOiseaux.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresOiseaux.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresOiseaux.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresOiseaux.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresOiseaux.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresOiseaux.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresOiseaux.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresOiseaux.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresOiseaux.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresOiseaux.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresOiseaux.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresOiseaux.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresOiseaux.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresOiseaux.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresOiseaux.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresOiseaux.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresOiseaux.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresOiseaux.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresOiseaux.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresOiseaux.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresOiseaux.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresPoissons() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresPoissons> zoologieVertebresPoissonsList = zoologieVertebresPoissonsService.findAll();
        int rows = 4;
        for (ZoologieVertebresPoissons zoologieVertebresPoissons : zoologieVertebresPoissonsList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresPoissons.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresPoissons.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresPoissons.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresPoissons.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresPoissons.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresPoissons.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresPoissons.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresPoissons.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresPoissons.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresPoissons.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresPoissons.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresPoissons.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresPoissons.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresPoissons.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresPoissons.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresPoissons.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresPoissons.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresPoissons.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresPoissons.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresPoissons.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresPoissons.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresPoissons.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresPoissons.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresPoissons.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresPoissons.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresPoissons.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresPoissons.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresPoissons.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresPoissons.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresPoissons.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresPoissons.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresPoissons.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresPoissons.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresPoissons.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresPoissons.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresPoissons.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresPoissons.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresPoissons.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresPoissons.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresPoissons.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresPoissons.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresPoissons.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresPoissons.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresPoissons.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresPoissons.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresPoissons.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresPoissons.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresPoissons.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresPoissons.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresPoissons.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresPoissons.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresPoissons.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresPoissons.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresPoissons.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresPrimates() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresPrimates> zoologieVertebresPrimatesList = zoologieVertebresPrimatesService.findAll();
        int rows = 4;
        for (ZoologieVertebresPrimates zoologieVertebresPrimates : zoologieVertebresPrimatesList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresPrimates.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresPrimates.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresPrimates.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresPrimates.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresPrimates.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresPrimates.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresPrimates.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresPrimates.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresPrimates.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresPrimates.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresPrimates.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresPrimates.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresPrimates.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresPrimates.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresPrimates.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresPrimates.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresPrimates.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresPrimates.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresPrimates.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresPrimates.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresPrimates.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresPrimates.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresPrimates.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresPrimates.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresPrimates.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresPrimates.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresPrimates.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresPrimates.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresPrimates.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresPrimates.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresPrimates.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresPrimates.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresPrimates.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresPrimates.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresPrimates.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresPrimates.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresPrimates.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresPrimates.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresPrimates.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresPrimates.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresPrimates.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresPrimates.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresPrimates.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresPrimates.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresPrimates.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresPrimates.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresPrimates.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresPrimates.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresPrimates.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresPrimates.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresPrimates.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresPrimates.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresPrimates.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresPrimates.getAnnexe40()));
            rows++;
        }
    }

    @Override
    public void writeFileExcelZoologieVertebresReptile() throws IOException, BiffException, WriteException {
        List<ZoologieVertebresReptile> zoologieVertebresReptileList = zoologieVertebresReptileService.findAll();
        int rows = 4;
        for (ZoologieVertebresReptile zoologieVertebresReptile : zoologieVertebresReptileList) {
            this.wsheet.addCell(new Label(0, rows, zoologieVertebresReptile.getId()));
            this.wsheet.addCell(new Label(1, rows, zoologieVertebresReptile.getPicture()));
            this.wsheet.addCell(new Label(2, rows, zoologieVertebresReptile.getName()));
            this.wsheet.addCell(new Label(3, rows, zoologieVertebresReptile.getGroupe()));
            this.wsheet.addCell(new Label(4, rows, zoologieVertebresReptile.getKind()));
            this.wsheet.addCell(new Label(5, rows, zoologieVertebresReptile.getEspece()));
            this.wsheet.addCell(new Label(6, rows, zoologieVertebresReptile.getAuthor()));
            this.wsheet.addCell(new Label(7, rows, zoologieVertebresReptile.getYear()));
            this.wsheet.addCell(new Label(8, rows, zoologieVertebresReptile.getCountry()));
            this.wsheet.addCell(new Label(9, rows, zoologieVertebresReptile.getCity()));
            this.wsheet.addCell(new Label(10, rows, zoologieVertebresReptile.getPlace()));
            this.wsheet.addCell(new Label(11, rows, zoologieVertebresReptile.getNameCollection()));
            this.wsheet.addCell(new Label(12, rows, zoologieVertebresReptile.getManifold()));
            this.wsheet.addCell(new Label(13, rows, zoologieVertebresReptile.getLocalization()));
            this.wsheet.addCell(new Label(14, rows, zoologieVertebresReptile.getAnnexe1()));
            this.wsheet.addCell(new Label(15, rows, zoologieVertebresReptile.getAnnexe2()));
            this.wsheet.addCell(new Label(16, rows, zoologieVertebresReptile.getAnnexe3()));
            this.wsheet.addCell(new Label(17, rows, zoologieVertebresReptile.getAnnexe4()));
            this.wsheet.addCell(new Label(18, rows, zoologieVertebresReptile.getAnnexe5()));
            this.wsheet.addCell(new Label(19, rows, zoologieVertebresReptile.getAnnexe6()));
            this.wsheet.addCell(new Label(20, rows, zoologieVertebresReptile.getAnnexe7()));
            this.wsheet.addCell(new Label(21, rows, zoologieVertebresReptile.getAnnexe8()));
            this.wsheet.addCell(new Label(22, rows, zoologieVertebresReptile.getAnnexe9()));
            this.wsheet.addCell(new Label(23, rows, zoologieVertebresReptile.getAnnexe10()));
            this.wsheet.addCell(new Label(24, rows, zoologieVertebresReptile.getAnnexe11()));
            this.wsheet.addCell(new Label(25, rows, zoologieVertebresReptile.getAnnexe12()));
            this.wsheet.addCell(new Label(26, rows, zoologieVertebresReptile.getAnnexe13()));
            this.wsheet.addCell(new Label(27, rows, zoologieVertebresReptile.getAnnexe14()));
            this.wsheet.addCell(new Label(28, rows, zoologieVertebresReptile.getAnnexe15()));
            this.wsheet.addCell(new Label(29, rows, zoologieVertebresReptile.getAnnexe16()));
            this.wsheet.addCell(new Label(30, rows, zoologieVertebresReptile.getAnnexe17()));
            this.wsheet.addCell(new Label(31, rows, zoologieVertebresReptile.getAnnexe18()));
            this.wsheet.addCell(new Label(32, rows, zoologieVertebresReptile.getAnnexe19()));
            this.wsheet.addCell(new Label(33, rows, zoologieVertebresReptile.getAnnexe20()));
            this.wsheet.addCell(new Label(34, rows, zoologieVertebresReptile.getAnnexe21()));
            this.wsheet.addCell(new Label(35, rows, zoologieVertebresReptile.getAnnexe22()));
            this.wsheet.addCell(new Label(36, rows, zoologieVertebresReptile.getAnnexe23()));
            this.wsheet.addCell(new Label(37, rows, zoologieVertebresReptile.getAnnexe24()));
            this.wsheet.addCell(new Label(38, rows, zoologieVertebresReptile.getAnnexe25()));
            this.wsheet.addCell(new Label(39, rows, zoologieVertebresReptile.getAnnexe26()));
            this.wsheet.addCell(new Label(40, rows, zoologieVertebresReptile.getAnnexe27()));
            this.wsheet.addCell(new Label(41, rows, zoologieVertebresReptile.getAnnexe28()));
            this.wsheet.addCell(new Label(42, rows, zoologieVertebresReptile.getAnnexe29()));
            this.wsheet.addCell(new Label(43, rows, zoologieVertebresReptile.getAnnexe30()));
            this.wsheet.addCell(new Label(44, rows, zoologieVertebresReptile.getAnnexe31()));
            this.wsheet.addCell(new Label(45, rows, zoologieVertebresReptile.getAnnexe32()));
            this.wsheet.addCell(new Label(46, rows, zoologieVertebresReptile.getAnnexe33()));
            this.wsheet.addCell(new Label(47, rows, zoologieVertebresReptile.getAnnexe34()));
            this.wsheet.addCell(new Label(48, rows, zoologieVertebresReptile.getAnnexe35()));
            this.wsheet.addCell(new Label(49, rows, zoologieVertebresReptile.getAnnexe36()));
            this.wsheet.addCell(new Label(50, rows, zoologieVertebresReptile.getAnnexe37()));
            this.wsheet.addCell(new Label(51, rows, zoologieVertebresReptile.getAnnexe38()));
            this.wsheet.addCell(new Label(52, rows, zoologieVertebresReptile.getAnnexe39()));
            this.wsheet.addCell(new Label(53, rows, zoologieVertebresReptile.getAnnexe40()));
            rows++;
        }
    }
}
