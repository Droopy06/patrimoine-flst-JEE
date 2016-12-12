package patrimoine.services;

import jxl.read.biff.BiffException;

import java.io.IOException;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
public interface ExcelService{

    void loadFileExcelCollectionImport(String name) throws IOException, BiffException;
    void readFileExcelCollectionImport(String object) throws IOException, BiffException;
    void readFileExcelHerbiers() throws IOException, BiffException;
    void readFileExcelInstruments() throws IOException, BiffException;
    void readFileExcelJardinBotanique() throws IOException, BiffException;
    void readFileExcelMaterielPedagogique() throws IOException, BiffException;
    void readFileExcelMineralogieCristallographie() throws IOException, BiffException;
    void readFileExcelOuvragesCartesDocuments() throws IOException, BiffException;
    void readFileExcelPaleontogieAnimale() throws IOException, BiffException;
    void readFileExcelPaleontogieVegetale() throws IOException, BiffException;
    void readFileExcelPedagogique() throws IOException, BiffException;
    void readFileExcelPetrographie() throws IOException, BiffException;
    void readFileExcelPhysique() throws IOException, BiffException;
    void readFileExcelTypotheque() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresAutres() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresInsectes() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresMollusque() throws IOException, BiffException;
    void readFileExcelZoologieVertebresAutres() throws IOException, BiffException;
    void readFileExcelZoologieVertebresMammiferes() throws IOException, BiffException;
    void readFileExcelZoologieVertebresOiseaux() throws IOException, BiffException;
    void readFileExcelZoologieVertebresPoissons() throws IOException, BiffException;
    void readFileExcelZoologieVertebresPrimates() throws IOException, BiffException;
    void readFileExcelZoologieVertebresReptile() throws IOException, BiffException;
}
