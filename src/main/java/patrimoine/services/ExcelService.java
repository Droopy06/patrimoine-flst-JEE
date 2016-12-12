package patrimoine.services;

import jxl.read.biff.BiffException;

import java.io.IOException;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
public interface ExcelService{

    void loadFileExcelCollectionImport(String name) throws IOException, BiffException;
    void readFileExcelCollectionImport() throws IOException, BiffException;
}
