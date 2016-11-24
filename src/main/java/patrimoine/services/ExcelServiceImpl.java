package patrimoine.services;

import jxl.Sheet;
import jxl.Workbook;
import java.io.IOException;
import java.io.File;
import jxl.Cell;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.models.Pedagogique;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    private Workbook workbook = null;

    @Autowired
    PedagogiqueService pedagogiqueService;

    @Override
    public void readFileExcelCollectionImport(String name) throws IOException,BiffException  {
        String path = new File(".").getCanonicalPath()+"\\src\\main\\resources\\static\\files\\";
        workbook = Workbook.getWorkbook(new java.io.File(path+name));
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
}
